<template>
    <div class="main-navi">
        <div v-for="navi in naviList" :key="'navi_'+navi.id">
            {{navi.cate_name}}
        </div>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "MainNavi",
        data() {
            return{
                naviList:[],
            }
        },
        mounted() {
            this.getCategory();
        },
        methods:{

            getCategory(){
                axios.get('/api/main').then(res => {
                    this.naviList = res.data;
                })
            }

        }
    }
</script>

<style scoped>
    .main-navi{
        float: left;
        width: 30%;
        height: 100%;
    }
</style>