import request from '@/utils/request'

// 预览生成代码
export function getMotorVehiclePage(data) {
    return request({
      url: '/VIID/MotorVehicles/'+data.page+'/'+data.rows,
      method: 'get',
      params: data
    })
  }