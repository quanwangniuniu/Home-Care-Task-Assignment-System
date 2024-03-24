<template>
  <div class="sidebar">
    <ul class="nav flex-column">
      <li v-for="(item, index) in menu" :key="index" class="nav-item">
        <router-link :to="item.link" class="nav-link">
          <i :class="item.icon"></i>
          <span>{{ item.text }}</span>
          <i v-if="item.children" class="fa fa-angle-right"></i>
        </router-link>
        <ul v-if="item.children" class="nav flex-column">
          <li v-for="(child, childIndex) in item.children" :key="childIndex" class="nav-item">
            <router-link :to="child.link" class="nav-link">{{ child.text }}</router-link>
          </li>
        </ul>
      </li>
    </ul>
  </div>
</template>

<script>
import { defineComponent } from 'vue';
import { useRoute } from 'vue-router';

export default defineComponent({
  name: 'Sidebar',
  data() {
    return {
      menu: [
        {
          text: '医疗',
          link: '/HeaderII',
          icon: 'fa fa-home',
          children: [
            {
              text: '在线问诊',
              link: '/fetch-doctor',
            },
            {
              text: '药品配送',
              link: '/fetch-medicine',
            },
          ],
        },
        {
          text: '餐饮',
          link: '/HeaderII',
          icon: 'fa fa-utensils',
          children: [
            {
              text: '附近餐厅',
              link: '/restaurantInfo',
            },
            {
              text: '餐饮配送',
              link: '/fetch-food',
            },
          ],
        },
        {
          text: '住宿',
          link: '/HeaderII',
          icon: 'fa fa-hotel',
          children: [
            {
              text: '寻找房源',
              link: '/houseInfo',
            },
            {
              text: '寻找养老院',
              link: '/fetch-deadRoom',
            },
          ],
        },
        {
          text: '交通',
          link: '/HeaderII',
          icon: 'fa fa-bus',
          children: [
            {
              text: '我要出发',
              link: '/fetch-transport',
            },
          ],
        },
      ],
    };
  },
});
</script>

<style scoped>
/* Color Palette */
:root {
  --primary-color: #e75c5c;
  --secondary-color: rgba(117, 55, 55, 0.92);
}
li{
  list-style-type: none;
  font-size: 18px;
}
.sidebar {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  width: 240px;
  background-color: var(--secondary-color);
  padding: 15px;
}

.nav-link {
  display: flex;
  align-items: center;
  padding: 10px 0;
  color: var(--primary-color);
  transition: background-color 0.2s ease;
}

.nav-link i {
  margin-right: 10px;
}

.nav-link:hover {
  color: rgba(252, 33, 220, 0.96);
  background-color: var(--primary-color);
  text-decoration: none;
}

.nav-link.active {
  color: #fff;
  background-color: var(--primary-color);
}

.nav-item .nav {
  padding-left: 20px;
}

.fa-angle-right {
  margin-left: auto;
}

/* Submenu colors */
.nav-item ul {
  background-color: rgb(201, 231, 92);
  border: 1px solid var(--secondary-color);
  border-radius: 5px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  padding: 10px;
  margin-top: 5px;
}

.nav-item ul li a {
  color: var(--primary-color);
  display: block;
  padding: 5px 0;
  transition: background-color 0.2s ease;
}

.nav-item ul li a:hover {
  color: #5c63e7;
  background-color: var(--primary-color);
}
</style>
