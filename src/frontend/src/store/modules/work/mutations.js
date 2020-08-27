export default {

    fakeMutation(state, payload) {
        console.log(state, payload);
    },

    addWorkList(state,payload){
        state.workList.push(payload)
    },

    initWorkList(state, payload){
        state.workList = payload;
    }

};