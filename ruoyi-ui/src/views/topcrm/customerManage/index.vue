<template>
  <el-container>
    <el-header>
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
              v-model="search"
              size="mini"
              placeholder="输入关键字搜索"/>
          </template>
          <template slot-scope="scope">
            <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">修改</el-button>
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-main>
  </el-container>
</template>

<script>
import {getAllCustomer} from "@/api/topcrm/customer/customer"
export default {
  data() {
    return {
      loading:false,
      tableData: [{
        id:'1',
        customer_name: '山东道普信息技术有限公司',
        customer_phone: '12345678901',
        customer_email:'123@qq.com',
        customer_address:'山东省济南市历城区山东建筑大学',
        customer_fax:'0531-6666666',
        customer_representor:'张三',
        customer_post:'经理',
        contact_id:'1',
        contact_name:'小红'
      }],
      search: '',
      total:0,
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        status: undefined,
        deptId: undefined
      },
    }
  },
  created(){
    this.getList();
  },
  methods: {
    getList(){
      this.loading=true;
      getAllCustomer(this.addDateRange(this.queryParams,this.dataRange)).then(response =>{
        console.log(response.rows)
        this.tableData=response.rows;
        this.total=response.total;
        this.loading=false;
        }
      )
    }
    ,
    handleEdit(index, row) {
      console.log(index, row);
    },
    handleDelete(index, row) {
      console.log(index, row);
    }
  },
}
</script>

<style scoped>

</style>
