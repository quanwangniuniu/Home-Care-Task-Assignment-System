<template>
  <div class="drug-purchase">
    <Navi></Navi>
    <div class="container">
      <h2 class="title">购买食物的注意事项：</h2>
      <div class="content">
        <ul>
          <li v-for="(item, index) in considerations" :key="index">{{ item }}</li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import Navi from "@/components/CommonHelper/Navi/Navi.vue";
export default {
  components:{Navi},
  data() {
    return {
      considerations: [
        '确认订单的准确性，包括菜品种类、数量、价格等信息',
        '注意饭菜的保存温度和时间，确保食品卫生和质量。',
        ' 如果顾客有特殊要求，例如口味、饭量等，需要尽可能满足。',
        '在送餐时要仔细检查餐品的完整性和正确性，避免漏送或错送。',
        '如果有食品过敏或特殊需求，应当特别注意，避免出现不必要的麻烦。',
        '遵守交通规则，注意交通安全，在送餐过程中要小心驾驶。',
        '在送达后，与顾客确认订单是否正确，确保服务质量和客户满意度。',
        '确保及时回收外卖包装袋等垃圾，保持环境整洁，关注环境保护。',
      ]
    }
  }
}
</script>

<style scoped>
.drug-purchase {
  background-color: rgba(34, 66, 115, 0.24);
  width: 210%;
  color: #333;
  font-size: 25px;
  font-family: Arial, Helvetica, sans-serif;
  line-height: 1.5;
  padding: 30px 25px;
  margin-right: 10rem;
  margin-left: 16rem;
}

.container{
  margin: 0 auto 0 0%;
  width: 90%;
  max-width: 1200px;
  padding: 0 15px;
}

.title {
  font-size: 32px;
  font-weight: bold;
  margin-bottom: 30px;
  color: #3028c5;
}

.content {
  font-size: 23px;
  line-height: 1.8;
  margin-bottom: 60px;
  color: lightgoldenrodyellow;
}

ul {
  padding-left: 30px;
  border: 1px solid #49e68d;
}

li {
  margin-bottom: 10px;
}
</style>
