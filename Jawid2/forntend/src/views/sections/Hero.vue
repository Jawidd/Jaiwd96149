<template>
  <section id="hero">
    <!--  <v-parallax src="@/assets/material.jpg"></v-parallax> -->
    <!-- <v-img src="@/assets/abab.jpg"></v-img> -->

    <v-container class="pa-4 text-center">
      <v-row class="fill-height" align="center" justify="center">
        <template v-for="(item, i) in items">
          <v-col :key="i" cols="12" md="4">
            <v-hover v-slot="{ hover }">
              <v-card
                :to="`/category/${item.title}/productList`"
                :elevation="hover ? 12 : 2"
                :class="{ 'on-hover': hover }"
              >
                <v-img :src="item.img" height="225px">
                  <v-card-title class="title white--text">
                    <v-row
                      class="fill-height flex-column"
                      justify="space-between"
                    >
                      <p class="mt-5 ml-10 subheading text-left">
                        {{ item.title }}
                      </p>

                      <div class="align-self-center">
                        <v-icon
                          :class="{ 'show-btns': hover }"
                          color="transparent"
                        >
                          <!--   {{ icon }} -->
                        </v-icon>
                      </div>
                    </v-row>
                  </v-card-title>
                </v-img>
              </v-card>
            </v-hover>
          </v-col>
        </template>
      </v-row>
    </v-container>
  </section>
</template>

<script>
export default {
  data: () => ({
    src: "@/assets/headphones.jpg",
    items: [
      {
        title: "Mobilephone",

        img: `@/assets/phones.jpg`
      },
      {
        title: "Laptop",
        img: "@/assets/headphones.jpg"
      },
      {
        title: "Headphone",
        // img: "@/assets/laptop.png"
        img: "https://picsum.photos/200/300"
      }
    ],
    transparent: "rgba(255, 255, 255, 0)"
  }),

  //export default {
  name: "SectionHero",

  provide: {
    theme: { isDark: true }
  },

  computed: {
    minHeight() {
      const height = this.$vuetify.breakpoint.mdAndUp ? "100vh" : "50vh";

      return `calc(${height} - ${this.$vuetify.application.top}px)`;
    }
  }
};
</script>
<style scoped>
.v-card {
  transition: opacity 0.4s ease-in-out;
}

.v-card:not(.on-hover) {
  opacity: 0.6;
}

.show-btns {
  color: rgba(255, 255, 255, 1) !important;
}
</style>
