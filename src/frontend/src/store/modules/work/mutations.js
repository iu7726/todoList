export default {

	addWorkList(state,payload){
		state.workList.push(payload)
	},

	initWorkList(state, payload){
		state.workList = payload;
	},

	modWork(state, payload){

		state.workLIst = state.workList.map(i => {

			if(i.id == payload.id){

				i.tw_TITLE = payload.tw_TITLE
				i.tw_START = payload.tw_START
				i.tw_END = payload.tw_END
				i.tw_CONTENTS = payload.tw_CONTENTS
				i.category_ID = payload.category_ID
				i.tw_CHECK = payload.tw_CHECK

			}
				
			return i;

		})

	},

	delWork(state, payload){

		state.workList = state.workLIst.filter(i => i.id != payload.id);

	}


};