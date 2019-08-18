<template>
    <div>
        <el-form :model="form" :rules="rules" ref="form" label-width="100px">
            <div style="text-align: center;font-size: 35px;margin: 20px 0px">注册</div>
            <el-form-item label="用户名" prop="userName">
                <el-input v-model="form.userName"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input v-model="form.password"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('form')">注册</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "SignUp",
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
                        this.axios.post("/register", userInfo).then(response => {
                            if (response.data.code === 0) {
                                alert("注册成功");
                                //跳转到登入界面
                                this.$router.push({path: "/signIn"});
                            } else {
                                alert("注册失败");
                            }
                        });
                    } else {
                        console.log("error submit!!");
                        return false;
                    }
                });
            }
        }
    };
</script>

<style scoped>
</style>