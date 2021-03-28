// Imports
import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

const router = new Router({
  mode: "history",
  base: process.env.BASE_URL,
  scrollBehavior: (to, from, savedPosition) => {
    if (to.hash) return { selector: to.hash };
    if (savedPosition) return savedPosition;

    return { x: 0, y: 0 };
  },
  routes: [
    {
      path: "/",
      component: () => import("@/layouts/home/Index.vue"),
      children: [
        {
          path: "category/:type/productList",
          name: "productList",
          component: () => import("@/views/category/productList.vue")
        },

        {
          path: "",
          name: "Home",
          component: () => import("@/views/home/Index.vue")
        },
        {
          path: "about",
          name: "About",
          component: () => import("@/views/about/Index.vue"),
          meta: { src: require("@/assets/about.jpg") }
        },
        {
          path: "contact-us",
          name: "Contact",
          component: () => import("@/views/contact-us/Index.vue"),
          meta: { src: require("@/assets/contact.jpg") }
        },
        {
          path: "login",
          name: "Login",
          component: () => import("@/views/Login/Index.vue"),
          meta: { src: require("@/assets/pro.jpg") }
        },
        {
          path: "*",
          name: "FourOhFour",
          component: () => import("@/views/404/Index.vue")
        },
        {
          path: "manageCategory",
          name: "Category",
          component: () => import("@/views/hidden/manageCategories.vue")
        },
        {
          path: "manageInvoice",
          name: "Invoice",
          component: () => import("@/views/hidden/manageInvoices.vue")
        },
        {
          path: "manageProduct",
          name: "Product",
          component: () => import("@/views/hidden/ManageProducts.vue")
        },
        {
          path: "manageUser",
          name: "User",
          component: () => import("@/views/hidden/manageUsers.vue")
        }
      ]
    }
  ]
});

export default router;
