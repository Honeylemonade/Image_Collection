<template>
  <div>
    <el-upload
      action="http://localhost:8080/image"
      name="imageFile"
      :headers="headers"
      :file-list="fileList"
      list-type="picture">
      <el-button size="small" type="primary">点击上传图片</el-button>
    </el-upload>
    <!--用户图片展示区域-->
    <div style="text-align: center">您收藏的图片：</div>
    <div v-for="item in userImage" v-bind:key="item.id" style="text-align: center">
      <el-image
        :src="'http://localhost:8080/'+item.imagePath"
        style="width: 500px; height: 200px"
        fit="cover"
      ></el-image>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomePage",
  data() {
    return {
      fileList: [],
      headers: {
        token: this.$store.state.token,
        id: this.$store.state.id
      },
      userImage: []
    };
  },
  methods: {
    //检查登陆权限，判断是否执行跳转
    checkAuth() {
      if (this.$store.state.token) {
      } else {
        this.$router.push({ path: "/signIn" });
      }
    },
    //初始化Vuex
    getVuexState() {
      //将cookie写入Vuex中
      this.$store.state.id = this.$cookies.get("id");
      this.$store.state.token = this.$cookies.get("token");
      this.headers.token = this.$store.state.token;
      this.headers.id = this.$store.state.id;
    },
    initData() {
      this.axios.get("/userImage/" + this.$store.state.id).then(response => {
        this.userImage = response.data.result;
      });
    }
  },
  mounted() {
    //将cookie写入Vuex中
    this.getVuexState();
    //检查登陆权限，判断是否执行跳转
    this.checkAuth();
    //data初始化
    this.initData();
  }
};
</script>

<style scoped>
</style>