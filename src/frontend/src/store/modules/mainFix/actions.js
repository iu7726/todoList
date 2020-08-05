import axios from 'axios'

export default {

    getCategory({ commit }){
        axios.get('/api/main').then(res => {
            commit('initCategory',res.data);
        })
    }

};