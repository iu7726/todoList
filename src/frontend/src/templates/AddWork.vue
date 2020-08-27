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
            <div class="date-select-box">
                <div>
                    시작날짜
                </div>
                <div class="box-date">
                    <date-picker format="yyyy-MM-dd" @selected="selectStartDate"></date-picker>
                </div>
                <div class="box-time">
                    <select v-model="startTime">
                        <option v-for="(time,idx) in timeList" :key="'start_time_'+idx" :value="time">{{ time }}</option>
                    </select>
                </div>
            </div>
            <div class="date-select-box">
                <div>
                    종료날짜
                </div>
                <div class="box-date">
                    <date-picker format="yyyy-MM-dd" @selected="selectEndDate"></date-picker>
                </div>
                <div class="box-time">
                    <select v-model="endTime">
                        <option v-for="(time,idx) in timeList" :key="'end_time_'+idx" :value="time">{{ time }}</option>
                    </select>
                </div>
            </div>

            <div class="add-content">
                <div class="content-title">
                    제목
                    <v-input cls="add-work-title" @input="workTitleInput"/>
                </div>

                <div class="content-body">
                    내용
                    <v-ta cls="add-work-content" @input="workContentInput"></v-ta>
                </div>

                <div class="add-save">
                    <v-btn cls="save-btn" @btnClick="workSave">저장하기</v-btn>
                </div>

            </div>

            
        </div>

    </div>
</template>

<script>
    import { mapActions,mapGetters } from "vuex"

    import Btn from "@/components/Btn";
    import Input from "@/components/Input";
    import Ta from "@/components/TextArea";

    import Datepicker from 'vuejs-datepicker';
    import moment from "moment";

    export default {
        name: "AddWork",
        components:{
            'v-btn':Btn,
            'date-picker':Datepicker,
            'v-input' : Input,
            'v-ta' : Ta,
        },
        data(){
            return{
                pickCate:[],
                timeList:[],
                startDate:'',
                endDate:'',
                workTitle:"",
                workContent:"",
                startTime:"",
                endTime:"",
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
        mounted() {
            this.timeListSet();
        },
        methods:{
            ...mapActions({
                addWork: 'work/addWork',
            }),
            popClose(){
                this.$emit('addPopClose');
            },
            selectStartDate(event){
                let date = moment(event).format("YYYY-MM-DD");
                this.startDate = date;
            },
            selectEndDate(event){
                let date = moment(event).format("YYYY-MM-DD");
                this.endDate = date;
            },
            timeListSet(){

                let start = moment('2020-08-13 00:00:00');
                let end = moment("2020-08-13 23:30:00");
                let flag = true;

                while(flag){
                    start.add(30,"minute");
                    this.timeList.push(start.format('HH:mm'));

                    if(Math.floor(moment.duration(end.diff(start)).asMinutes()) == 0){

                        flag = false;

                    }
                }
            },
            workTitleInput(event){
                this.workTitle = event;
            },
            workContentInput(event){
                this.workContent = event;
            },
            workSave(){
                let data = {

                    'TW_TITLE':this.workTitle,
                    'TW_CONTENTS':this.workContent,
                    'TW_START':this.startDate + " " + this.startTime,
                    'TW_END':this.endDate + " " + this.endTime,
                    "GROUP_ID":1,
                    "TU_ID":"1",
                    "TW_CHECK":0,
                    "CATEGORY_ID":this.pickCate.id

                }
                let ret = this.addWork(data);
                console.log(data, ret);
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
        min-height: 302px;

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
            padding: 10px;

            .date-select-box{
                display: inline-block;
                width: 50%;

                .box-date{
                    display: inline-block;
                    margin-right:10px;
                }

                .box-time{
                    display: inline-block;
                }
            }

        }

        .add-save{
            margin-top: -34px;
        }
    }
</style>