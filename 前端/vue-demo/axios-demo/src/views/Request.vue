<template>
    axios() / 别名 / axios.all()
</template>

<script>
import axios from 'axios'
export default {
    name: 'Axios',
    mounted() {
        // axios() --- 多个请求
        axios.all([
            axios.get("https://httpbin.org//anything?id=1"),
            axios.get("https://httpbin.org//anything?id=1")
        ])
        .then(res => {
            console.log(res);
        })

        // axios() -- axios()方法
        axios({
            baseURL: 'https://httpbin.org/', // 基础路径
            url: 'anything', // 路径
            method: 'post',  // 方式方法
            timeout: 5000,   // 超时时间 - 单位ms 1s = 1000ms
            responseType: 'application/json',
            headers: { 'Content-Type': 'application/xml' },
            data: { firstname: 'admin', password: 'admin' }
        })
        .then(res => {
            console.log(res);
        })


        // axios -- 别名
        axios.post('/anything',{
                name: 'admin',
                passwd: 'admin'
            },{
                baseURL: 'https://httpbin.org'
            }
        )
        .then(res => {
            console.log(res);
        })

    }
}

</script>

<style>

</style>
