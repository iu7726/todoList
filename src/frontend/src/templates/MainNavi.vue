<template>
    <div class="main-navi">
        <div
                v-for="navi in categoryList"
                :key="'navi_'+navi.id"
                class="navi-row"
                :class="{ active : selectId == navi.id}"
                @click="selectNavi(navi)"
        >
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
                selectId:0,
            }
        },
        watch:{
            getPickCate(val){
                this.selectId = val.id
            }
        },
        computed:{

          ...mapGetters({
              categoryList:'mainFix/categoryList',
              getPickCate:'mainFix/getPickCate',
          }),

        },
        mounted() {
            this.getCategory();
        },
        methods:{

            ...mapActions({
                getCategory:'mainFix/getCategory',
                modPickCate:'mainFix/modPickCate',
            }),

            selectNavi(navi){
                this.modPickCate(navi);
            }

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

            &.active{
                background: #2c3e50;
                color:#fff;
            }
        }

        .navi-row:hover{
            background: #2c3e50;
            color:#fff;
        }
    }
</style>