<template>
  <div class="drug-purchase">
    <Navi></Navi>
    <div class="container">
      <h2 class="title">帮助找养老院的注意事项：</h2>
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
        '地理位置：选择靠近家人或朋友居住区的养老院，这样方便他们来探望老人。同时，也需要考虑交通便利程度，方便老人出行。',
        '设施设备：需要检查养老院是否有较好的医疗设施和护理设施，包括床铺、洗浴设施、门禁系统、紧急呼叫设备、安全设备等。',
        '人员素质：需要考察养老院的员工是否专业、有爱心，能够给老人提供合适的护理服务。可以和员工交流，观察他们的态度和技能。',
        '活动和娱乐：需要了解养老院是否提供适合老人参加的活动和娱乐设施，包括文化课程、健身活动、旅游等，这些可以帮助老人保持身体健康和精神愉悦。',
        '饮食安排：需要了解养老院的饮食安排是否符合老人的口味和营养需求，特别是对于有特殊饮食要求的老人，如糖尿病患者、高血压患者等。',
        '价格和收费方式：需要了解养老院的收费标准，包括住宿、护理服务和其他费用。同时，需要了解收费方式，如月结、季结、半年结等。',
        '消费者评价：需要查询养老院的消费者评价，了解其他老人和家属对养老院的评价和体验。可以通过互联网上的评价平台、社交媒体等方式获取相关信息。',
        '法律合规性：需要检查养老院是否符合国家法律规定，如是否取得合法经营执照、是否符合安全卫生标准等。'
      ]
    }
  }
}
</script>

<style scoped>
.drug-purchase {
  background-color: rgba(44, 46, 147, 0.99);
  width: 210%;
  color: #333;
  font-size: 25px;
  font-family: Arial, Helvetica, sans-serif;
  line-height: 1.5;
  padding: 30px 25px;
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
  color: #eeeeee;
}

.content {
  font-size: 20px;
  line-height: 1.8;
  margin-bottom: 60px;
  color: yellow;
}

ul {
  padding-left: 30px;
  border: 1px solid #c95ce7;
}

li {
  margin-bottom: 10px;
}
</style>
