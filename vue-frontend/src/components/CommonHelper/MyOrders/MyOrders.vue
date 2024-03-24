<template>
  <div>
    <Navi></Navi>
    <States></States>
    <div class="container">
    <h2>我接的食物订单</h2>
    <table>
      <thead>
      <tr>
        <th>订单编号</th>
        <th>手机号</th>
        <th>住址</th>
        <th>订单名称</th>
        <th>联系人姓名</th>
        <th>操作</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="order in foodOrders" :key="order.orderId">
        <td>{{ order.orderId }}</td>
        <td>{{ order.phone }}</td>
        <td>{{ order.address }}</td>
        <td>{{ order.itemName }}</td>
        <td>{{ order.username }}</td>
        <td>
          <button v-if="order.status!==2" @click="confirmFoodDelivery(order)">确认送达</button>
          <button v-else disabled>已送达</button>
        </td>
      </tr>
      </tbody>
    </table>
    </div>

    <div class="container">
    <h2>我接的药品订单</h2>
    <table>
      <thead>
      <tr>
        <th>订单编号</th>
        <th>手机号</th>
        <th>住址</th>
        <th>订单名称</th>
        <th>联系人姓名</th>
        <th>操作</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="order in medicineOrders" :key="order.orderId">
        <td>{{ order.orderId }}</td>
        <td>{{ order.phone }}</td>
        <td>{{ order.address }}</td>
        <td>{{ order.itemName }}</td>
        <td>{{ order.username }}</td>
        <td>
          <button v-if="order.status!==2" @click="confirmMedicineDelivery(order)">确认送达完毕</button>
          <button v-else disabled>已送达</button>
        </td>
      </tr>
      </tbody>
    </table>
    </div>

    <div class="container">
    <h2>我接的养老院订单</h2>
    <table>
      <thead>
      <tr>
        <th>订单编号</th>
        <th>手机号</th>
        <th>状况</th>
        <th>备注</th>
        <th>联系人姓名</th>
        <th>操作</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="order in deadroomOrders" :key="order.orderId">
        <td>{{ order.orderId }}</td>
        <td>{{ order.phone }}</td>
        <td>{{ order.situation }}</td>
        <td>{{ order.note }}</td>
        <td>{{ order.username }}</td>
        <td>
          <button v-if="order.status!==2" @click="confirmDeadRoomDelivery(order)">确认联系完毕</button>
          <button v-else disabled>已联系</button>
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
  name: "MyOrders",
  components:{Navi,States},
  data() {
    return {
      userId:localStorage.getItem("userid"),
      foodOrders: [
        {
          orderId: 1,
          username: "李444",
          phone: "13587654321",
          address: "广东省广州市天河区天河路123号",
          itemName: "宫保鸡丁",
          delivered: false,
          helperId:'',
          status:'',
        },
        {
          orderId: 2,
          username:"哈哈哈",
          phone: "987654321",
          address: "456 Second St",
          itemName: "炸鸡套餐",
          delivered: false,
          helperId:'',
          status:'',
        }
      ],
      medicineOrders: [
        {
          orderId: 3,
          phone: "555666777",
          address: "789 Third St",
          itemName: "感冒药",
          username: "王五",
          delivered: false,
          helperId:'',
          status:'',
        }
      ],
      deadroomOrders: [
        {
          orderId: 4,
          phone: "888999000",
          note: "111 Fourth St",
          situation: "轮椅",
          username: "赵六",
          delivered: true,
          helperId:'',
          status:'',
        }
      ]
    }
  },
  methods: {
    async confirmFoodDelivery(order) {
      try {
        order.status = 2;
        await axios.post("http://localhost:8080/getfoodorders", order);
        alert('您已完成订单!');
        order.status = 2;
      } catch (error) {
        alert('订单完成中出现错误，请重试!');
      }
    },
      async confirmMedicineDelivery(order) {
        try {
          order.status = 2;
          await axios.post("http://localhost:8080/getmedicineorders", order);
          alert('您已完成订单!');
          order.status = 2;
        } catch (error) {
          alert('订单完成中出现错误，请重试!');
        }
      },
        async confirmDeadRoomDelivery(order) {
          try {
            order.status = 2;
            await axios.post("http://localhost:8080/getroomorders", order);
            alert('您已完成订单!');
            order.status = 2;
          } catch (error) {
            alert('订单完成中出现错误，请重试!');
          }
      // 发送请求将订单状态更新为已送达
    },
    fetchOrders() {
      // 发送请求获取订单数据，并将数据分别赋值给foodOrders、medicineOrders和deadroomOrders
    }
  },
  created() {
    this.fetchOrders();
  },
  mounted() {
    // 获得当前commonHelper接的所有食物订单
    axios.get(`http://localhost:8080/getAllFoodOrdersById/${this.userId}`)
        .then(response => {
          this.foodOrders = response.data;
        })
        .catch(error => {
          console.error(error);
        });
    // 获得当前用户的所有药物订单
    axios.get(`http://localhost:8080/getAllMedicineOrdersById/${this.userId}`)
        .then(response => {
          this.medicineOrders = response.data;
        })
        .catch(error => {
          console.error(error);
        });
    // 获得当前用户的所有养老院订单
    axios.get(`http://localhost:8080/getAllDeadRoomsOrdersById/${this.userId}`)
        .then(response => {
          this.deadroomOrders = response.data;
        })
        .catch(error => {
          console.error(error);
        });
  }
}
</script>


<style scoped>
thead {
  background-color: #f5f5f5;
  color: #333;
  font-size: 16px;
  font-weight: bold;
}
/* Overall styling */
body {
  background-color: #202020;
  color: #fff;
  font-family: 'Roboto', sans-serif;
  font-size: 16px;
  line-height: 1.5;
}

/* Table styling */
table {
  margin-top: 10px;
  border-collapse: collapse;
  width: 900px;
}

th {
  text-align: left;
  background-color: #444;
  color: #fff;
  padding: 10px;
}

td {
  padding: 10px;
  border-bottom: 1px solid #444;
}

tr:nth-child(even) {
  background-color: rgb(73, 230, 159);
}

tr:hover {
  background-color: #c9e75c;
}

button {
  background-color: #00aa00;
  border: none;
  color: #fff;
  padding: 10px 20px;
  cursor: pointer;
  transition: all 0.2s ease;
}

button:hover {
  background-color: #007700;
}

button[disabled] {
  opacity: 0.5;
  cursor: not-allowed;
}
table + table {
  margin-top: 0;
}
/* Container styling */
.container {
  margin-left: 10rem;
  width: 900px;
  display: block;
  margin-top:1rem;
  margin-bottom: -10rem;
}

</style>