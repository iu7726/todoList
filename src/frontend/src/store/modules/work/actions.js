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

	modWork({ commit }, payload){
		console.log(qs.stringify(payload))
		axios.post("/api/workMod", qs.stringify(payload)).then(res => {
			commit("modWork", res.data)
		})
	}

};