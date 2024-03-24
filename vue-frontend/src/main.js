import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import './assets/main.css'
import {createRouter, createWebHistory} from "vue-router";
import FetchFood from "@/components/OldPerson/FoodSupply/FetchFood.vue";
import FetchDeadroom from "@/components/OldPerson/Inhabition/FetchDeadroom.vue";
import FetchMedicine from "@/components/OldPerson/Medical/FetchMedicine.vue";
import FoodPool from "@/components/CommonHelper/FoodSupply/FoodPool.vue";
import HeaderI from "@/components/CommonHelper/HeaderI.vue";
import HeaderII from "@/components/OldPerson/HeaderII.vue";
import WholeHeader from "@/components/WholeHeader.vue";
import MedicinePool from "@/components/CommonHelper/MedicineSupply/MedicinePool.vue";
import DeadHousePool from "@/components/CommonHelper/DeadHouseSupply/DeadHousePool.vue";
import Register from "@/components/CommonHelper/Login/Register.vue";
import Login from "@/components/CommonHelper/Login/Login.vue";
import ReadMedicine from "@/components/CommonHelper/MedicineSupply/ReadMedicine.vue";
import ReadFood from "@/components/CommonHelper/FoodSupply/ReadFood.vue";
import ReadDead from "@/components/CommonHelper/DeadHouseSupply/ReadDead.vue";
import MyOrders from "@/components/CommonHelper/MyOrders/MyOrders.vue";
import RestaurantInfo from "@/components/OldPerson/FoodSupply/RestaurantInfo.vue";
import HouseInfo from "@/components/OldPerson/Inhabition/HouseInfo.vue";
import FetchTransport from "@/components/OldPerson/Transport/FetchTransport.vue";
import FetchDoctor from "@/components/OldPerson/Medical/FetchDoctor.vue";

const routes=[
    {path:'/headerII',name:'HeaderII',component:HeaderII},
    {path:'/headerI',name:'HeaderI',component: HeaderI},
    {path:'/fetch-food',name:'FetchFood',component: FetchFood},
    {path:'/fetch-deadRoom',name:'FetchDead',component: FetchDeadroom},
    {path:'/fetch-medicine',name:'FetchMedicine',component: FetchMedicine},
    {path:'/pool-food',name:'FoodPool',component:FoodPool,meta:{requiresAuth:true}},
    {path:'/',name:'WholeHeader',component:WholeHeader},
    {path:'/pool-medicine',name:'MedicinePool',component: MedicinePool,meta:{requiresAuth:true}},
    {path:'/pool-deadhouse',name:'DeadHousePool',component: DeadHousePool,meta:{requiresAuth:true}},
    {path:'/register-work',name:'Register',component: Register},
    {path:'/login',name:'Login',component: Login},
    {path:'/read-pharmacist',name:'ReadBeforeMedicine',component:ReadMedicine,meta:{requiresAuth:true}},
    {path:'/read-beforebuy',name:'ReadBeforeFood',component:ReadFood,meta:{requiresAuth:true}},
    {path:'/go-beforedead',name:'ReadBeforeDead',component: ReadDead,meta:{requiresAuth:true}},
    {path:'/myorders',name:'MyOrdes',component:MyOrders,meta: {requiresAuth:true}},
    {path:'/restaurantInfo',name: RestaurantInfo,component: RestaurantInfo},
    {path:'/houseInfo',name:HouseInfo,component: HouseInfo},
    {path:'/fetch-transport',name:FetchTransport,component: FetchTransport},
    {path:'/fetch-doctor',name: FetchDoctor,component:FetchDoctor},
];

const router = createRouter(
    {
        history:createWebHistory(),
        routes,
    }
);

router.beforeEach((to,from,next)=>{
    const isAuthenticated = localStorage.getItem("username");
    if(to.matched.some(record=>record.meta.requiresAuth)){
        if(!isAuthenticated)
        {
            next({path:'/login'})
        }
        else
        {
            next();
        }
    }else{
        next();
    }
})
createApp(App).use(router,ElementPlus).mount('#app')
