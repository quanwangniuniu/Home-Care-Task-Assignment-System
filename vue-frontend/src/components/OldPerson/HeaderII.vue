<template>
  <Navi></Navi>
  <div class="container">
    <div class="module" @click="showMedical()">
      <div class="module-icon">
        <i class="fa fa-hospital-o" aria-hidden="true"></i>
      </div>
      <div class="module-name">
        医疗
      </div>
      <transition name="slide">
        <div class="sub-module" v-show="showMedicalSubModule">
          <div class="sub-module-item">
            <i class="fa fa-stethoscope" aria-hidden="true"></i>
            <div class="sub-module-name">
              <a href="http://localhost:8080/Oldchat.html">
              在线问诊
              </a>
            </div>
          </div>
          <div class="sub-module-item">
            <i class="fa fa-medkit" aria-hidden="true"></i>
            <div class="sub-module-name">
              <router-link to="/fetch-medicine">
                  药品配送
              </router-link>
            </div>
          </div>
        </div>
      </transition>
    </div>

    <div class="module" @click="showFood()">
      <div class="module-icon">
        <i class="fa fa-cutlery" aria-hidden="true"></i>
      </div>
      <div class="module-name">
        餐饮
      </div>
      <transition name="slide">
        <div class="sub-module" v-show="showFoodSubModule">
          <div class="sub-module-item">
            <i class="fa fa-map-marker" aria-hidden="true"></i>
            <div class="sub-module-name">
              <router-link to="/restaurantInfo">
              附近餐厅
              </router-link>
            </div>
          </div>
          <div class="sub-module-item">
            <i class="fa fa-shopping-basket" aria-hidden="true"></i>
            <div class="sub-module-name">
              <router-link to="/fetch-food">
              餐饮配送
              </router-link>
            </div>
          </div>
        </div>
      </transition>
    </div>
    <div class="module" @click="showAccommodation()">
      <div class="module-icon">
        <i class="fa fa-home" aria-hidden="true"></i>
      </div>
      <div class="module-name">
         住宿
      </div>
      <transition name="slide">
        <div class="sub-module" v-show="showAccommodationSubModule">
          <div class="sub-module-item">
            <i class="fa fa-bed" aria-hidden="true"></i>
            <div class="sub-module-name">
              <router-link to="/fetch-deadRoom">
              匹配养老院
              </router-link>
            </div>
          </div>
          <div class="sub-module-item">
            <i class="fa fa-building" aria-hidden="true"></i>
            <div class="sub-module-name">
              <router-link to="/houseInfo">
              房产信息
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
        交通
      </div>
      <transition name="slide">
        <div class="sub-module" v-show="showTransportationSubModule">
          <div class="sub-module-item">
            <i class="fa fa-plane" aria-hidden="true"></i>
            <div class="sub-module-name">
              <router-link to="/fetch-transport">
                 出发
              </router-link>
            </div>
          </div>
        </div>
      </transition>
    </div>
  </div>
</template>

<script>
import Navi from "@/components/OldPerson/Navi/Navi.vue";
export default {
  name:'Header',
  components:{Navi},
  data() {
    return {
      showMedicalSubModule: false,
      showFoodSubModule: false,
      showAccommodationSubModule: false,
      showTransportationSubModule: false,
    }
  },
  methods: {
    showMedical() {
      this.showMedicalSubModule = !this.showMedicalSubModule
      this.showFoodSubModule = false
      this.showAccommodationSubModule = false
      this.showTransportationSubModule = false
    },
    showFood() {
      this.showMedicalSubModule = false
      this.showFoodSubModule = !this.showFoodSubModule
      this.showAccommodationSubModule = false
      this.showTransportationSubModule = false
    },
    showAccommodation() {
      this.showMedicalSubModule = false
      this.showFoodSubModule = false
      this.showAccommodationSubModule = !this.showAccommodationSubModule
      this.showTransportationSubModule = false
    },
    showTransportation() {
      this.showMedicalSubModule = false
      this.showFoodSubModule = false
      this.showAccommodationSubModule = false
      this.showTransportationSubModule = !this.showTransportationSubModule
    },
  },
}
</script>

<style>
.container {
  padding-left: 15rem;
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
