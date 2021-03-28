<template>
  <!--  <v-theme-provider dark> -->
  <section id="account">
    <v-checkbox
      v-model="admin"
      :label="`Is Admin? ${admin.toString()}`"
      @click="toggleAdmin()"
    ></v-checkbox>

    <h2>is Admin?{{ admin }}</h2>
  </section>
  <!--   </v-theme-provider> -->
</template>
<script>
export default {
  name: "account",
  computed: {
    admin() {
      return this.$store.state.isAdmin;
    }
  },
  methods: {
    toggleAdmin() {
      this.$store.commit("SET_ADMIN", { isAdmin: true });
    }
  },
  data() {
    return {
      checkbox: true
    };
  }
};
</script>
