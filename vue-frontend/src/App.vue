<script>

import {defineComponent} from "vue";
import HaolongFooter from "@/components/HaolongFooter.vue";

export default defineComponent({
  components: {HaolongFooter}
})
</script>

<template>
    <div>
         <router-view></router-view>
    </div>
</template>

<style scoped>
div{
  width:100%
}
</style>
