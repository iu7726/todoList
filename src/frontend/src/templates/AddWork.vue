<template>
    <div class="add-work">
        <div class="add-header">
            <div class="header-text">추가하기</div>
            <v-btn cls="add-close" @btnClick="popClose">X</v-btn>
        </div>

    </div>
</template>

<script>

    import Btn from "@/components/Btn"

    export default {
        name: "AddWork",
        components:{
            'v-btn':Btn,
        },
        methods:{
            popClose(){
                this.$emit('addPopClose');
            }
        }
    }
</script>

<style lang="scss" scoped>
    .add-work{
        position: absolute;
        background: #fff;
        top: 29%;
        left: 34%;
        width: 41%;
        height: 37vh;
        border: 1px solid #000;
        z-index: 2;

        .add-header{
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
    }
</style>