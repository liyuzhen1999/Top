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
        style="width: 100%;">
        <el-table-column
        label="序号"
        prop="id"
        ></el-table-column>
        <el-table-column
        label="客户名称"
        prop="customer_name"
        ></el-table-column>
        <el-table-column
        label="客户手机号"
        prop="customer_phone"
        >
        </el-table-column>
        <el-table-column
          label="客户邮箱"
          prop="customer_email"
        ></el-table-column>
        <el-table-column
          label="客户地址"
          prop="customer_address"
        ></el-table-column>
        <el-table-column
          label="客户传真"
          prop="customer_fax"
        ></el-table-column>
        <el-table-column
          label="客户代表人"
          prop="customer_representor"
        ></el-table-column>
        <el-table-column
          label="代表人职务"
          prop="customer_post"
        ></el-table-column>
        <el-table-column
          label="负责人序号"
          prop="contact_id"
        ></el-table-column>
        <el-table-column
          label="负责人姓名"
          prop="contact_name"
        ></el-table-column>
        <el-table-column
          label="创建者"
          prop="creater"
        >
        </el-table-column>
        <el-table-column
          label="创建时间"
          prop="create_time"
        >
        </el-table-column>
        <el-table-column
          label="修改者"
          prop="updater"
        ></el-table-column>
        <el-table-column
          label="修改时间"
          prop="update_time"
        ></el-table-column>
        <el-table-column
          align="right"
          width="240px"
        >
          <template slot="header" slot-scope="scope">
            <el-input
              v-model="searchParam"
              size="mini"
              placeholder="输入关键字搜索"
            >
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
          <el-dialog title="修改客户信息" :visible="updateflag" width="600px" @close="closeDialog()" append-to-body>
            <el-form ref="customer"  label-width="100px">
              <el-form-item label="客户姓名" prop="customer_name" label-width="100px">
                <el-input v-model="customer.customer_name"></el-input>
              </el-form-item>
              <el-form-item label="客户手机号" label-width="100px">
                <el-input v-model="customer.customer_phone"></el-input>
              </el-form-item>
              <el-form-item label="客户邮箱" label-width="100px">
                <el-input v-model="customer.customer_email"></el-input>
              </el-form-item>
              <el-form-item label="客户地址" label-width="100px">
                <el-cascader
                  size="large"
                  :options="options"
                  v-model="selectedOptions"
                  @change="handleChange">
                </el-cascader>
              </el-form-item>
              <el-form-item label="客户传真" label-width="100px">
                <el-input v-model="customer.customer_fax"></el-input>
              </el-form-item>
              <el-form-item label="客户代表人" label-width="100px">
                <el-input v-model="customer.customer_representor"></el-input>
              </el-form-item>
              <el-form-item label="客户职务" label-width="100px">
                <el-input v-model="customer.customer_post"></el-input>
              </el-form-item>
              <el-form-item label="联系人序号" label-width="100px">
                <el-select v-model="customer.contact_id" @change="changeSelect()" placeholder="请选择">
                  <el-option
                    v-for="item in option"
                    :key="item.index"
                    :label="item.id"
                    :value="item.id">
                  </el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="联系人姓名" label-width="100px">
                <el-input v-model="customer.contact_name"></el-input>
              </el-form-item>
              <el-form-item label="创建者" label-width="100px">
                <el-input  :disabled="true" v-model="customer.creater"></el-input>
              </el-form-item>
              <el-form-item label="修改者" label-width="100px">
                <el-input  v-model="customer.updater"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="submitUpdate()">
                  提交修改
                </el-button>
              </el-form-item>
            </el-form>
          </el-dialog>
        </template>
        <template>
          <el-dialog title="添加客户" :visible="insertflag" width="600px" @close="closeInsertDialog()" append-to-body>
            <el-form ref="customer"  label-width="100px">
              <el-form-item label="客户姓名" label-width="100px">
                <el-input v-model="customer.customer_name"></el-input>
              </el-form-item>
              <el-form-item label="客户手机号" label-width="100px">
                <el-input v-model="customer.customer_phone"></el-input>
              </el-form-item>
              <el-form-item label="客户邮箱" label-width="100px">
                <el-input v-model="customer.customer_email"></el-input>
              </el-form-item>
              <el-form-item label="客户地址" label-width="100px">
                <el-cascader
                  size="large"
                  :options="options"
                  v-model="selectedOptions"
                  @change="handleChange">
                </el-cascader>
              </el-form-item>
              <el-form-item label="客户传真" label-width="100px">
                <el-input v-model="customer.customer_fax"></el-input>
              </el-form-item>
              <el-form-item label="客户代表人" label-width="100px">
                <el-input v-model="customer.customer_representor"></el-input>
              </el-form-item>
              <el-form-item label="代表人职务" label-width="100px">
                <el-input v-model="customer.customer_post"></el-input>
              </el-form-item>
              <el-form-item label="联系人序号" label-width="100px">
                <el-select v-model="customer.contact_id" @change="changeSelect()" placeholder="请选择">
                  <el-option
                    v-for="item in option"
                    :key="item.index"
                    :label="item.id"
                    :value="item.id">
                  </el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="联系人姓名" label-width="100px">
                <el-input :disabled="true" v-model="customer.contact_name"></el-input>
              </el-form-item>
              <el-form-item label="创建者" label-width="100px">
                <el-input @change="changePerson()" v-model="customer.creater"></el-input>
              </el-form-item>
              <el-form-item label="修改者" label-width="100px">
                <el-input :disabled="true" v-model="customer.updater"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="submitInsert()">
                  提交新增
                </el-button>
              </el-form-item>
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
import {getAllCustomer,updateCustomer,deleteCustomer,addCustomer,searchCustomer,selectCustomerById} from "@/api/topcrm/customer/customer"
import { regionDataPlus,CodeToText,TextToCode } from 'element-china-area-data'
import {parseTime} from "@/utils/top";
import {selectIdAndName} from "@/api/topcrm/contact/contact";

export default {
  data() {
    return {
      updateflag:false,
      influentId:'',
      option: [],
      loading:false,
      insertflag:false,
      options: regionDataPlus,
      selectedOptions: [],
      tableData: [{
        id:'',
        customer_name: '',
        customer_phone: '',
        customer_email:'',
        customer_address:'',
        customer_fax:'',
        customer_represent:'',
        customer_post:'',
        contact_id:'',
        contact_name:'',
        creater:'',
        create_time:'',
        updater:'',
        update_time:''
      }],
      searchParam: '',
      total:0,
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        status: undefined,
        deptId: undefined,
        userName: undefined,
        phonenumber: undefined
      },
      customer:{
        customer_name: '',
        customer_phone: '',
        customer_email:'',
        customer_address:'',
        customer_fax:'',
        customer_representor:'',
        customer_post:'',
        contact_id:'',
        contact_name:'',
        creater:'',
        create_time:'',
        updater:'',
        update_time:''
      },
    }
  },
  created(){
    this.getList();
    selectIdAndName().then(res=>{
      for (var i=0;i<res.rows.length;i++){
        this.option.push(res.rows[i])

      }
      // console.log(this.option)
    })
  },
  methods: {
    changeSelect(){
      for (var i=0;i<this.option.length;i++){
        if(this.option[i].id==this.customer.contact_id){
          this.customer.contact_name=this.option[i].name;
        }
      }
    },
    changePerson(){
      this.customer.updater=this.customer.creater;
    },
    getList(){
      this.loading=true;
      getAllCustomer(this.addDateRange(this.queryParams,this.dataRange)).then(response =>{
        this.tableData=response.rows;
        this.total=response.total;
        for (var i=0;i<this.tableData.length;i++){
          this.tableData[i].create_time=parseTime(this.tableData[i].create_time);
          this.tableData[i].update_time=parseTime(this.tableData[i].update_time);
        }
        this.loading=false;
        }
      )
    },
    handleChange(){
      let address='';
      for (var i=0;i<this.selectedOptions.length;i++){
        address=address+CodeToText[this.selectedOptions[i]];
      }
      this.customer.customer_address=address;
    },
    submitUpdate(){
      this.$confirm(`此操作将永久修改客户信息,是否继续?`,'提示',{
          confirmButtonText:'确定',
          cancelButtonText:'取消',
          type:'warning'
        }
      ).then(()=>{
          this.loading=true;
          updateCustomer(this.customer,this.influentId).then(res=>{
            if (res.code==200){
              this.loading=false;
              this.updateflag=false;
              this.influentId='';
              this.customer.customer_name='';
              this.customer.customer_post='';
              this.customer.customer_representor='';
              this.customer.customer_fax='';
              this.customer.customer_phone='';
              this.customer.customer_email='';
              this.customer.customer_address='';
              this.customer.contact_id='';
              this.customer.contact_name='';
              this.customer.updater='';
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
    submitInsert(){
      this.$confirm(`请检查信息是否有误，如若无误，请确认新增客户?`,'提示',{
          confirmButtonText:'确定',
          cancelButtonText:'取消',
          type:'warning'
        }
      ).then(
        ()=>{
          this.loading=true;
          addCustomer(this.customer).then(res=>{
            if (res.code==200){
              this.loading=false;
              this.insertflag=false;
              this.influentId='';
              this.customer.customer_name='';
              this.customer.customer_post='';
              this.customer.customer_representor='';
              this.customer.customer_fax='';
              this.customer.customer_phone='';
              this.customer.customer_email='';
              this.customer.customer_address='';
              this.customer.contact_id='';
              this.customer.contact_name='';
              this.customer.creater='';
              this.customer.updater='';
              this.customer.create_time='';
              this.customer.update_time='';
              this.selectedOptions='';
              this.getList();
            }
          })
        }
      ).catch(()=>{
        this.$message({
          type:"info",
          message:'已取消新增客户'
        });
      })
    },
    closeDialog(){
      this.updateflag=false;
    },
    closeInsertDialog(){
      this.insertflag=false;
    },
    handleEdit(row) {
      this.updateflag=true;
      this.influentId=row.id;
      selectCustomerById(this.influentId).then(response=>{
        this.customer.contact_name=response.rows[0].contact_name;
        this.customer.customer_address=response.rows[0].customer_address;
        this.customer.customer_email=response.rows[0].customer_email;
        this.customer.customer_name=response.rows[0].customer_name;
        this.customer.customer_fax=response.rows[0].customer_fax;
        this.customer.customer_representor=response.rows[0].customer_representor;
        this.customer.contact_id=response.rows[0].contact_id;
        this.customer.customer_post=response.rows[0].customer_post;
        this.customer.customer_phone=response.rows[0].customer_phone;
        this.customer.creater=response.rows[0].creater;
        this.customer.updater=response.rows[0].updater;
      })
      // console.log(row.id);
    },
    handleDelete(row) {
      this.influentId=row.id;
      // console.log(row);
      this.$confirm(`此操作将永久删除客户信息,是否继续?`,'提示',{
          confirmButtonText:'确定',
          cancelButtonText:'取消',
          type:'warning'
        }
      ).then(()=>{
        this.loading=true;
        deleteCustomer(this.influentId).then(res=>{
          if (res.code==200){
            this.loading=false;
            this.influentId='';
            this.$message({
              type:"info",
              message:'删除客户成功'
            })
            this.getList();
          }
        })
      }).catch(()=>{
        this.$message({
          type:"info",
          message:'已取消删除'
        });
      })
    },
    handleInsert(){
      this.insertflag=true;
    },
    goSearch(){
      // console.log(this.searchParam);
      if (this.searchParam!='' & this.searchParam!=null){
        this.loading=true;
        searchCustomer(this.searchParam).then(response=>{
          this.tableData=response.rows;
          for (var i=0;i<this.tableData.length;i++){
            this.tableData[i].create_time=parseTime(this.tableData[i].create_time);
            this.tableData[i].update_time=parseTime(this.tableData[i].update_time);
          }
          this.loading=false;
        })
      }else{
        this.getList()
      }

    }
  },
}
</script>

<style scoped>

</style>
