import axios from "axios"

export const Axios =  function(options) {
    // 1. 定义$http
    const $http = axios.create({
        // baseURL
        baseURL: 'https://httpbin.org',
    })
    // 响应拦截器
    $http.interceptors.response.use(res => res.data, error => Promise.reject(error));
    // 2. 发请求
    return  $http(options);
}

export const AxiosBak = function axiosBak() {
    // 1. 定义$http
    const $http = axios.create({
        // baseURL
        baseURL: 'https://httpbin.org',
    })
    // 响应拦截器
    $http.interceptors.response(res => res.data, error => Promise.reject(error));
    // 2. 发请求
    $http(options)
        .then(res => resolve(res))
        .catch(rs => reject(res))
}