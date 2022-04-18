import request from "@/utils/request";

export function getView(query){
  return request({
    url:"/customerToContact/list",
    method:'get',
    data:query
  })
}
