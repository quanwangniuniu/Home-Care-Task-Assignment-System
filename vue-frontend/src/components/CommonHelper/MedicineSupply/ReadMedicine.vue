<template>
  <Navi></Navi>
  <div class="drug-purchase">
    <div class="container">
      <h2 class="title">药品注意事项：</h2>
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
        '了解医疗保险计划和药方计划如何支付药物',
        '确定患者的病情并从医生那里获得完整的处方',
        '检查药物的保质期，确保它们没有过期',
        '详细阅读说明书，了解用药方法、频率、用量、可能的副作用和注意事项',
        '咨询经验丰富的药剂师',
        '确保购买的药物与患者已经在服用的药物没有不良的相互作用',
        '定期到医生那里检查患者的健康状况，并确保他们正常服药',
        '检查是否需要将所购买的药物进行记录，以便他们能够记得什么时候服用'
      ]
    }
  }
}
</script>

<style scoped>
.drug-purchase {
  background-color: rgba(201, 231, 92, 0.97);
  width: 180%;
  color: #333;
  font-size: 25px;
  font-family: Arial, Helvetica, sans-serif;
  line-height: 1.5;
  padding: 20px 15px;
  margin-left: 16rem;
}

.container{
  margin-left: 6rem;
  width: 80%;
  max-width: 1200px;
  padding: 0 5px;
}

.title {
  font-size: 32px;
  font-weight: bold;
  margin-bottom: 30px;
}

.content {
  font-size: 23px;
  line-height: 1.8;
  margin-bottom: 60px;
  margin-left:5rem;
}

ul {
  padding-left: 30px;
  border: 1px solid red;
}

li {
  margin-bottom: 10px;
}
</style>
