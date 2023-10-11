import request from '@/utils/request'

// 预览生成代码
export function getViidCascadePlatforms(type) {
    return request({
      url: '/VIID/Platform/ViidCascadePlatform/'+type,
      method: 'get'
    })
  }