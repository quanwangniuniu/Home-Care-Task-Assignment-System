<template>
  <Navi></Navi>
  <div class="zjlist">
    <div class="container">
      <div class="row">
        <div class="common-title">
          <h2>医院专家</h2>
          <span>权威专业团队为您提供集“预防、康复和诊疗为一体”的个性化服务</span>
        </div>
        <div class="col-xs-6 col-sm-4 col-md-4">
          <div class="thumbnail">
            <img src="images/phone.png" alt="" class="img-responsive" />
            <div class="caption hidden-xs">
              <p style="margin-top:2rem;text-align: center;margin-bottom:5rem;font-size: large " > 西方著名医学专家Bob Decjobs</p>
              <p class="descript">因为细胞结构的改变与组织损伤的关系研究获得2项省部级科技进步二等奖
              </p>
              <br>
              <a href="http://localhost:8080/Oldchat.html" style="font-size: larger">->开始在线问诊</a>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>


</template>

<script>
import Navi from "@/components/OldPerson/Navi/Navi.vue";

export default {
  name: "FetchDoctor",
  components:{Navi},
}
</script>

<style scoped>
.descript {
  background-color: #bdde12;
  color: rgba(35, 107, 215, 0.24);
  padding: 10px;
  font-size: 16px;
  text-align: center;
}

.zjlist{margin-top: 10rem; margin-bottom: 50px; margin-left: -3rem}
.zjlist img{width:100%;border:1px solid #f5f5f5;}
.zjlist .descript{text-indent: 2em; font-size:16px; text-align:left;color:#6D6C6C; height: 66px; overflow: hidden;}
.zjlist .caption .mo-re{margin:0 auto;font-size:16px;}
.zjlist .caption .mo-re p{ height: 30px; padding:3px 15px;}
.zjlist .caption .mo-re a:hover {
  transform: translateY(-23px);
}
.zjlist .zj_move p{ position: absolute;width:100%; height:100%;top:0px;left:0px; line-height:30em; font-size:16px;color:#fff;
}
.zjlist .zj_move p:hover::before{width:55px; height: 55px; line-height: 55px; transition: all 0.3s  ease-out; transform-origin: center center;}
.zjlist .col-xs-6{ margin-bottom: 30px; padding: 0px 40px; }
.zj_move a{ display: block; }

img{
  width: 200px;
  height:600px;
}
</style>