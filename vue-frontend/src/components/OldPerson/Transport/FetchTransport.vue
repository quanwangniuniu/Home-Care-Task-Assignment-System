<template>
  <Navi></Navi>
  <div class="bg agileinfo">
    <h1 class="agile_head text-center">什么时候出发都不算太晚</h1>
    <div class="container w3">
      <form @submit.prevent="submitForm" class="agile_form">
        <h3 style="color: red">发送交通派单时，请不要离开该界面！</h3>
        <div class="clear"></div>
        <input type="text" placeholder="你的名字" v-model="formData.name" class="name agileits" required=""/>
        <p>你从哪来:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;要到哪去:</p>
        <div class="list_agileits_w3layouts">
          <div class="section_class_agileits sec-left">
            <select v-model="formData.sourceCity">
              <option value="0">Source City</option>
              <option value="1">city1</option>
              <option value="2">city2</option>
              <option value="3">city3</option>
              <option value="4">city4</option>
            </select>
          </div>
          <div class="section_class_agileits sec-right">
            <select v-model="formData.destinationCity">
              <option value="0">Destination City</option>
              <option value="1">city1</option>
              <option value="2">city2</option>
              <option value="3">city3</option>
              <option value="4">city4</option>
            </select>
          </div>
          <div class="clear"></div>
        </div>
        <div class="list_agileits_w3layouts">
          <input type="text" placeholder="手机号" v-model="formData.phone" class="name agileits" required=""/>
        </div>
        <div class="clear"></div>
        <div class="submit">
          <input type="submit" value="开始寻找最近的司机">
          <button @click="matched=true"  class="cf-btn"> 查看已经匹配到的司机和信息</button>>
          <p v-if="matched=true">司机姓名:{{this.driverInfo.name}}</p>
          <p v-if="matched=true">司机电话:{{this.driverInfo.phone}}</p>
          <p v-if="matched=true">司机距离:{{this.driverInfo.distance}}</p>
          <p v-if="matched=true">预估价格:{{this.driverInfo.price}} 元</p>
        </div>
      </form>
    </div>
  </div>
</template>


<script>
import Navi from "@/components/OldPerson/Navi/Navi.vue";
import axios from "axios";

export default {
  name: "FetchTransport",
  components:{Navi},
  data() {
    return {
      matched:false,
      formData: {
        name: '',
        sourceCity: '',
        destinationCity: '',
        phone: ''
      },
      driverInfo:{
        name:'',
        phone:'',
        distance:'',
        price:'',
      }
    }
  },
  methods: {
    submitForm() {
      // 将formData发送到后端
      axios.post('http://localhost:8080/transport', this.formData)
          .then(response => {
            console.log(response.data)
            this.driverInfo = response.data
          })
          .catch(error => {
            console.log(error)
          })
    }
  }
}
</script>

<style scoped>
/*--reset--*/
table{border-collapse:collapse;border-spacing:0;}
/*--start editing from here--*/
a{text-decoration:none;}
.txt-rt{text-align:right;}/* text align right */
.txt-lt{text-align:left;}/* text align left */
.txt-center{text-align:center;}/* text align center */
.float-rt{float:right;}/* float right */
.float-lt{float:left;}/* float left */
.clear{clear:both;}/* clear float */
.pos-relative{position:relative;}/* Position Relative */
.pos-absolute{position:absolute;}/* Position Absolute */
.vertical-base{	vertical-align:baseline;}/* vertical align baseline */
.vertical-top{	vertical-align:top;}/* vertical align top */
nav.vertical ul li{	display:block;}/* vertical menu */
nav.horizontal ul li{	display: inline-block;}/* horizontal menu */
img{max-width:100%;}
/*--end reset--*/

body {
  margin:0;
  font-family: 'Asap', sans-serif;
}
h1,h2,h3,h4,h5,h6,input,p,a,select,button,textarea,label{
  margin:0;
  font-family: 'Asap', sans-serif;
}
body a{
  transition:0.5s all;
  -webkit-transition:0.5s all;
  -moz-transition:0.5s all;
  -o-transition:0.5s all;
  -ms-transition:0.5s all;
  text-decoration: none;}

input[type="button"],input[type="submit"]{
  transition:0.5s all;
  -webkit-transition:0.5s all;
  -moz-transition:0.5s all;
  -o-transition:0.5s all;
  -ms-transition:0.5s all;
}
h1,h2,h3,h4,h5,h6{
  margin:0;
  transition:0.5s all;
  -webkit-transition:0.5s all;
  -moz-transition:0.5s all;
  -o-transition:0.5s all;
  -ms-transition:0.5s all;
}
p {
  margin: 0;
  line-height: 2;
  color: #84c3bb;
  font-size: 0.9em;
}

ul{
  margin:0;
  padding:0;
}
label{
  margin:0;

}
.text-center {
  text-align: center;
}
.clear{
  clear:both;
}

::-webkit-input-placeholder {
  color: #777;
}
:-moz-placeholder { /* Firefox 18- */
  color: #777;
}
::-moz-placeholder {  /* Firefox 19+ */
  color: #777;
}
:-ms-input-placeholder {
  color:#999;
}
.container {
  padding: 2.5em;
  width: 400px;
  margin: 3em auto;
  background: rgba(0, 0, 0, 0.55);
  background-size: 1500px,459px;
}
.bg {
  background-size: cover;
  background: url("images/1.jpeg") no-repeat fixed center;
  width:2500px;
  margin-left: 15rem;
}
h1.agile_head {
  font-size: 3.2em;
  text-transform: uppercase;
  color: #fff;
  font-weight: 500;
  padding-top: 1.2em;
  letter-spacing: 3px;
}
h2.w3layouts {
  padding: 0.5em 0 0;
  font-size: 0.9em;
  color: #d4d4d4;
  letter-spacing: 1px;
  text-align: left;
  margin-bottom: 1.5em;
  margin-top: -10rem;
  line-height:2;
}
.agile_form ul {
  list-style-type: none;
}
.agile_form ul li{
  position: relative;
  width: 30%;
  display: inline-block;
}
.agile_form ul li input[type=radio]{
  position: absolute;
  visibility: hidden;
}
.agile_form ul li label{
  display: block;
  position: relative;
  font-size: 1em;
  padding: 0.5em 0em 0.5em 3em;
  margin: 0px 0 0px 1em;
  z-index: 9;
  cursor: pointer;
  text-transform: capitalize;
  -webkit-transition: all 0.25s linear;
  color: #fff;
}
.agile_form ul li label:hover {
  color:#fff;
}
.checkbox {
  position: relative;
  padding-left: 38px !important;
  cursor: pointer;
}
ul li .check{
  display: block;
  position: absolute;
  border: 3px solid #fff;
  border-radius: 100%;
  height: 13px;
  width: 13px;
  top: 8px;
  left: 35px;
  z-index: 5;
  transition: border .25s linear;
  -webkit-transition: border .25s linear;
}
.agile_form ul li:hover .check {
  border: 3px solid #FFFFFF;
}

.agile_form ul li .check::before {
  display: block;
  position: absolute;
  content: '';
  border-radius: 100%;
  height: 5px;
  width: 5px;
  top: 4px;
  left: 4px;
  margin: auto;
  transition: background 0.25s linear;
  -webkit-transition: background 0.25s linear;
}

.agile_form input[type=radio]:checked ~ .check {
  border: 3px solid  #008e90;
}

.agile_form input[type=radio]:checked ~ .check::before{
  background: #fff;
}

.agile_form input[type=radio]:checked ~ label{
  color: #03aaad;
}

.agile_form input[type=text]{
  padding: 0.8em 1.8em;
  color: #000;
  width: 87%;
  font-size: 0.85em;
  outline: none;
  border: none;
  border-radius: 30px;
  background: #fff;
  letter-spacing: 1px;
  -webkit-appearance: none;
}
input.name {
  margin: 1.5em 0;
}
.section_class_agileits select {
  border: none;
  outline: none;
  border-radius: 30px;
  font-size: 0.9em;
  width:100%;
  padding: 0.8em 1.5em;
  color: #777!important;
  -webkit-appearance: none;
}

.section_class_agileits{
  margin: 1.5em 0 0;
}
.sec-left{
  float:left;
  width: 48%;
}
.sec-right{
  float:right;
  width: 48%;
}
.date {
  cursor: pointer;
}
.submit input[type=submit] {
  color: #fff;
  padding: 0.8em;
  font-size: 0.9em;
  cursor: pointer;
  border: none;
  border-radius: 30px;
  background: #008e90;
  outline: none;
  margin: 1.5em 0 0;
  font-weight: 400;
  text-transform: capitalize;
  width: 100%;
}

.submit input[type="submit"]:hover {
  background: #fff;
  color: #000;
}
.agileits_w3layouts_copyright p {
  color: #fff;
  font-size: 1em;
  margin-bottom:1em;
}
.agileits_w3layouts_copyright a{
  color: #fff;
}
.agileits_w3layouts_copyright a:hover{
  color: #008e90;
}

/* -- Responsive code -- */
@media screen and (max-width: 1440px){
  .container {
    width: 30%;
  }
  .agile_form input[type=text] {
    width: 88%;
  }
}
@media screen and (max-width: 1280px){
  .container {
    width: 32%;
  }
}
@media screen and (max-width: 1080px){
  .container {
    width: 37.4%;
  }
}

@media screen and (max-width: 1024px){
  h1.agile_head {
    font-size: 3em;
    padding-top: 0.5em;
  }
  .container {
    padding: 2em;
    margin: 2em auto;
  }
  .agile_form input[type=text] {
    width: 87%;
  }
}
@media screen and (max-width: 991px){
  .container {
    width: 38%;
  }
  .agile_form input[type=text] {
    width: 86.5%;
  }
}
@media screen and (max-width: 800px){
  h1.agile_head {
    font-size: 2.9em;
  }
  .container {
    width: 47%;
    padding: 2.5em;
  }

}
@media screen and (max-width: 768px){
  h1.agile_head {
    padding-top: 1.5em;
  }
  .container {
    padding: 2.5em;
    margin: 3em auto;
    width: 50%;
  }
}
@media screen and (max-width: 736px){
  .container {
    width: 51%;
    margin: 2em auto;
  }
  h1.agile_head {
    padding-top: 1em;
  }
}
@media screen and (max-width: 667px){
  .container {
    width: 57%;
  }
  h1.agile_head {
    font-size: 2.7em;
  }
}
@media screen and (max-width: 640px){
  .container {
    padding: 2.5em;
    margin: 2em auto;
    width: 59%;
  }
  h1.agile_head {
    padding-top: 0.5em;
  }
}
@media screen and (max-width: 600px){
  .container {
    width: 63%;
  }
}
@media screen and (max-width: 568px){
  .container {
    width: 67%;
  }
}
@media screen and (max-width: 480px){
  h1.agile_head {
    font-size: 2.5em;
  }
  .container {
    width: 80%;
    padding: 2em;
  }
}
@media screen and (max-width: 414px){
  .agileits_w3layouts_copyright p {
    padding: 0 1em;
  }
  h1.agile_head {
    font-size: 2.4em;
  }
  .agile_form input[type=text] {
    width: 84%;
  }
  .sec-left,.sec-right{
    width: 100%;
  }
}
@media screen and (max-width: 384px){
  .container {
    width: 77%;
  }
  .agile_form input[type=text] {
    width: 82%;
  }
  .section_class_agileits select {
    font-size: 0.8em;
  }

}
@media screen and (max-width: 375px){
  .agileits_w3layouts_copyright p {
    font-size: 0.9em;
  }
}
@media screen and (max-width: 320px){
  .agile_form input[type=text] {
    width: 79%;
  }
  ul li .check {
    left: 0px;
  }
  h1.agile_head {
    font-size: 2em;
  }
  .agile_form ul li label {
    padding: 0.5em 0em 0.5em 0.7em;
  }
}
.agileinfo{
  width: 1200px;
}
/* -- //Responsive code -- */

.cf-btn {
  display: inline-block;
  padding: 0.75rem 1.5rem;
  font-size: 1rem;
  font-weight: 700;
  line-height: 1;
  text-align: center;
  white-space: nowrap;
  vertical-align: middle;
  cursor: pointer;
  color: #fff;
  background-color: #FF5722;
  border: 1px solid transparent;
  border-radius: 0.25rem;
  transition: all 0.3s ease-in-out;
  margin-top: 4rem;
}

.cf-btn:hover {
  color: #fff;
  background-color: #F44336;
  border-color: #F44336;
}
</style>