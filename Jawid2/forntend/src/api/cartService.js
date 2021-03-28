import axios from "axios";
const axiosC = axios.create({
  baseURL: "http://localhost:3000"
});

export default {
  /*   addProductToCart(prodId, cartId) {
    return axiosC.post(`/cart/${prodId}/addCart1`, cartId);
  }, */

  removeProductFromCart(prodId) {
    return axiosC.request(`/cart/${prodId}/remove`);
  },

  //delete this
  addProductToCart(prodId) {
    return axiosC.put(`/cart/${prodId}/get`);
  },

  addProductToCartt(cartId, prodId) {
    return axiosC.request(`/cart/addProduct`, cartId, prodId);
  },

  addCart(cart) {
    return axiosC.post("/cart/add", cart);
  },
  getCart(id) {
    return axiosC.get(`/cart/${id}/getOne`);
  },

  getAllProductsByCartId(cartId) {
    return axiosC.get(`/cart/${cartId}/getAllProductsByCartId`);
  },

  getAllCarts() {
    return axiosC.get(`/cart/getAll`);
  },

  updateCart(cart) {
    return axiosC.post("/cart/update", cart);
  }

  /* getAllproducts(type) {
    return axiosC.get(`/product/${type}/getall`);
  }, */

  /*  deleteProduct(productId) {
    return axiosC.delete(`/product/${productId}/delete`);
  } */
};
