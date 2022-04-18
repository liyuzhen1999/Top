<template>

</template>

<script>
import {getView} from "@/api/topcrm/customerTocontact/customerTocontact";

export default {
  name: "index",
  data(){
    return{
      loading:false,
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        status: undefined,
        deptId: undefined,
        userName: undefined,
        phonenumber: undefined
      }
    }
  },
  created() {
    this.getList();
  },
  methods:{
    getList(){
        this.loading=true;
        getView(this.addDateRange(this.queryParams,this.dataRange)).then(response=>{
          console.log(response)
          }
        )
    },
  },
}
</script>

<style scoped>

</style>
