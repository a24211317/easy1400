import request from '@/utils/request'

// 预览生成代码
export function getApesPage(data) {
    return request({
      url: '/VIID/APEs',
      method: 'get',
      params: data
    })
  }