<template>
    <div class="main-header">
        <div class="header-logo">
            ToDo
        </div>
        <div class="header-search">
            <v-input inpW="50" inpH="30" cls="header-input" />
            <v-btn cls="header-search-btn">검색</v-btn>
        </div>
        <div class="header-info">
            <div class="info-time">
                2020-08-02 월
            </div>
            <div class="info-navi">
                <v-btn cls="header-login-btn">로그인</v-btn>
            </div>
        </div>
    </div>
</template>

<script>
    import Input from "../components/Input"
    import Btn from "../components/Btn"

    export default {
        name: "MainHeader",
        components:{
            "v-input":Input,
            "v-btn":Btn,
        }
    }
</script>

<style lang="scss" scoped>

    .main-header{
        height: 70px;
        text-align: left;

        .header-search{
            float: left;
            width: 74%;
        }

        .header-logo{
            font-size: 45px;
            font-weight: bold;
            float:left;
        }

        .header-info{
            float:right;
        }
    }

</style>