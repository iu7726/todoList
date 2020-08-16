<template>
    <div class="type-btn">
        <div :class="[cls]" @click="btnClick">
            <slot></slot>
        </div>
    </div>
</template>

<script>
    export default {
        name: "index",
        props:['cls'],
        methods:{
            btnClick(){
                this.$emit('btnClick')
            }
        }
    }
</script>

<style lang="scss" scoped>
    .type-btn{
        .header-search-btn{
            float: left;
            border: 1px solid #6EB5FF;
            color: #6EB5FF;
            width: 50px;
            text-align: center;
            margin-top: 8px;
            height: 34px;
            line-height: 34px;
            margin-left: 1%;
            border-radius: 4px;
            cursor: pointer;
        }

        .header-search-btn:hover{
            background: #6EB5FF;
            color:#fff;
        }

        .header-login-btn{
            border: 1px solid #6EB5FF;
            color: #6EB5FF;
            text-align: center;
            border-radius: 4px;
            cursor: pointer;
        }

        .add-work-btn{
            border: 1px solid #6EB5FF;
            color: #6EB5FF;
            text-align: center;
            border-radius: 4px;
            cursor: pointer;
        }

        .add-close{
            float: right;
            cursor: pointer;
        }

        .save-btn{
            float:right;
            cursor: pointer;
            border:1px solid #6EB5FF;
            color: #6EB5FF;
            padding : 3px 5px;
            border-radius: 5px;
        }
    }
</style>