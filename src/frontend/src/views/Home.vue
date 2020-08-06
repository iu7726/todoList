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
    </div>
</template>

<script>

    import { FullCalendar } from 'vue-full-calendar'
    import 'fullcalendar/dist/fullcalendar.css'

    export default {
        name: "Home",
        components: {
            'full-calendar':FullCalendar
        },
        data(){
            return {
                calendarOptions:{
                    aspectRatio:3
                },
                events:[],
            }
        },
        mounted() {

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
            width: 50%;
            border: 1px solid #ccccee;
            height: 10vh;

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
