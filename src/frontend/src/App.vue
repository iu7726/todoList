<template>
    <div id="app">
        <main-header></main-header>
        <main-navi></main-navi>
        <router-view class="main-content" />
    </div>
</template>

<script>

    import mainHeader from "./templates/MainHeader"
    import mainNavi from "./templates/MainNavi"

    export default {
        name:"App",
        components:{
            "main-header" : mainHeader,
            "main-navi" : mainNavi
        }
    }
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}


    .main-content{
        float: left;
        width: 70%;
    }
</style>
