<template>
  <Navi></Navi>
  <div class="salepage">
    <div class="pbanner">
      <figure>
        <img src="src/assets/Img/neibanner.jpg" alt="" />
      </figure>
      <div class="text animate fadeInUp">
        <h3>Food center</h3>
        <h2>美食中心<b></b></h2>
      </div>
    </div>
    <div class="w1200">
      <ul class="salelist">
        <li>
          <a href="">
            <figure><img src="src/assets/Img/logo1.png"/></figure>
            <figcaption>

              <p>餐馆名称：巨龙之怒泡面徐州站<br />
                入驻时间:2011年<br />
                地址：合肥市蜀山区潜山路与贵池路交口新华优阁A座
              </p>
            </figcaption>
          </a>
        </li>
        <li>
          <a href="">
            <figure><img src="src/assets/Img/logo1.png"/></figure>
            <figcaption>

              <p>商场名称：开心拌面城<br />
                入驻时间:2011年<br />
                地址：合肥市蜀山区潜山路与贵池路交口新华优阁A座
              </p>
            </figcaption>
          </a>
        </li>
        <li>
          <a href="">
            <figure><img src="src/assets/Img/logo1.png"/></figure>
            <figcaption>

              <p>餐馆名称：徐州鱼头王<br />
                入驻时间：2015年<br />
                地址：江苏省徐州市建设北路63号</p>
            </figcaption>
          </a>
        </li>
        <li>
          <a href="">
            <figure><img src="src/assets/Img/logo1.png"/></figure>
            <figcaption>

              <p>餐馆名称：楚味轩餐厅<br />
                入驻时间：2018年<br />
                地址：江苏省徐州市云龙区黄河路118号</p>
            </figcaption>
          </a>
        </li>
        <li>
          <a href="">
            <figure><img src="src/assets/Img/logo1.png"/></figure>
            <figcaption>

              <p>餐馆名称：红满天烤肉<br />
                入驻时间：2010年<br />
                地址：江苏省徐州市解放北路108号</p>
            </figcaption>
          </a>
        </li>
        <li>
          <a href="">
            <figure><img src="src/assets/Img/logo1.png"/></figure>
            <figcaption>

              <p>餐馆名称：东来顺火锅<br />
                入驻时间：2013年<br />
                地址：江苏省徐州市泉山区泉山大街189号</p>
            </figcaption>
          </a>
        </li>
        <li>
          <a href="">
            <figure><img src="src/assets/Img/logo1.png"/></figure>
            <figcaption>

              <p>餐馆名称：麦当劳<br />
                入驻时间：2002年<br />
                地址：江苏省徐州市云龙区淮海路9号</p>
            </figcaption>
          </a>
        </li>
        <li>
          <a href="">
            <figure><img src="src/assets/Img/logo1.png"/></figure>
            <figcaption>

              <p>餐馆名称：南翔小笼包<br />
                入驻时间：2014年<br />
                地址：江苏省徐州市铜山区铜山大街236号</p>
            </figcaption>
          </a>
        </li>
        <li>
          <a href="">
            <figure><img src="src/assets/Img/logo1.png"/></figure>
            <figcaption>

              <p>餐馆名称：川菜馆<br />
                入驻时间：2008年<br />
                地址：江苏省徐州市泉山区滨河路188号</p>
            </figcaption>
          </a>
        </li>
      </ul>
      <div class="fenye animated">
        <span class="prev">上一页</span>
        <a href="" class="on">1</a><a href="">2</a><a href="">3</a><a href="">4</a><a href="">5</a>
        <span class="next">下一页</span>
      </div>
    </div>
  </div>
</template>

<script>
import Navi from "@/components/OldPerson/Navi/Navi.vue";

export default {
  name: "RestaurantInfo1",
  components:{Navi},
}
</script>

<style scoped>
/*销售网络*/
.salepage{ background: #F5F5F5; padding: 50px 0;margin-left:15rem;width:1000px}
.salepage .w1200{ padding: 50px 30px; background: #fff;}
.gsdds{ padding:20px; border:1px solid #E0E0E0; overflow:hidden; margin-bottom:40px; margin: 0 auto;}
.gsdds form{ display:block; float:left; overflow:hidden; line-height:34px;}
.gsdds form input.sjs{ width:300px; height:50px; padding-left:12px; color:#666; float:left; background: #f5f5f5;}
.gsdds form input.sub{ width:80px; background:#e60012; border:none; height:50px; line-height:50px; color:#fff; float:left; cursor:pointer;}
.gsdds strong{ display:block; float:right; overflow:hidden; color:#666; line-height:50px; height:50px;}
.gsdds strong i{ color:#e60012; font-size:28px; font-family:Arial, Helvetica, sans-serif;}
.salelist{ padding:50px 0px 30px 0px;}
.salelist{ display: flex; display: -webkit-flex; justify-content: space-around; flex-wrap: wrap; display: -ms-flexbox;}
.salelist li{ width: 30%; box-shadow: 0 0 5px rgba(0,0,0,0.1);  margin-bottom: 35px; padding:20px 25px;}
.salelist li img{ display: block; margin: 20px auto 0 auto; max-width: 100%; height: auto;}
/*.salelist li h3{ color: #000; font-weight: bold; font-size: 18px; text-align: center; padding: 20px 0;}*/
.salelist li p{ font-size: 14px; color: #000; border-top: 1px solid #F5F5F5; line-height: 30px; padding-top: 15px; margin-top: 20px;}


@keyframes down{
  from{transform: translateY(-100%); opacity: 0;}
  to{transform: none; opacity: 1;}
}


@-webkit-keyframes breatheBg {
  0% { opacity: .8; -webkit-transform: scale(1);transform: scale(1);}
  100% { opacity: 1; -webkit-transform: scale(1.3);transform: scale(1.3);}
}
@keyframes breatheBg {
  0% { opacity: .8; -webkit-transform: scale(1);transform: scale(1);}
  100% { opacity: 1; -webkit-transform: scale(1.3);transform: scale(1.3);}
}




/*按钮气泡特效*/
@-webkit-keyframes bubbles {
  100% {
    background-position: 92% -220%, 31% -185%, 24% 6%, 16% -328%, 39% -366%, 110% -375%, 5% -60%, 59% -365%, 41% -363%, 82% -8%, 37% -224%;

  }
}
@keyframes bubbles {
  100% {
    background-position: 92% -220%, 31% -185%, 24% 6%, 16% -328%, 39% -366%, 110% -375%, 5% -60%, 59% -365%, 41% -363%, 82% -8%, 37% -224%;
  }
}

/*内页banner*/
.pbanner{ position:relative; overflow:hidden;}
.pbanner figure{ display:block; line-height:0; overflow:hidden;}
.pbanner figure img{ display:block; width:100%; height:auto; line-height:0; position:relative;}
.pbanner .text{ position: absolute; top: 50%; left: 50%; transform: translate(-50%,-50%);}
.pbanner h2{ color: #fff; font-size: 20px; text-transform: uppercase; width: 100%; text-align: center;
  animation: fadeInUp 1s; animation-delay: 0.3s;}
.pbanner h3{color: #fff; font-family: "Microsoft yahei"; font-size: 34px; text-transform: uppercase; text-align: center; width: 100%;
  animation: fadeInUp 1.5s; animation-delay: 0.3s;}
.pbanner b{ display: block; margin: 20px auto; height: 2px; background: #fff; width: 30px;}


@media screen and (max-width:1820px) {
  .index-sec4 .swiper-button-next{ right:15%}
  .index-sec4 .swiper-button-prev{ right: 22%;}
}

.fenye{ display: flex; display: -ms-flexbox; display: -moz-flex;  justify-content: center; align-items: center; animation-name: fadeInUp;}
.fenye a{ display: block; height: 40px; width: 40px; border-radius: 100%; background: #F5F5F5; text-align: center; line-height: 40px;
  margin: 0 20px; transition: all 0.6s;}
.fenye a.on,.fenye a:hover{ background: #e60012; color: #fff;}
.fenye span{ display: block; font-size: 16px; color: #666; margin: 0 20px; cursor: pointer;}


</style>