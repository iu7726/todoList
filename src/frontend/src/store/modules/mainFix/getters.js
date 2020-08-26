export default {

    categoryList(state) {
        return state.categoryList.map((i,idx) => {

            return {
                ...i,
                'select': idx == 0,
            }
        });
    },

    getPickCate(state) {
        return state.pickCate;
    }

};