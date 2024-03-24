<template>
  <div class="nav-container">
    <div class="nav-item" >
      <span class="nav-label"><router-link to="/pool-medicine">帮老人买药</router-link></span>
    </div>
    <div class="nav-item" >
      <span class="nav-label"><router-link to="/pool-deadhouse">帮老人出家</router-link></span>
    </div>
    <div class="nav-item" >
      <span class="nav-label"><router-link to="/pool-food">帮老人买食</router-link></span>
    </div>
    <div class="nav-item" >
      <span class="nav-label"><router-link to="/pool-">送老人出行</router-link></span>
    </div>
    <div class="nav-item" >
      <span class="nav-label"><router-link to="/myorders">我的订单</router-link></span>
    </div>

  </div>

</template>
<script>
export default {
  name: "Navigation",
};
</script>
<style scoped>
.nav-label{
  color: #e649c1;
}
.nav-container {
  position: fixed;
  left: 0;
  top: 0;
  bottom: 0;
  width: 18rem;
  background-color: rgba(35, 107, 215, 0.22);
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding-top: 2rem;
  z-index: 999;
}
.nav-item {
  width: 100%;
  height: 8rem;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
  font-size: 2.5rem;
  color: #dc4444;
  cursor: pointer;
  transition: all 0.25s ease;
  border: 1px solid #FFDAB9;
}
.nav-item:hover {
  background-color: #FFB6C1;
  color: #333;
}
.nav-item i {
  margin-left: 2rem;
  margin-right: 1rem;
}

.submodule-item i {
  margin-left: 2rem;
  margin-right: 1rem;
}

</style>