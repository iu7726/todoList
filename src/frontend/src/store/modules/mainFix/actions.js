import axios from 'axios'

const qs = require('qs');

export default {

    getCategory({ commit }) {
        axios.get('/api/main').then(res => {
            commit('initCategory', res.data);
        })
    },

    modPickCate({ commit }, payload) {
        commit('initPickCate', payload);
    },

    addCate({ commit }, payload){
        axios.post("/api/addCategory", qs.stringify(payload)).then(res => {
            commit("addCategory", res.data);
        })
    },

    modCate({ dispatch }, payload){
        axios.post("/api/modCategory", qs.stringify(payload)).then(() => {
            dispatch("getCategory");
        })
    },

    delCate({ dispatch }, payload){
        axios.post("/api/delCategory", qs.stringify(payload)).then(() => {
            dispatch("getCategory");
        })
    }

};