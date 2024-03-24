<template>
  <Navi></Navi>
  <div class="container">
    <div class="module" @click="showBuyMedication()">
      <div class="module-icon">
        <i class="fa fa-hospital-o" aria-hidden="true"></i>
      </div>
      <div class="module-name">
         帮老人买药
      </div>
      <transition name="slide">
        <div class="sub-module" v-show="showBuyMedicationSubModule">
          <div class="sub-module-item">
            <i class="fa fa-stethoscope" aria-hidden="true"></i>
            <div class="sub-module-name">
              <router-link to="/read-pharmacist">
                 接单前必读
              </router-link>
            </div>
          </div>
          <div class="sub-module-item">
            <i class="fa fa-medkit" aria-hidden="true"></i>
            <div class="sub-module-name">
              <router-link to="/pool-medicine">
                 附近的药品订单
              </router-link>
            </div>
          </div>
        </div>
      </transition>
    </div>
    <div class="module" @click="showHouseKeeping()">
      <div class="module-icon">
        <i class="fa fa-home" aria-hidden="true"></i>
      </div>
      <div class="module-name">
        帮老人出家
      </div>
      <transition name="slide">
        <div class="sub-module" v-show="showHouseKeepingSubModule">
          <div class="sub-module-item">
            <i class="fa fa-bath" aria-hidden="true"></i>
            <div class="sub-module-name">
              <router-link to="/go-beforedead">
                  接单前必读
              </router-link>
            </div>
          </div>
          <div class="sub-module-item">
            <i class="fa fa-wrench" aria-hidden="true"></i>
            <div class="sub-module-name">
              <router-link to="/pool-deadhouse">
                   立刻接单
              </router-link>
            </div>
          </div>
        </div>
      </transition>
    </div>

    <div class="module" @click="showFoodDelivery()">
      <div class="module-icon">
        <i class="fa fa-cutlery" aria-hidden="true"></i>
      </div>
      <div class="module-name">
        帮老人买食
      </div>
      <transition name="slide">
        <div class="sub-module" v-show="showFoodDeliverySubModule">
          <div class="sub-module-item">
            <i class="fa fa-map-marker" aria-hidden="true"></i>
            <div class="sub-module-name">
              <router-link to="/read-beforebuy">
                  买前必读
              </router-link>
            </div>
          </div>
          <div class="sub-module-item">
            <i class="fa fa-shopping-basket" aria-hidden="true"></i>
            <div class="sub-module-name">
              <router-link to="/pool-food">
                  立刻接单
              </router-link>
            </div>
          </div>
        </div>
      </transition>
    </div>

    <div class="module" @click="showTransportation()">
      <div class="module-icon">
        <i class="fa fa-car" aria-hidden="true"></i>
      </div>
      <div class="module-name">
        送老人出行
      </div>
      <transition name="slide">
        <div class="sub-module" v-show="showTransportationSubModule">
          <div class="sub-module-item">
            <i class="fa fa-plane" aria-hidden="true"></i>
            <div class="sub-module-name">
              <router-link to="/read-beforego">
                   接单前必读
              </router-link>
            </div>
          </div>
          <div class="sub-module-item">
            <i class="fa fa-wheelchair" aria-hidden="true"></i>
            <div class="sub-module-name">
              <router-link to="/pool-medicine">
                  立刻接单
              </router-link>
            </div>
          </div>
        </div>
      </transition>
    </div>
  </div>
</template>
<script>
import Navi from "@/components/CommonHelper/Navi/Navi.vue";
export default {
  name:'Assistance',
  components:{Navi},
  data() {
    return {
      showBuyMedicationSubModule: false,
      showHouseKeepingSubModule: false,
      showFoodDeliverySubModule: false,
      showTransportationSubModule: false,
    }
  },
  methods: {
    showBuyMedication() {
      this.showBuyMedicationSubModule = !this.showBuyMedicationSubModule
      this.showHouseKeepingSubModule = false
      this.showFoodDeliverySubModule = false
      this.showTransportationSubModule = false
    },
    showHouseKeeping() {
      this.showBuyMedicationSubModule = false
      this.showHouseKeepingSubModule = !this.showHouseKeepingSubModule
      this.showFoodDeliverySubModule = false
      this.showTransportationSubModule = false
    },
    showFoodDelivery() {
      this.showBuyMedicationSubModule = false
      this.showHouseKeepingSubModule = false
      this.showFoodDeliverySubModule = !this.showFoodDeliverySubModule
      this.showTransportationSubModule = false
    },
    showTransportation() {
      this.showBuyMedicationSubModule = false
      this.showHouseKeepingSubModule = false
      this.showFoodDeliverySubModule = false
      this.showTransportationSubModule = !this.showTransportationSubModule
    },
  },
}
</script>
<style>
.container {
  padding-left: 10rem;
  height: 100vh;
  display: flex;
  justify-content: space-around;
  align-items: center;
}

.module {
  position: relative;
  width: 200px;
  height: 200px;
  border-radius: 10px;
  background-color: #fff;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin: 30px;
  cursor: pointer;
  box-shadow: 2px 2px 4px rgba(0, 0, 0, .15);
  transition: all .25s ease-in-out;
}

.module:hover {
  transform: scale(1.05) translateY(-10px);
  box-shadow: 4px 4px 7px rgba(0, 0, 0, .2);
}

.module-icon {
  font-size: 80px;
  margin-bottom: 10px;
}

.module-name {
  font-size: 50px;
  text-align: center;
  color: #333;
}

.sub-module {
  position: absolute;
  top: calc(100% + 10px);
  left: 50%;
  transform: translateX(-50%);
  width: 300px;
  background-color: #fff;
  border-radius: 5px;
  overflow: hidden;
  box-shadow: 2px 2px 4px rgba(0, 0, 0, .15);
  transition: all .25s ease-in-out;
  z-index: 10;
  display: flex;
  flex-direction: column;
}

.sub-module-item {
  height: 60px;
  display: flex;
  justify-content: flex-start;
  align-items: center;
  cursor: pointer;
  padding: 10px;
}

.sub-module-item:hover {
  background-color: #f2f2f2
}

.sub-module-name {
  font-size: 24px;
  margin-left: 10px;
  color: #333;
}

.slide-enter-active,
.slide-leave-active {
  transition: all 0.5s ease;
}
.slide-enter,
.slide-leave-to {
  opacity: 0;
  transform: translateY(-200px);
}

@media screen and (max-width: 768px) {
  .container {
    flex-direction: column;
    justify-content: space-around;
    height: auto;
  }
  .module {
    margin: 20px 0;
  }
}
</style>