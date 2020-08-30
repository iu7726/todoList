<template>
    <div class="complateWork">
        <div class="header">
            <div class="header-text">완료한 목록</div>
            <v-btn cls="add-close" @btnClick="popClose">X</v-btn>
        </div>
        <div class="com-row" v-for="(item,idx) in list" :key="'complate_work_'+item.id" @click="target = idx">
            {{item.title}}
            <pre class="contents-body" v-show="target == idx">{{item.contents}}</pre>
        </div>
    </div>
</template>

<script>
import Btn from "@/components/Btn";

export default {
    name:"ComplateWork",
    props:['list'],
    components:{
        'v-btn':Btn,
    },
    data(){
        return {
            target:-1,
        }
    },
    methods:{
        popClose(){
            this.$emit('complateClose');
        }
    }
}
</script>

<style lang="scss" scoped>

    .complateWork {
        position: absolute;
        background: #fff;
        top: 17%;
        left: 34%;
        width: 41%;
        height: 56vh;
        border: 1px solid #000;
        z-index: 2;
        min-height: 302px;
        overflow-y: auto;
        z-index: 10;

        .header{
            background: #2c3e50;
            color: #fff;
            font-weight: bold;
            text-align: left;
            width: 100%;
            height: 3vh;

            .header-text{
                float:left;
            }
        }

        .com-row{
            border-bottom: 1px solid #454545;
            padding:10px;
            cursor: pointer;

            .contents-body{
                border-top : 1px dashed #454545;
            }
        }

        .com-row:hover {
            background: #c7c7c7;
        }
    }

</style>