<template>
  <div>
    <h1>你好，打工仔: {{ username }}</h1>
    <button @click="logout">Logout</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      userId:'',
    }
  },
  mounted() {
    this.username = localStorage.getItem('username')
    this.userId=localStorage.getItem('userid')
  },
  methods: {
    logout() {
      localStorage.removeItem('username')
      this.$router.push('/login')
    }
  }
}
</script>

<style scoped>
div {
  text-align: right;
  font-size: 0.8rem;
  display: flex;
  align-items: center;
  justify-content: flex-end;
}

h1 {
  margin-right: 1rem;
}
</style>