<template>
    <div>
        <el-form :model="form" :rules="rules" ref="form" label-width="100px">
            <div style="text-align: center;font-size: 35px;margin: 20px 0px">登入</div>
            <el-form-item label="用户名" prop="userName">
                <el-input v-model="form.userName"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input v-model="form.password"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('form')">登入</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "SignIn",
        data() {
            return {
                form: {
                    userName: "",
                    password: ""
                },
                rules: {
                    userName: [
                        {required: true, message: "请输入用户名", trigger: "blur"}
                    ],
                    password: [{required: true, message: "请输入密码", trigger: "blur"}]
                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate(valid => {
                    if (valid) {
                        let userInfo = {
                            userName: this.form.userName,
                            password: this.form.password
                        };
                        this.axios.post("/login", userInfo).then(response => {
                            if (response.data.code === 0) {
                                let result = response.data.result;
                                //设置token和id到cookie中
                                this.$cookies.set("token", result.token);
                                this.$cookies.set("id", result.id);
                                //写入Vuex中
                                this.$store.state.id = result.id;
                                this.$store.state.token = result.token;
                                console.log(this.$store.state);
                                //跳转到的首页
                                this.$router.push({path: "/"});
                            } else {
                                alert("登入失败");
                            }
                        });
                    } else {
                        console.log("error submit!!");
                        return false;
                    }
                });
            }
        },
        mounted() {
        }
    };
</script>

<style scoped>
</style>