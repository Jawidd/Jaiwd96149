<template>
  <div>
    <v-app-bar id="home-app-bar" app color="white" elevation="1" height="80">
      <base-img
        :src="require('@/assets/logo.svg')"
        class="mr-3 "
        contain
        max-width="64"
        width="100%"
      />

      <base-img
        :src="require('@/assets/BestBuyN2.png')"
        contain
        max-width="238"
        width="100%"
      />

      <v-spacer />

      <div>
        <v-tabs class="hidden-sm-and-down" optional>
          <v-tab
            v-for="(name, i) in items"
            :key="i"
            :to="{ name }"
            :exact="name === 'Home'"
            :ripple="false"
            active-class="text--primary"
            class="font-weight-bold"
            min-width="96"
            text
          >
            {{ name }}
          </v-tab>
        </v-tabs>
      </div>
      <!--  -------------------- -->
      <div>
        <v-tabs v-if="isAdmin" class="hidden-sm-and-down" optional>
          <v-tab
            v-for="(name, i) in hiddenItems"
            :key="i"
            :to="{ name }"
            :exact="name === 'Home'"
            :ripple="false"
            active-class="text--primary"
            class="font-weight-bold"
            min-width="96"
            text
          >
            ##{{ name }}
          </v-tab>
        </v-tabs>
      </div>

      <v-app-bar-nav-icon class="hidden-md-and-up" @click="drawer = !drawer" />
    </v-app-bar>

    <home-drawer v-model="drawer" :items="items" />
  </div>
</template>

<script>
export default {
  name: "HomeAppBar",
  computed: {
    isAdmin() {
      return this.$store.state.isAdmin;
    }
  },
  components: {
    HomeDrawer: () => import("./Drawer")
  },

  data: () => ({
    drawer: null,
    items: ["Home", "About", "Contact", "Login"],
    hiddenItems: ["Category", "Invoice", "Product", "User"]
  })
};
</script>

<style lang="sass">
#home-app-bar
  .v-tabs-slider
    max-width: 24px
    margin: 0 auto

  .v-tab
    &::before
      display: none
</style>
