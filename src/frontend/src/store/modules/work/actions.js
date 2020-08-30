import axios from 'axios'

const qs = require('qs');

export default {

	addWork({ commit }, payload) {
		axios.post('/api/workAdd', qs.stringify(payload)).then(res => {
			commit("addWorkList", res.data);
		})
	},

	getWorkList({ commit }, payload){
		axios.get('/api/workList', {params:payload}).then(res => {
			commit('initWorkList', res.data);
		})
	},

	modWork({ dispatch }, payload){
		axios.post("/api/workMod", qs.stringify(payload.modData)).then(() => {
			dispatch('getWorkList',payload.listData)
		})
	},

	delWork({ dispatch }, payload){
		axios.post("/api/workDel", qs.stringify(payload.delData)).then(() => {
			dispatch("getWorkList", payload.listData);
		})
	}

};