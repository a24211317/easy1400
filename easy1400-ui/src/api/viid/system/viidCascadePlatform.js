import request from '@/utils/request'

// 查询级联平台
export function getViidCascadePlatforms(data) {
    return request({
      url: '/VIID/Platform/ViidCascadePlatform',
      method: 'get',
      params:data
    })
  }

  // 添加级联平台
export function addViidCascadePlatforms(data) {
  return request({
    url: '/VIID/Platform/ViidCascadePlatform',
    method: 'post',
    data:data
  })
}