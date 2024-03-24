<template>
  <Navi></Navi>
  <div class="container">
  <div class="user-order-list">
    <States></States>
    <h2>下面是一些老家伙的住宿诉求</h2>
    <h5>为了未来--帮助他们找到养老院</h5>
    <table>
      <thead>
      <tr>
        <th>姓名</th>
        <th>手机号</th>
        <th>身体情况</th>
        <th>备注</th>
        <th>Action</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="order in orders" :key="order.orderId">
        <td>{{ order.username }}</td>
        <td>{{ order.phone }}</td>
        <td>{{ order.situation }}</td>
        <td>{{ order.note }}</td>
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
  components: {Navi,States},
  data() {
    return {
      orders: [
        {
          orderId: 1,
          username: "张333",
          phone: "13612345678",
          situation: "离异带两个娃",
          note: "有不孝子",
          helper_id: 122,
        },
        {
          orderId: 2,
          username: "李444",
          phone: "13587654321",
          situation: "离异带四个娃",
          note: "有七个不孝子",
          helper_id: 122,
        },
        {
          orderId: 3,
          username: "王555",
          phone: "13988887777",
          situation: "离异带八个娃",
          note: "没有不孝子",
          helper_id: 122,
        },
        {
          orderId: 4,
          username: "王8888",
          phone: "13988887777",
          situation: "离异带23个娃",
          note: "没有不孝子",
          helper_id: 122,
        }
      ],
    };
  },
  methods: {
    async onReceive(order) {
      try {
        order.helper_id=localStorage.getItem('userid');
        order.status = 1;
        await axios.post("http://localhost:8080/getroomorders", order);
        alert('接单成功!');
        order.status = 1;
      } catch (error) {
        alert('接单失败，请重试!');
      }
    },
  },
  mounted() {
    const API_URL='http://localhost:8080/getallroomorders'
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
  margin-left: 1rem;
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
