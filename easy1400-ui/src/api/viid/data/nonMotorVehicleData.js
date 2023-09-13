import request from '@/utils/request'

// 预览生成代码
export function getNonMotorVehiclePage(data) {
    return request({
      url: '/VIID/nonMotorVehicles/'+data.page+'/'+data.rows,
      method: 'get',
      params: data
    })
  }