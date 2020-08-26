export default {

    fakeMutation(state, payload) {
        console.log(state, payload);
    },

    initWorkList(state, payload){
        state.workList = payload;
    }

};