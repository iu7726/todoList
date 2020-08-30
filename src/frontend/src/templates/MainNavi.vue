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
        <div class="navi-row setting" @click="settingView = true" >
            설정하기
        </div>
        <category-setting v-show="settingView" :list="categoryList" @popClose="settingView = false"></category-setting>
    </div>
</template>

<script>

    import {mapActions, mapGetters} from "vuex"

    import categorySetting from "@/templates/CategorySetting"

    export default {
        name: "MainNavi",
        components:{
            'category-setting':categorySetting
        },
        data() {
            return{
                naviList:[],
                selectId:0,
                settingView:false,
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
                getWorkList:'work/getWorkList'
            }),

            selectNavi(navi){
                this.getWorkList({GROUP_ID:1, TU_ID:1, CATEGORY_ID: navi.id})
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
            margin-bottom: 2%;

            &.active{
                background: #2c3e50;
                color:#fff;
            }

            &.setting{
                margin-top: 1%;
            }
        }

        .navi-row:hover{
            background: #2c3e50;
            color:#fff;
        }
    }
</style>