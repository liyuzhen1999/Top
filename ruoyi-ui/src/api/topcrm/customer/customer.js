import request from '@/utils/request'

export function getAllCustomer(query){
  return request({
    url:'/customer/list',
    method:'get',
    params:query
  })
}
export function updateCustomer(customer,id){
   return request({
     url:'/customer/update/'+id,
     method:'post',
     data:customer
   })
}
export function deleteCustomer(id){
  return request({
    url:'/customer/delete/'+id,
    method:'delete'
  })
}
export function addCustomer(customer){
  return request({
    url:'/customer/add',
    method:'post',
    data:customer
  })
}
export function searchCustomer(searchParam){
  return request({
    url:'/customer/search/'+searchParam,
    method:'get'
  })
}
export function selectCustomerById(id){
  return request({
    url:'/customer/select/'+id,
    method:'get'
  })
}
