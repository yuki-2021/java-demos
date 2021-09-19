import { createRouter, createWebHashHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Request from '../views/Request.vue'
import Util from '../views/Util.vue'
import Async from '../views/Async.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/axios',
    name: 'axios',
    component: Request
  },
  {
    path: '/util',
    name: 'util',
    component: Util
  }
  ,
  {
    path: '/async',
    name: 'async',
    component: Async
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
