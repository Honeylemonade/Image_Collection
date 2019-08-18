<template>
    <div>
        <el-menu  mode="horizontal"  router >
            <el-menu-item index="/">首页</el-menu-item>
            <el-menu-item index="/signIn">登入</el-menu-item>
            <el-menu-item index="/signUp">注册</el-menu-item>
        </el-menu>
    </div>
</template>

<script>
    export default {
        name: "Header"
    }
</script>

<style scoped>

</style>