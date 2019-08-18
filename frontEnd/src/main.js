import Vue from 'vue'
import App from './App.vue'

//element-ui
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.use(ElementUI);
//router
import router from './router';
//axios
import Axios from 'axios'
import VueAxios from 'vue-axios'
Axios.defaults.baseURL = 'http://localhost:8081/api';
Axios.interceptors.request.use(
    config => {
        //在所有请求头部添加id和token值
        config.headers.common.token = store.state.token;
        config.headers.common.id = store.state.id;
        return config;
    },
    error => {
        return Promise.reject(error);
    }
);
Vue.use(VueAxios, Axios)

//vue-cookie
import VueCookies from 'vue-cookies'
Vue.use(VueCookies)
//vuex
import Vuex from 'vuex';
Vue.use(Vuex);
const store = new Vuex.Store({
    state: {
        id: '',
        token: ''
    }
})
Vue.config.productionTip = false

new Vue({
    store,
    router,
    render: h => h(App),
}).$mount('#app')