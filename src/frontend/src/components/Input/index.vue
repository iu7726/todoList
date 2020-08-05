<template>
    <div class="type-input">
        <input :class="[cls]" :style="{width:inpW, height:inpH}"/>
    </div>
</template>

<script>
    export default {
        name: "Input",
        props:{
            inpW: {
              type:Number,
              default:30,
            },

            inpH: {
              type:Number,
              default:20,
            },

            cls: {
              type:String,
            }

        },
        mounted() {
            console.log(this.inpW, this.inpH)
        }
    }
</script>

<style lang="scss" scoped>
    .type-input{

        .header-input{

            width: 30%;
            height: 30px;
            float: left;
            margin-left: 39%;
            margin-top: 8px;

        }

    }
</style>