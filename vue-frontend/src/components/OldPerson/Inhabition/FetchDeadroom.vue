<template>
  <Navi></Navi>
  <div class="container">
    <div class="form-container">
      <div class="form-header">
        <h1 class="title" style="color:yellow;margin-bottom: 4rem">发送派单寻找养老院</h1>
        <p class="sub-title" style="color:#0e2667;margin-right: 17rem">请填写以下信息:</p>
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
          <label for="food" class="form-label" style="color:red">备注(有无不孝子女等):</label>
          <input type="text" id="food" v-model="note" required class="form-input">
        </div>

        <div class="form-group">
          <label for="address" class="form-label" style="color:#c95ce7">身体状况:</label>
          <textarea id="address" v-model="situation" required class="form-input address-input"></textarea>
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
  name: 'fetch-deadRoom',
  components:{Navi},
  data() {
    return {
      username: '',
      phone: '',
      situation: '',
      note: ''
    }
  },
  methods: {
    async submitOrder() {
      const payload = {
        username: this.username,
        phone: this.phone,
        situation: this.situation,
        note: this.note,
      };

      try {
        await axios.post("http://localhost:8080/deadroomorders", payload);
        alert('派单成功!');
        this.username = '';
        this.phone = '';
        this.situation = '';
        this.note = '';
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
  margin: 3rem auto 3rem 15rem;
  padding: 1rem;
  border: 1px solid #ccc;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0,0,0,0.12);
  display: flex;
  flex-wrap: wrap;
  background-image: url("images/wheelchair-908343_1920.jpg");
  background-position: right;
  background-size: 1500px,899px;
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
  color: #f5dcae;
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
</style>
