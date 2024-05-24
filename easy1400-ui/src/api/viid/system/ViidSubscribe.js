import request from '@/utils/request'

// 查询订阅信息
export function getViidSubscribe(data) {
  return request({
    url: '/VIID/Subscribe/ViidSubscribe',
    method: 'get',
    params: data
  })
}

// 添加级联平台
export function addviidSubscribeform(data) {
  return request({
    url: '/VIID/Subscribe/ViidSubscribe',
    method: 'post',
    data: data
  })
}
