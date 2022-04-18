<template>
  <el-container>
    <el-header>
      <el-row>
        <el-button type="primary" icon="el-icon-plus" style=" margin-top: 15px;float: left;margin-right: 10px;" @click="handleInsert()">新增</el-button>
      </el-row>
    </el-header>
    <el-main>
      <el-table
        :data="tableData"
        style="width: 100%">
        <el-table-column
          label="序号"
          prop="id">
        </el-table-column>
        <el-table-column
          label="联系人姓名"
          prop="name">
        </el-table-column>
        <el-table-column
          label="手机号"
          prop="phone">
        </el-table-column>
        <el-table-column
          label="是否离职"
          prop="isLeft">
        </el-table-column>
        <el-table-column
          label="联系人地址"
          prop="address">
        </el-table-column>
        <el-table-column
          label="创建者"
          prop="creater">
        </el-table-column>
        <el-table-column
          label="创建时间"
          prop="create_time">
        </el-table-column>
        <el-table-column
          label="更新者"
          prop="creater">
        </el-table-column>
        <el-table-column
          label="更新时间"
          prop="update_time">
        </el-table-column>
        <el-table-column
          width="200px"
          align="right">
          <template slot="header" slot-scope="scope">
            <el-input
              v-model="search"
              size="mini"
              placeholder="输入关键字搜索">
              <el-button slot="append" icon="el-icon-search" @click="goSearch()"></el-button>
            </el-input>
          </template>
          <template slot-scope="scope">
            <el-button
              size="mini"
              @click="handleEdit(scope.row)">修改</el-button>
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.row)">删除</el-button>
          </template>
        </el-table-column>
        <template>
          <el-dialog title="添加联系人" width="600px" :visible.sync="insertFlag" @close="cloeDialog()" append-to-body>
            <el-form ref="contact"  label-width="100px">
              <el-form-item label="联系人姓名" label-width="100px">
                <el-input v-model="contact.name"></el-input>
              </el-form-item>
              <el-form-item label="联系人手机号" label-width="100px">
                <el-input v-model="contact.phone"></el-input>
              </el-form-item>
              <el-form-item label="是否离职" label-width="100px">
                <el-select v-model="contact.isLeft" placeholder="请选择">
                  <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="地址" label-width="100px">
                <el-cascader
                  size="large"
                  :options="addressOptions"
                  v-model="selectedOptions"
                  filterable
                  clearable
                  @change="handleChange">
                </el-cascader>
              </el-form-item>
              <el-form-item label="创建者" label-width="100px">
                <el-input @change="changePerson()" v-model="contact.creater"></el-input>
              </el-form-item>
              <el-form-item label="修改者" label-width="100px">
                <el-input :disabled="true" v-model="contact.updater"></el-input>
              </el-form-item>
              <el-button type="primary" @click="insertContact()">添加联系人</el-button>
            </el-form>
          </el-dialog>
        </template>
        <template>
          <el-dialog title="修改联系人" width="600px" :visible.sync="updateFlag" @close="closeDialog()" append-to-body>
            <el-form ref="contact"  label-width="100px">
              <el-form-item label="联系人姓名" label-width="100px">
                <el-input v-model="contact.name"></el-input>
              </el-form-item>
              <el-form-item label="联系人手机号" label-width="100px">
                <el-input v-model="contact.phone"></el-input>
              </el-form-item>
              <el-form-item label="是否离职" label-width="100px">
                <el-select v-model="contact.isLeft" placeholder="请选择">
                  <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="地址" label-width="100px">
                <el-cascader
                  size="large"
                  :options="addressOptions"
                  v-model="selectedOptions"
                  @change="handleChange">
                </el-cascader>
              </el-form-item>
              <el-form-item label="创建者" label-width="100px">
                <el-input  :disabled="true" v-model="contact.creater"></el-input>
              </el-form-item>
              <el-form-item label="修改者" label-width="100px">
                <el-input  v-model="contact.updater"></el-input>
              </el-form-item>
              <el-button type="primary" @click="updateContact()">修改联系人</el-button>
            </el-form>
          </el-dialog>
        </template>
      </el-table>
      <pagination
        v-show="total>0"
        :total="total"
        :page.sync="queryParams.pageNum"
        :limit.sync="queryParams.pageSize"
        @pagination="getList"
      />
    </el-main>
  </el-container>
</template>

<script>
import {getAllContact,insertContact,deleteContact,updateContact,searchContact,selectContactById} from "@/api/topcrm/contact/contact"
import {parseTime} from "@/utils/top"
import {CodeToText, regionDataPlus} from "element-china-area-data";

export default {
  data() {
    return {
      addressOptions:regionDataPlus,
      selectedOptions: [],
      options: [{
        value: '是',
        label: '是'
      }, {
        value: '否',
        label: '否'
      }],
      tableData: [{
        id: '',
        name:'',
        phone: '',
        isLeft:'',
        address: '',
        creater:'',
        create_time:'',
        updater:'',
        update_time:''
      }, {
        id: '',
        name:'',
        phone: '',
        isLeft:'',
        address: '',
        creater:'',
        create_time:'',
        updater:'',
        update_time:''
      }],
      search: '',
      loading:false,
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        status: undefined,
        deptId: undefined,
        userName: undefined,
        phonenumber: undefined
      },
      total:0,
      insertFlag:false,
      updateFlag:false,
      updateId:'',
      contact:{
        id: '',
        name:'',
        phone: '',
        isLeft:'',
        address: '',
        creater:'',
        create_time:'',
        updater:'',
        update_time:''
      }
    }
  },
  created() {
      this.getList();
    },
  methods: {
    getList(){
      this.loading=true;
      getAllContact(this.addDateRange(this.queryParams,this.dataRange)).then(response=>{
        this.tableData=response.rows;
        for (var i=0;i<this.tableData.length;i++){
          this.tableData[i].create_time=parseTime(this.tableData[i].create_time);
          this.tableData[i].update_time=parseTime(this.tableData[i].update_time);
        }
        this.total=response.total;
        this.loading=false;
      })
    },
    changeDate(){
      this.contact.update_time=this.contact.create_time;
    },
    goSearch(){
      this.loading=true;
      if (this.search!='' & this.search!=null){
        searchContact(this.search).then(response=>{
          this.tableData=response.rows;
          for (var i=0;i<this.tableData.length;i++){
            this.tableData[i].create_time=parseTime(this.tableData[i].create_time);
            this.tableData[i].update_time=parseTime(this.tableData[i].update_time);
          }
          this.total=response.total;
          this.loading=false;
        })
      }else{
        this.getList();
      }
    },
    handleChange(value){
      let address='';
      console.log(value)
      // console.log(CodeToText[this.selectedOptions[2]])
      for (var i=0;i<this.selectedOptions.length;i++){
        address=address+CodeToText[this.selectedOptions[i]];
      }
      this.contact.address=address;

    },
    changePerson(){
      this.contact.updater=this.contact.creater;
    },
    cloeDialog(){
      this.insertFlag=false;
    },
    closeDialog(){
      this.updateFlag=false;
    },
    insertContact(){
      this.loading=true;
      console.log(this.contact)
      insertContact(this.contact).then(response=>{
        this.insertFlag=false;
        this.loading=false;
        this.getList();
        this.contact.name='';
        this.contact.address='';
        this.contact.isLeft='';
        this.contact.phone='';
        this.contact.creater='';
        this.contact.updater='';
        this.selectedOptions='';
      })
    },
    updateContact(){
      this.loading=true;
      this.$confirm(`此操作将永久修改联系人信息,是否继续?`,'提示',{
        confirmButtonText:'确认',
        cancelButtonText:'取消',
        type:'warning'
      }).then(()=>{updateContact(this.contact,this.updateId).then(response=>{
          if (response.code==200){
            this.loading=false;
            this.updateFlag=false;
            this.updateId='';
            this.selectedOptions='';
            this.getList();
          }
        })

        }
      ).catch(()=>{
        this.$message({
          type:"info",
          message:'已取消修改'
        });
      })
    },
    handleInsert(){
      this.insertFlag=true;
    },
    handleEdit(row) {
      this.updateFlag=true;
      this.updateId=row.id;
      selectContactById(this.updateId).then(response=>{
        // console.log(response);
        this.contact.id=response.data.id;
        this.contact.updater=response.data.updater;
        this.contact.isLeft=response.data.isLeft;
        this.contact.name=response.data.name;
        this.contact.phone=response.data.phone;
        this.contact.creater=response.data.creater;
        this.contact.address=response.data.address;
      })
    },
    handleDelete(row) {
      this.$confirm(`此操作将永久删除联系人信息,是否继续?`,'提示',{
        confirmButtonText:'确定',
        cancelButtonText:'取消',
        type:'warning'
      }).then(()=>
        deleteContact(row.id).then(response=>{
          if (response.code==200){
            this.getList();
            this.$message({
              type:"info",
              message:'删除联系人成功'
            })
          }
        })
      ).catch(()=>{
        this.$message({
          type:"info",
          message:'已取消删除'
        });
    })
  },
}}
</script>
