<template>
  <div class="home">

    <!-- 自定义全局属性 -->
    <h4>自定义全局属性</h4>
    {{ $mstore.msg }}
    <button @click="changeMsg">修改$mstore.msg</button>

    <!-- state  -->
    <h4> state </h4>
    count is : {{ $store.state.count }}

    <!-- getters  -->
    <h4> getters </h4>
    stu列表: {{ $store.getters.stuList }} <br />
    stu个数: {{ $store.getters.stuCount }} <br />
    age大于12: {{ $store.getters.ageCount(12) }}


    <!-- mutations  -->
    <h4> mutations </h4>
    {{ $store.state.count}} --
    <button @click="addOne">+1</button>
    <button @click="addNum">+3</button>
    <button @click="addPlus1">+( 2*3)</button>
    <button @click="addPlus2">+( 2*3)</button>

    <!-- mutations  -->
    <h4> actions </h4>
    {{ $store.state.count}} --
    <button @click="$store.dispatch('addOne')">+1</button>
    <button @click="$store.dispatch('addNum',10)">+3</button>
    <button @click="$store.dispatch('addPlus', {num1: 3, num2: 2})">+( 2*3)</button>
    <button @click="$store.dispatch({type: 'addPlus', num1: 3, num2: 2})">+( 2*3)</button>
    <button @click="addAndLog">+1 - addOneAndLog</button>

    <!-- 动态修改 -->
    <h4> 动态修改</h4>
    {{ $store.state.numList }}
    <button @click="$store.commit('addToNumList', 3)">add to numList</button>  <br />

     {{ $store.state.info }}
    <button @click="$store.commit('addInfo')">add to numList</button>  <br />

  </div>
</template>

<script>
import mtypes from '../store/mutations-type.js'
export default {
  name: 'Home',
  data() {
    return {
      msg: 'aaa',
    }
  },
  methods: {
    // 修改msg
    changeMsg() {
      this.$mstore.msg = "changed !!!"
      console.log(this.$mstore);
    },
    // 提交mutations
    addOne() {
      this.$store.commit(mtypes.ADD_ONE);
    },
    addNum() {
      this.$store.commit('addNum', 3)
    },
    addPlus1() {
      this.$store.commit('addPlus', {num1: 2, num2: 3})
    },
    addPlus2() {
      let obj = {num1: 2, num2: 3};
      this.$store.commit({
        type: 'addPlus',
        ... obj
      });
    },
    addAndLog() {
      this.$store.dispatch('addOneAndLog')
      .then((res) => {console.log("success !!!"); console.log(res);})
    }
  }
}
</script>
