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
            float:left;
            border: 1px solid #6EB5FF;
            color: #6EB5FF;
            text-align: center;
            border-radius: 4px;
            cursor: pointer;
            width: 30%;
            height: 4vh;
            line-height: 4vh;
            margin-right: 5%;
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

        .save-btn:hover{
            background:#6EB5FF;
            color:#fff;
            font-weight: blod;
        }

        .del-btn{
            float:right;
            cursor: pointer;
            border:1px solid #CC0000;
            color: #CC0000;
            padding : 3px 5px;
            border-radius: 5px;
        }

        .del-btn:hover{
            background:#CC0000;
            color:#fff;
            font-weight: blod;
        }

        .complate-btn{
            float:right;
            cursor: pointer;
            border:1px solid #90AFFF;
            color: #90AFFF;
            padding : 3px 5px;
            border-radius: 5px;

            &.active{
                background:#90AFFF;
                color:#fff;
                font-weight: blod;
            }
        }

        .complate-btn:hover{
            background:#90AFFF;
            color:#fff;
            font-weight: blod;
        }
    }
</style>