<template>
  <v-menu
    v-model="menu"
    :close-on-content-click="false"
    bottom
    left
    max-width="90%"
    min-width="275"
    offset-x
    offset-y
    origin="top right"
    transition="scale-transition"
  >
    <template v-slot:activator="{ attrs, on }">
      <v-card
        @click="updateCart()"
        id="settings"
        class="py-2 px-4"
        color="#0000004D"
        dark
        flat
        style="position: fixed; top: 164px; right: -35px;"
        width="100"
        v-bind="attrs"
        v-on="on"
      >
        Cart({{ productCount }})
      </v-card>
    </template>
    <v-card class="py-2"> </v-card>
    <!---------------------------------------------->
    <v-simple-table>
      <template v-slot:default>
        <thead>
          <tr>
            <th class="text-left">Id</th>
            <th class="text-left">ProductName</th>
            <th class="text-left">ProductPrice</th>
            <th class="text-left">productType</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in cartProducts" :key="item._id">
            <td>{{ item.id }}</td>
            <td>{{ item.name }}</td>
            <td>{{ item.price }},00$</td>
            <td>{{ item.type }}</td>
            <v-btn color="error" class="ml-2" @click="removeProduct(item.id)"
              >remove</v-btn
            >
          </tr>
          <tr class="black   white--text">
            <td>Product Count: {{ cart.numberOfProducts }}</td>
            <td>{{ cart.productsIds }}</td>
            <td>Total Price:{{ cart.total }}.00$</td>
            <td>Invoice ID:{{ cart.invoiceId }}</td>
          </tr>
        </tbody></template
      >
    </v-simple-table>
  </v-menu>
</template>

<script>
import cartService from "../../api/cartService.js";

export default {
  name: "HomeSettings",
  computed: {
    productCount() {
      return this.$store.state.productCount;
    }
  },
  data() {
    return {
      colors: [this.$vuetify.theme.themes.light.primary, "#9368e9", "#F4511E"],
      menu: false,
      total: 45,
      cart: null,
      cartItems: null,
      theId: 14,
      cartProducts: null
    };
  },
  methods: {
    updateProductCount(num) {
      this.$store.commit("SET_PRODUCT_COUNT", { productCount: num });
    },
    /* addProductToCart(prodId, cartId) {
      cartService.addProductToCart(prodId,cartId){

      }
      
    }, */
    async removeProduct(productId) {
      await cartService.removeProductFromCart(productId);
      console.log("Removeddddddd");
      this.updateCart();
    },
    updateCart() {
      cartService.getCart(this.theId).then(response => {
        console.log(response.data);
        this.cart = response.data;
        //this.productCount = this.cart.numberOfProducts;
        this.updateProductCount(this.cart.numberOfProducts);
        console.log("test1111111111111111111", this.cart.numberOfProducts);

        cartService.getAllProductsByCartId(this.theId).then(resp => {
          this.cartProducts = resp.data;
          this.updateProductCount(this.cart.numberOfProducts);
        });
      });
    }
  },
  mounted() {
    cartService.getCart(this.theId).then(response => {
      console.log(response.data);
      this.cart = response.data;
      this.updateProductCount(this.cart.numberOfProducts);
      console.log("test1111111111111111111");
    }); // this.products = this.products.filter(element => element.type === this.type);
  }
};
</script>
