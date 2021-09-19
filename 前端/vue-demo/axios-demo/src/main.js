import { createApp } from 'vue'
import App from './App.vue'
import router from './router'


import { Axios, AxiosAsync } from './utils/request'
const app = createApp(App).use(router)

// 定义$http
app.config.globalProperties.$http = Axios
// 挂载
app.mount('#app')
