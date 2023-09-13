import request from '@/utils/request'

// 预览生成代码
export function getPersonPage(data) {
    return request({
      url: '/VIID/persons/'+data.page+'/'+data.rows,
      method: 'get',
      params: data
    })
  }