import request from '@/utils/request'

// 预览生成代码
export function getFacePage(data) {
    return request({
      url: '/VIID/faces/'+data.page+'/'+data.rows,
      method: 'get',
      params: data
    })
  }