import request from '@/utils/request'

export function getAllContact(query){
 return request({
   url:'/contact/list',
   method:'get',
   params:query
 })
}
export function insertContact(contact){
  return request({
    url:'/contact/add',
    method:'post',
    data:contact
  })
}
export function deleteContact(id){
  return request({
    url:'/contact/delete/'+id,
    method:'delete'
  })
}
export function updateContact(contact,id){
  return request({
    url:'/contact/update/'+id,
    method:'post',
    data:contact
  })
}
export function searchContact(searchKey){
  return request({
    url:'/contact/search/'+searchKey,
    method:'get'
  })
}
export function selectContactById(id){
  return request({
    url:'/contact/getContact/'+id,
    method:'get'
  })
}
export function selectIdAndName(){
  return request({
    url:'/contact/IdAndName',
    method:'get'
  })
}
