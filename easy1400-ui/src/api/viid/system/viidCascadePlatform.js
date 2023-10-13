import request from '@/utils/request'

// 查询级联平台
export function getViidCascadePlatforms(data) {
  return request({
    url: '/VIID/Platform/ViidCascadePlatform',
    method: 'get',
    params: data
  })
}

// 添加级联平台
export function addViidCascadePlatform(data) {
  return request({
    url: '/VIID/Platform/ViidCascadePlatform',
    method: 'post',
    data: data
  })
}

// 删除级联平台
export function delViidCascadePlatform(id) {
  return request({
    url: '/VIID/Platform/ViidCascadePlatform/' + id,
    method: 'delete',
  })
}
// 删除级联平台
export function updateViidCascadePlatform(data) {
  return request({
    url: '/VIID/Platform/ViidCascadePlatform',
    method: 'put',
    data:data
  })
}
