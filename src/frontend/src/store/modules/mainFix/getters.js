export default {

    categoryList(state) {
        return state.categoryList.map(i => {

            return {
                ...i,
                'select': false,
            }
        });
    },

    getPickCate(state) {
        return state.pickCate;
    }

};