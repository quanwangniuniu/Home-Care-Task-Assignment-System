<template>
  <Navi></Navi>
  <div class="container">
    <div class="form-container">
      <div class="form-header">
        <h1 class="title" style="color:#5cc2e7;margin-bottom: 4rem" >去码头整点薯条</h1>
        <p class="sub-title" style="color:#c05ce7;margin-right: -14rem">请填写以下信息： </p>
      </div>
      <form @submit.prevent="submitfoodOrder" class="form">
        <div class="form-group">
          <label for="name" class="form-label">姓名:</label>
          <input type="text" id="name" v-model="username" required class="form-input">
        </div>

        <div class="form-group">
          <label for="phone" class="form-label">电话:</label>
          <input type="text" id="phone" v-model="phone" required class="form-input">
        </div>

        <div class="form-group">
          <label for="address" class="form-label">地址:</label>
          <textarea id="address" v-model="address" required class="form-input address-input"></textarea>
        </div>

        <div class="form-group">
          <label for="food" class="form-label">菜品:</label>
          <textarea id="food" v-model="itemName" required class="form-input address-input"></textarea>
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
  name: 'fetch-food',
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
    async submitfoodOrder() {
      const payload = {
        username: this.username,
        phone: this.phone,
        address: this.address,
        itemName: this.itemName
      };

      try {
        await axios.post("http://localhost:8080/foodorders", payload);
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
  max-width: 1200px;
  margin-left: 15rem;
  padding: 1rem;
  border: 1px solid #ccc;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0,0,0,0.12);
  display: flex;
  flex-wrap: wrap;
  background-image: url("images/外卖.png");
  background-size: 1359px,874px;
}

.header {
  display: flex;
  justify-content: center;
  margin-bottom: 3rem;
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
  margin-left: 2rem;
  margin-right:2rem;
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
.my-image{
  width: 860px;
  height:560px;
}
</style>
