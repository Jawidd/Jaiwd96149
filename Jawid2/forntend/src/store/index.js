import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    isAdmin: false,
    productCount: 0
  },
  mutations: {
    SET_ADMIN: (state, payload) => {
      state.isAdmin = payload.isAdmin;
    },
    SET_PRODUCT_COUNT: (state, payload) => {
      state.productCount = payload.productCount;
    }
  },
  actions: {},
  modules: {}
});
