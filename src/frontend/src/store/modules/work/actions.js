import axios from 'axios'

export default {

    addWork({ commit }, payload){
        axios.post('/api/workAdd',payload).then(res => {
            commit("fakeMutation", res.data);
        })
    }

};