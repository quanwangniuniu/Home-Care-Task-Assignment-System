<template>
  <div class="cont">
    <h1>请选择你的角色</h1>
    <div class="left">
      <p><router-link to="/headerII">老人</router-link></p>
    </div>
    <div class="right">
      <p><router-link to="/login">好人</router-link></p>
    </div>
    <div class="left">
      <p><a href="http://localhost:8080/doctorChat.html">医生</a></p>
    </div>
  </div>
</template>
<script>
export default {
  name: "WholeHeader",
};
</script>
<style scoped>
p{
  font-size: 30px;
}
h1 {
  text-align: center;
  font-size: 66px;
  margin-top: 20px;
}
.left {
  width: 33%;
  background-color: #eee;
  float: left;
  padding: 40px;
  height:10rem
}
.right {
  width: 33%;
  background-color: #ccc;
  float: left;
  padding: 40px;
  height:10rem
}
.cont{
  margin-left: 25rem;
}
</style>