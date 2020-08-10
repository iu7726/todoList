<template>
    <div class="home">
        <full-calendar class="work-calendar" :events="events" :config="calendarOptions"></full-calendar>
        <div class="work-body today">
            <div class="work-title">
                오늘의 할일 목록입니다.
            </div>
            <div class="work-list">
                <ul>
                    <li>
                        1.test
                    </li>
                    <li>
                        2.test2
                    </li>
                    <li>
                        3.test3
                    </li>
                    <li>
                        1.test
                    </li>
                    <li>
                        2.test2
                    </li>
                    <li>
                        3.test3
                    </li>
                    <li>
                        1.test
                    </li>
                    <li>
                        2.test2
                    </li>
                    <li>
                        3.test3
                    </li>
                </ul>
            </div>
        </div>
        <div class="work-body yesterday">
            <div class="work-title">
                어제 하지 못한 목록입니다.
            </div>
            <div class="work-list">
                <ul>
                    <li>
                        1.test1
                    </li>
                    <li>
                        2.test2
                    </li>
                    <li>
                        3.test3
                    </li>
                </ul>
            </div>
        </div>
        <div class="work-body">
            <v-btn cls="add-work-btn" @btnClick="addPopView = true">추가하기</v-btn>
        </div>
        <add-work v-show="addPopView" @addPopClose="addPopView = false"></add-work>
    </div>
</template>

<script>

    import { FullCalendar } from 'vue-full-calendar'
    import 'fullcalendar/dist/fullcalendar.css'

    import Btn from "../components/Btn"

    import addWork from "../templates/AddWork"

    export default {
        name: "Home",
        components: {
            'full-calendar':FullCalendar,
            "v-btn":Btn,
            'add-work':addWork,
        },
        data(){
            return {
                calendarOptions:{
                    aspectRatio:3,
                    locale:'ko'
                },
                addPopView:false,
                events:[
                    {
                        id: 'a',
                        title: 'my event',
                        start: '2020-08-08',
                        end : '2020-08-09 23:20:00',
                    },
                    {
                        id: 'b',
                        title: 'my event2',
                        start: '2020-08-08',
                        end : '2020-08-09 23:20:00',
                    },
                    {
                        id: '1',
                        groupId:'13',
                        title: 'my group event',
                        start: '2020-08-10',
                        end : '2020-08-15 23:20:00',
                    },
                    {
                        id: '2',
                        groupId:'13',
                        title: 'my group event2',
                        start: '2020-08-11',
                        end : '2020-08-12 23:20:00',
                    }
                ],
            }
        },
        watch:{
        },
        mounted() {

        },
        methods:{
            addView(){
                console.log("얍얍")
            }
        }
    };
</script>

<style lang="scss" scoped>

    .home{

        display: inline-block;

        .work-calendar{

            overflow-y: auto;
            height: 67vh;
        }

        .work-body{
            float: left;
            width: 33%;
            border: 1px solid #ccccee;
            height: 18vh;

            ul {
                margin:0px;
                padding: 3px 0px 0px 0px;

                li {
                    list-style: none
                }
            }

            .work-title{

                background: #bbc3dd;
                color:#fff;

            }

            .work-list{
                height: 7vh;
                overflow-y: auto;
            }



        }
    }


</style>
