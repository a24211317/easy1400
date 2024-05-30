import request from '@/utils/request'

// 查询订阅信息
export function getViidSubscribe(data) {
  return request({
    url: '/VIID/Subscribe/ViidSubscribe',
    method: 'get',
    params: data
  })
}

// 添加订阅信息
export function addviidSubscribe(data) {
  return request({
    url: '/VIID/Subscribe/ViidSubscribe',
    method: 'post',
    data: data
  })
}

// 删除级联平台
export function delviidSubscribe(id) {
  return request({
    url: '/VIID/Subscribe/ViidSubscribe/' + id,
    method: 'delete',
  })
}