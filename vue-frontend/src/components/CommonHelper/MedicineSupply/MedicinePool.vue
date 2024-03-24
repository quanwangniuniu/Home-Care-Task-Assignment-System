<template>
  <Navi></Navi>
  <div class = container>
  <div class="user-order-list">
    <States></States>
    <h2>下面是一些老家伙的药品订单</h2>
    <h5>加油骚年--骑上摩托去药店帮助他们</h5>
    <table>
      <thead>
      <tr>
        <th>姓名</th>
        <th>手机号</th>
        <th>家庭详细住址</th>
        <th>需要的药品</th>
        <th>Action</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="order in orders" :key="order.orderId">
        <td>{{ order.username }}</td>
        <td>{{ order.phone }}</td>
        <td>{{ order.address }}</td>
        <td>{{ order.itemName }}</td>
        <td>
          <button v-if="order.status === 0" @click="onReceive(order)">接单</button>
          <button v-else disabled style="background-color: #555555">此单被接</button>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
  </div>
</template>

<script>


import Navi from "@/components/CommonHelper/Navi/Navi.vue";
import axios from "axios";
import States from "@/components/CommonHelper/Login/States.vue";
export default {
  name: "UserOrderList",
  components:{Navi,States},
  data() {
    return {
      orders: [
        {
          orderId: 1,
          username: "张国荣",
          phone: "13612345678",
          address: "广东省深圳市南山区高新科技园6栋",
          itemName: "扬州青稞草药",
          helper_id:110,
          status:'',
        },
        {
          orderId: 2,
          username: "李444",
          phone: "13587654321",
          address: "广东省广州市天河区天河路123号",
          itemName: "壮阳药668",
          helper_id:110,
          status:'',
        },
        {
          orderId: 3,
          username: "王555",
          phone: "13988887777",
          address: "广东省珠海市香洲区湾仔海鲜市场",
          itemName: "壮阳药888",
          helper_id:110,
          status:'',
        },
        {
          orderId: 4,
          username: "王8888",
          phone: "13988887777",
          address: "广东省珠海市香洲区湾仔海鲜市场",
          itemName: "壮阳药999",
          helper_id:110,
          status:'',
        }
      ],
    };
  },
  methods: {
    async onReceive(order) {
      try {
        order.helper_id=localStorage.getItem('userid');
        order.status = 1;
        await axios.post("http://localhost:8080/getmedicineorders", order);
        alert('接单成功!');
        order.status = 1;
      } catch (error) {
        alert('接单失败，请重试!');
      }
    },
  },

  mounted() {
    const API_URL='http://localhost:8080/getallmedicineorders'
    axios.get(API_URL, {withCredentials: true})
        .then(response=>{
          this.orders = response.data
          console.log(this.orders)
        }).catch(error=>{
      console.log(error)
    })
  }
};
</script>

<style>
.user-order-list {
  width: 100%;
  text-align: center;
  margin-left: 15rem;
}

.user-order-list h2 {
  font-size: 2.2rem;
  margin: 0 0 5% 0;
}

.user-order-list table {
  width: 100%;
  border-collapse: collapse;
  text-align: left;
}

.user-order-list th,
.user-order-list td {
  padding: 8px;
  border: 1px solid #ccc;
}

.user-order-list th {
  background-color: #f5f5f5;
  font-size: 1.1rem;
  font-weight: bold;
}

.user-order-list tr:hover {
  background-color: #f5f5f5;
  opacity: 0.7;
}

.user-order-list button {
  background-color: #4CAF50;
  color: white;
  padding: 8px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.5s ease;
}

.user-order-list button:hover {
  background-color: #3e8e41;
}
.user-order-list table {
  width: 100%;
  table-layout: fixed;
  border-collapse: collapse;
  text-align: left;
}

.user-order-list th,
.user-order-list td {
  padding: 8px;
  border: 1px solid #ccc;
  width: 20px;
}

.container{
  width:1200px;
  margin-left: 10rem;
}


</style>
