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
          label="客户代表"
          prop="customer_representor"
        ></el-table-column>
        <el-table-column
          label="代表职务"
          prop="customer_post"
        ></el-table-column>
        <el-table-column
          label="联系人序号"
          prop="contact_id"
        ></el-table-column>
        <el-table-column
          label="联系人姓名"
          prop="contact_name"
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
            <el-form ref="customer" label-width="100px">
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
                <el-input v-model="customer.customer_address"></el-input>
              </el-form-item>
              <el-form-item label="客户传真" label-width="100px">
                <el-input v-model="customer.customer_fax"></el-input>
              </el-form-item>
              <el-form-item label="客户代表" label-width="100px">
                <el-input v-model="customer.customer_representor"></el-input>
              </el-form-item>
              <el-form-item label="客户职务" label-width="100px">
                <el-input v-model="customer.customer_post"></el-input>
              </el-form-item>
              <el-form-item label="联系人序号" label-width="100px">
                <el-input v-model="customer.contact_id"></el-input>
              </el-form-item>
              <el-form-item label="联系人姓名" label-width="100px">
                <el-input v-model="customer.contact_name"></el-input>
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
            <el-form ref="customer" label-width="100px">
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
                <el-input v-model="customer.customer_address"></el-input>
              </el-form-item>
              <el-form-item label="客户传真" label-width="100px">
                <el-input v-model="customer.customer_fax"></el-input>
              </el-form-item>
              <el-form-item label="客户代表" label-width="100px">
                <el-input v-model="customer.customer_representor"></el-input>
              </el-form-item>
              <el-form-item label="客户职务" label-width="100px">
                <el-input v-model="customer.customer_post"></el-input>
              </el-form-item>
              <el-form-item label="联系人序号" label-width="100px">
                <el-input v-model="customer.contact_id"></el-input>
              </el-form-item>
              <el-form-item label="联系人姓名" label-width="100px">
                <el-input v-model="customer.contact_name"></el-input>
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
export default {
  data() {
    return {
      updateflag:false,
      influentId:'',
      loading:false,
      insertflag:false,
      tableData: [{
        id:'1',
        customer_name: '山东道普信息技术有限公司',
        customer_phone: '12345678901',
        customer_email:'123@qq.com',
        customer_address:'山东省济南市历城区山东建筑大学',
        customer_fax:'0531-6666666',
        customer_represent:'张三',
        customer_post:'经理',
        contact_id:'1',
        contact_name:'小红'
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
        contact_name:''
      }
    }
  },
  created(){
    this.getList();
  },
  methods: {
    getList(){
      this.loading=true;
      getAllCustomer(this.addDateRange(this.queryParams,this.dataRange)).then(response =>{
        // console.log(response.rows[0])
        this.tableData=response.rows;
        this.total=response.total;
        this.loading=false;
        }
      )
    }
    ,
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
      console.log(row.id);
      this.updateflag=true;
      this.influentId=row.id;
      selectCustomerById(this.influentId).then(response=>{
        console.log(response.rows[0])
        this.customer.contact_name=response.rows[0].contact_name;
        this.customer.customer_address=response.rows[0].customer_address;
        this.customer.customer_email=response.rows[0].customer_email;
        this.customer.customer_name=response.rows[0].customer_name;
        this.customer.customer_fax=response.rows[0].customer_fax;
        this.customer.customer_representor=response.rows[0].customer_representor;
        this.customer.contact_id=response.rows[0].contact_id;
        this.customer.customer_post=response.rows[0].customer_post;
        this.customer.customer_phone=response.rows[0].customer_phone;
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
