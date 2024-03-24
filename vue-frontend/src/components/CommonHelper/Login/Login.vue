<template>
  <div class="container">
  <div class="login-container">
    <h2>登录</h2>
    <form @submit.prevent="submit">
      <div class="form-group">
        <label for="username">用户名:</label>
        <input id="username" v-model="formData.username" type="text" required/>
        <p v-if="errors.username" class="error">{{ errors.username }}</p>
      </div>
      <div class="form-group">
        <label for="password">密码:</label>
        <input id="password" v-model="formData.password" type="password" minlength="6" required/>
        <p v-if="errors.password" class="error">{{ errors.password }}</p>
      </div>
      <button type="submit">登录</button>
    </form>
    <p v-if="error" class="error">{{ error }}</p>
    <router-link to="/register-work">没有账号，来注册一个！</router-link>
  </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      formData: {
        username: '',
        password: '',
      },
      errors: {},
      error: '',
    };
  },
  methods: {
    async submit() {
      // 表单验证
      this.errors = {};
      if(!this.formData.username) {
        this.errors.username = '请输入用户名';
      }
      if(this.formData.password.length < 6) {
        this.errors.password = '密码长度应该不少于6位';
      }
      if(Object.keys(this.errors).length > 0) {
        return;
      }

      // 后端请求
      try {
        // const response = await axios.post("http://localhost:8080/commonhelperlogin", {
        //   username: this.formData.username,
        //   password: this.formData.password,
        // });
        const response = await axios.post("http://localhost:8080/commonhelperlogin",this.formData);

        if (response.status === 200) {
          // 登录成功
          this.error = '';
          localStorage.setItem('username',this.formData.username);
          const response_id = await axios.post("http://localhost:8080/commonhelperfindId",this.formData);
          localStorage.setItem('userid',response_id.data);
          this.$router.replace("/headerI");
        } else {
          // 登录失败
          this.error = response.data.message;
        }
      } catch (e) {
        this.error = '登录失败';
      }
    },
  },
};
</script>

<style scoped>
.container{
  background-image: url("images/header.png") ;
  background-size:1123px 808px;
  background-position: center;
  width: 1580px;
  background-color: rgb(44, 147, 119);
  background-repeat: no-repeat;
  margin:auto;
}
.login-container {
  max-width: 1200px;
  margin-right: 45rem;
  padding: 40px;
  background-color: #fff;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  border-radius: 5px;
}
h2 {
  text-align: center;
  color: #555;
  font-size: 24px;
  margin-bottom: 30px;
}
form {
  margin-top: 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
}
label {
  font-weight: bold;
  margin-bottom: 8px;
  display: block;
  font-size: 16px;
  color: #555;
}
input {
  padding: 10px;
  margin-bottom: 20px;
  border-radius: 5px;
  border: none;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.2);
  font-size: 16px;
}
button[type="submit"] {
  background-color: #4169E1;
  color: white;
  padding: 12px 20px;
  border: none;
  cursor: pointer;
  border-radius: 5px;
  font-size: 18px;
  width: 100%;
  margin-top: 30px;
}
p.error {
  margin-top: 10px;
  color: #f00;
  font-size: 16px;
}
</style>
