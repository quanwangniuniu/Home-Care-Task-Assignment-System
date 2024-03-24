<template>
  <Navi></Navi>
  <div class="container">
    <div class="form-container">
      <div class="form-header">
        <h1 class="title" style="margin-bottom: 4rem">外送药物派单到家</h1>
        <h2>&nbsp;遵医嘱，本平台仅负责派单请求，不负责后续急救措施！</h2>
        <p class="sub-title">请填写以下信息： </p>
      </div>
      <form @submit.prevent="submitOrder" class="form">
        <div class="form-group">
          <label for="name" class="form-label">姓名:</label>
          <input type="text" id="name" v-model="username" required class="form-input">
        </div>

        <div class="form-group">
          <label for="phone" class="form-label">电话:</label>
          <input type="text" id="phone" v-model="phone" required class="form-input">
        </div>


        <div class="form-group">
          <label for="food" class="form-label">药品<span style="color:red">(备注不良禁忌)</span>:</label>
          <input text="text" id="medicine" v-model="itemName" required class="form-input">
        </div>
        <div class="form-group">
          <label for="address" class="form-label">地址:</label>
          <textarea id="address" v-model="address" required class="form-input address-input"></textarea>
        </div>
        <button type="submit" class="btn">派单</button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import Navi from "@/components/OldPerson/Navi/Navi.vue";
export default {
  name: 'fetch-medicine',
  components:{Navi},
  data() {
    return {
      username: '',
      phone: '',
      address: '',
      itemName: ''
    }
  },
  methods: {
    async submitOrder() {
      const payload = {
        username: this.username,
        phone: this.phone,
        address: this.address,
        itemName: this.itemName,
      };

      try {
        await axios.post("http://localhost:8080/medicineorders", payload);
        alert('派单成功!');
        this.username = '';
        this.phone = '';
        this.address = '';
        this.itemName = '';
      } catch (error) {
        alert('派单失败，请重试!');
      }
    }
  }
}
</script>

<style scoped>
.container {
  max-width: 2200px;
  margin: 3rem 3rem 3rem 15rem;
  padding:1rem;
  border: 1px solid #ccc;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0,0,0,0.12);
  display: flex;
  flex-wrap: wrap;
  background-image: url("images/brick-wall-185086_1280.jpg");
}


.title {
  flex: 1;
  font-size: 2.5rem;
  color: #333;
  margin-bottom: 0.5rem;
  text-align:center;
}

.sub-title {
  flex: 1;
  font-size: 1.2rem;
  color: rgb(73, 230, 141);
  margin-bottom:0.1rem;
  text-align: center;
}

.form-container {
  width: 100%;
  background-image: url('images/marble-2371776_1280.jpg');
  background-size: 1400px,567px ;
  height:80%;
}

.form-header {
  margin-bottom: 3rem;
}

.form {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  grid-column-gap: 1rem;
  grid-row-gap: 1rem;
}

.form-group {
  display: flex;
  flex-direction: column;
  margin-bottom: 1.0rem;
  margin-left: 3rem;
}

.form-label {
  margin-bottom: 0.5rem;
  font-size: 1rem;
  font-weight: bold;
  color: #555;
}

.form-input {
  font-size: 1rem;
  padding: 0.5rem;
  border: 2px solid #007bff;
  border-radius: 5px;
}

.address-input {
  resize: vertical;
  height: 6rem;
}

.btn {
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 5px;
  padding: 0.5rem 1rem;
  font-size: 1rem;
  font-weight: bold;
  cursor: pointer;
  transition: all 0.3s ease;
  justify-self: end;
}

.btn:hover {
  background-color: #0069d9;
  transform: translateY(-2px);
  box-shadow: 0 2px 4px rgba(0,0,0,0.12);
}
img{
  display: block;
  width: 400px;
  height: 300px;
}
textarea{
  width: 16rem;
}
</style>
