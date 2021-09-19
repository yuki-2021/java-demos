<template>
  defaults/interceptors
</template>

<script>
// @ is an alias to /src
import axios  from 'axios'

export default {
  name: 'Home',
  mounted() {

    /* 
      一些接口
      // http://123.207.32.32:8000/home/multidata
      // https://httpbin.org
    */
    


    // ====================  全局拦截器  ==================== 
    axios.interceptors.request.use((config) => {
        console.log("req success-----");
        console.log(config);
        return  config; // 一定要放回Config
    }, (config) => {
        console.log("req fail-----");
        console.log(config);
        return Promise.reject(config);
    });
    axios.interceptors.response.use((res) => {
        console.log("res success-----");
        console.log(res);
        return res
    }, (res) => {
        console.log("res fail-----");
        console.log(res);
        return Promise.reject(res);
    })


    // ====================  全局配置 ===========================
    axios.defaults.baseURL = 'https://httpbin.org';



    // post --- axios()
    axios.post('/anything',{
      name: 'admin',
      passwrd: 'admin'
    })
    .then(res => {
      console.log("----------- success  ----------");
      console.log(res);
    })
    .catch(err => {
      console.log("----------- catch  ----------");
      console.log(err);
    })

  }
}
</script>
