<template>
  <div class="about">
    <h1>This is an about page</h1>

	<h4> modules </h4>
	{{ $store.state.a.msgA }}
	<button @click="changeMsgA"> 修改</button>
  </div>
</template>

<script>
export default {
	name: 'About',
	methods: {
		changeMsgA() {
			this.$store.commit('changeMsgA');
		}
	}
}
</script>
