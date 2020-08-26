export default {

	initCategory(state, payload) {
		state.categoryList = payload;
		state.pickCate = payload[0]
	},

	initPickCate(state, payload) {
		state.pickCate = payload;
	},

};