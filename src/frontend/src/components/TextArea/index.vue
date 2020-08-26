<template>
    <div class="type-textarea">
        <textarea class="ta-basic" :class="[cls]" @input="taInput"></textarea>
    </div>
</template>

<script>
    export default {
        name: "index.vue",
        props:['cls'],
        methods:{
            taInput(event){
                this.$emit("input",event.target.value)
            }
        }
    }
</script>

<style lang="scss" scoped>
    .type-textarea{

        .ta-basic {
            resize: none;
        }

        .add-work-content{

            width: 60%;
            height: 16vh;
            min-height: 135px;

        }

    }
</style>