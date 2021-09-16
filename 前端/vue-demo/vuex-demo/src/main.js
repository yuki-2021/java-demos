import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

// 1. 创建vm
const vm = createApp(App).use(store).use(router)
vm.mount('#app')

// 2. 设置全局属性，类似于vue2的Vue.prototype.xx = xx
vm.config.globalProperties.$mstore = {
    msg: 'hello msg'
}
