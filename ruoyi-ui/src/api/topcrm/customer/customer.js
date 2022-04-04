import request from '@/utils/request'

export function getAllCustomer(query){
  return request({
    url:'/customer/list',
    method:'get',
    params:query
  })
}
