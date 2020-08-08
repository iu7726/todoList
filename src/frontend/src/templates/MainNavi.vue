<template>
    <div class="main-navi">
        <div v-for="navi in categoryList" :key="'navi_'+navi.id" class="navi-row">
            {{navi.cate_name}}
        </div>
    </div>
</template>

<script>

    import {mapActions, mapGetters} from "vuex"

    export default {
        name: "MainNavi",
        data() {
            return{
                naviList:[],
            }
        },
        computed:{

          ...mapGetters({
              categoryList:'mainFix/categoryList',
          }),

        },
        mounted() {
            this.getCategory();
        },
        methods:{

            ...mapActions({
                getCategory:'mainFix/getCategory',
            })

        }
    }
</script>

<style lang="scss" scoped>
    .main-navi{
        float: left;
        width: 10%;
        height: 88vh;
        padding:10px;
        overflow-y: auto;

        .navi-row{
            height: 35px;
            border: 1px solid #2c3e50;
            line-height: 35px;
            font-weight: bold;
            cursor: pointer;
        }

        .navi-row:hover{
            background: #2c3e50;
            color:#fff;
        }
    }
</style>