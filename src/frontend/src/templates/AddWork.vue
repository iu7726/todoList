<template>
    <div class="add-work">
        <div class="add-header">
            <div class="header-text">추가하기</div>
            <v-btn cls="add-close" @btnClick="popClose">X</v-btn>
        </div>
        <div class="add-body">
            <div class="body-title">
                선택 디렉토리 : {{pickCate.cate_name}}
            </div>
            <div>
                <div>
                    시작날짜
                </div>
                <div>
                    <date-picker format="yyyy-MM-dd" @selected="selectDate"></date-picker>
                </div>
            </div>
            <div>
                <div>
                    종료날짜
                </div>
                <div>
                    <date-picker format="yyyy-MM-dd"></date-picker>
                </div>
            </div>
        </div>

    </div>
</template>

<script>
    import { mapGetters } from "vuex"

    import Btn from "@/components/Btn"

    import Datepicker from 'vuejs-datepicker';
    import moment from "moment";

    export default {
        name: "AddWork",
        components:{
            'v-btn':Btn,
            'date-picker':Datepicker,
        },
        data(){
          return{
              pickCate:[],
              date:"",
          }
        },
        watch:{
            getPickCate(val){
                this.pickCate = val;
            }
        },
        computed:{
            ...mapGetters({
                getPickCate:'mainFix/getPickCate',
            })
        },
        methods:{
            popClose(){
                this.$emit('addPopClose');
            },
            selectDate(event){
                let date = moment(event).format("YYYY-MM-DD");
                console.log(date);
            }
        },

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

        .add-body{

            text-align: left;

        }
    }
</style>