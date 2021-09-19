<template>
  封装axio
</template>

<script>
export default {
    name: 'Util',
    mounted() {
        this.$http({
            url: '/anything?id',
            method: 'get'
        })
        .then(res => {
            console.log(res);
        })
    }
}
</script>

<style>

</style>