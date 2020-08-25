import axios from 'axios'

const qs = require('qs');

export default {

    addWork({ commit }, payload) {
        axios.post('/api/workAdd', qs.stringify(payload)).then(res => {
            commit("fakeMutation", res.data);
        })
    }

};