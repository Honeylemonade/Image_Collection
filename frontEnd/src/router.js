import Vue from 'vue'
import Router from 'vue-router'
//引入组件
import HomePage from './components/HomePage'
import SignIn from './components/SignIn'
import SignUp from './components/SignUp'

Vue.use(Router);
export default new Router({
    routes:[
        {path:'/',component:HomePage},
        {path:'/SignIn',component:SignIn},
        {path:'/SignUp',component:SignUp},
    ],
    mode:'history'
})