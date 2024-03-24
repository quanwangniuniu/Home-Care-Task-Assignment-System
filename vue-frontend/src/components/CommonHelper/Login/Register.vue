<style scoped>
.form-wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  font-family: Arial, Helvetica, sans-serif;
  margin-left: 25rem;
}

.form-wrapper form {
  width: 400px;
  padding: 20px;
  background-color: #fff;
  box-shadow: 0px 0px 20px rgba(0,0,0,0.1);
  border-radius: 5px;
}

h1 {
  text-align: center;
  margin-bottom: 20px;
  color: #555;
}

table {
  margin: auto;
  border-collapse: collapse;
  width: 100%;
}

td {
  padding: 10px;
  text-align: left;
  color: #555;
  font-size: 14px;
  border-bottom: 1px solid #f2f2f2;
  vertical-align: middle;
}

td input {
  color: #888;
  font-size: 14px;
  padding: 10px;
  display: block;
  border: none;
  width: 100%;
  background-color: #f9f9f9;
  border-radius: 5px;
}

td input:focus {
  outline: none;
  background-color: #f2f2f2;
}

td.error input {
  border: 1px solid tomato;
}

td.error span {
  font-size: 12px;
  color: tomato;
  margin-left: 5px;
}

td.success input {
  border: 1px solid #2ecc71;
}

td.success span {
  font-size: 12px;
  color: #2ecc71;
  margin-left: 5px;
}

button[type="submit"] {
  background-color: #2ecc71;
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
  font-size: 16px;
  margin-top: 20px;
  transition: all 0.3s ease;
}

button[type="submit"]:hover {
  background-color: #27ae60;
}
</style>
<template>
  <div class="form-wrapper">
    <form>
      <h1>注册一个用户</h1>
      <table>
        <tr :class="{'error': errors.username}">
          <td>用户名:</td>
          <td>
            <input type="text" v-model="username" @focus="clearError('username')">
            <span v-if="errors.username">{{ errors.username }}</span>
          </td>
        </tr>
        <tr :class="{'error': errors.email}">
          <td>邮箱:</td>
          <td>
            <input type="email" v-model="email" @focus="clearError('username')">
            <span v-if="errors.email">{{ errors.email }}</span>
          </td>
        </tr>
        <tr :class="{'error': errors.passwordOne}">
          <td>设置密码:</td>
          <td>
            <input type="password" v-model="passwordOne" @focus="clearError('username')">
            <span v-if="errors.passwordOne">{{ errors.passwordOne }}</span>
          </td>
        </tr>
        <tr :class="{'error': errors.passwordTwo}">
          <td>确认密码:</td>
          <td>
            <input type="password" v-model="passwordTwo" @focus="clearError('username')">
            <span v-if="errors.passwordTwo">{{ errors.passwordTwo }}</span>
          </td>
        </tr>
        <tr>
          <td colspan="2"><button type="submit" @click.prevent="registerUser">注册</button></td>
        </tr>
      </table>
    </form>
  </div>
</template>

<script>
import axios from "axios";
import {createRouter as router} from "vue-router";
export default {
  data() {
    return {
      username: '',
      email: '',
      passwordOne: '',
      passwordTwo: '',
      errors: {}
    }
  },
  methods: {
    clearError(fieldName) {
      this.errors[fieldName] = '';
    },
    registerUser() {
      // perform validation on input fields
      this.errors = {};
      if (!this.username) {
        this.errors.username = '请输入用户名';
      }
      if (!this.email) {
        this.errors.email = '请输入邮箱';
      } else if (!this.validEmail(this.email)) {
        this.errors.email = '请输入有效的邮箱';
      }
      if (!this.passwordOne) {
        this.errors.passwordOne = '请输入密码';
      }
      if (!this.passwordTwo) {
        this.errors.passwordTwo = '请再次输入确认密码';
      }
      if (this.passwordOne !== this.passwordTwo) {
        this.errors.passwordTwo = '两次输入的密码不匹配';
      }

      // if there are errors, don't submit the form
      if (Object.keys(this.errors).length) {
        return;
      }

      // send data to backend API
      const userData = {
        username: this.username,
        email: this.email,
        password: this.passwordOne
      };
      axios.post('http://localhost:8080/register', userData)
          .then(response => {
            alert("注册成功!");
            this.$router.replace('/login');
            console.log('User registered:', response.data);
          })
          .catch(error => {
            console.log('Error registering user:', error.response.data);
          });
    },
    validEmail(email) {
      // check if email is valid
      const re = /\S+@\S+\.\S+/;
      return re.test(email);
    }
  }
}
</script>
