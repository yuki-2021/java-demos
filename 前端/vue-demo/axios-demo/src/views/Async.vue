<template>
    async
</template>

<script>
import axios from 'axios'
export default {
    name: 'Async',
    async mounted() {
        let res = await this.$http({
            method: 'get',
            url: '/get'
        })
        console.log(res);
    }
}
</script>

<style>

</style>