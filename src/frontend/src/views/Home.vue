<template>
	<div class="home">
		<full-calendar
			class="work-calendar"
			:events="events"
			:config="calendarOptions"
			@event-selected="viewWork"
			@event-drop="moveWork"
		></full-calendar>
		<!-- <div class="work-body today">
			<div class="work-title">
				오늘의 할일 목록입니다.
			</div>
			<div class="work-list">
				<ul>
					<li v-for="(work, idx) in events" :key="'today_work_'+work.id">
						{{idx + 1}}. {{work.title}}
					</li>
				</ul>
			</div>
		</div>
		<div class="work-body yesterday">
			<div class="work-title">
				완료 못한 목록입니다.
			</div>
			<div class="work-list">
				<ul>
					<li>
						1.test1
					</li>
				</ul>
			</div>
		</div>
		<div class="work-body">
			
		</div> -->
		<div class="btn-body">
			<v-btn cls="add-work-btn" @btnClick="addPopView = true">추가하기</v-btn>
			<v-btn cls="add-work-btn" @btnClick="complateView = true">완료한 목록 보기</v-btn>
		</div>
		<add-work v-show="addPopView" @addPopClose="addPopView = false"></add-work>
		<mod-work
			:pickEvent="pickEvent"
			v-show="modPopView"
			@modPopClose="modPopView = false"
		></mod-work>
		<complate-work v-show="complateView" :list="complate" @complateClose="complateView = false"></complate-work>
	</div>
</template>

<script>
import { FullCalendar } from "vue-full-calendar";
import "fullcalendar/dist/fullcalendar.css";
import Btn from "@/components/Btn";
import addWork from "@/templates/AddWork";
import modWork from "@/templates/ModWork";
import complateWork from "@/templates/ComplateWork";
import { mapActions, mapGetters } from "vuex";

export default {
	name: "Home",
	components: {
		'full-calendar':FullCalendar,
		"v-btn":Btn,
		'add-work':addWork,
		'mod-work':modWork,
		'complate-work':complateWork,
	},
	data(){
		return {
			calendarOptions:{
				aspectRatio:3,
				locale:'ko',
			},
			addPopView:false,
			modPopView:false,
			events:[],
			complate:[],
			pickEvent:[],
			complateView:false,
		}
	},
	watch:{
		workList(val){

			this.events = val.filter(i => !i.tw_CHECK).map(i => {
				return {
					id:i.id,
					groupId:i.group_ID,
					start:i.tw_START,
					end:i.tw_END,
					title:i.tw_TITLE,
					contents:i.tw_CONTENTS,
					category:i.category_ID,
					check:i.tw_CHECK
				}
			});

			this.complate = val.filter(i => i.tw_CHECK).map(i => {
				return {
					id:i.id,
					groupId:i.group_ID,
					start:i.tw_START,
					end:i.tw_END,
					title:i.tw_TITLE,
					contents:i.tw_CONTENTS,
					category:i.category_ID,
					check:i.tw_CHECK
				}
			});
		},
	},
	computed:{
		...mapGetters({
			workList:'work/workList',
			getPickCate:"mainFix/getPickCate"
		}),
	},
	mounted() {
		this.getWorkList({GROUP_ID:1, TU_ID:1, CATEGORY_ID: 2})
	},
	methods:{

		...mapActions({
			getWorkList:'work/getWorkList'
		}),

		viewWork(event){
			this.modPopView=true;
			this.pickEvent = event
		},

		moveWork(event){
			console.log(event)
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
				height: 15vh;
				overflow-y: auto;
			}

		}

		.btn-body{
			padding-left:22%;
		}
	}
</style>
