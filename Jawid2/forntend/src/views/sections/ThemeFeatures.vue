<template>
  <base-section id="bestbuys-features">
    <base-section-heading title="BestBuys Features">
      Experience the most simple way of shopping!
    </base-section-heading>

    <v-container>
      <v-row>
        <v-col v-for="(feature, i) in features" :key="i" cols="12" md="6">
          <base-avatar-card v-bind="feature" align="left" horizontal>
            <p :text="feature.text"></p>
          </base-avatar-card>
        </v-col>
      </v-row>
    </v-container>
  </base-section>
</template>

<script>
export default {
  name: "SectionThemeFeatures",

  data: () => ({
    features: [
      {
        title: "Detailed product descriptions",
        icon: "mdi-fountain-pen-tip",
        text: "Every product has clear and extensive description!"
      },
      {
        title: "A mobile website option",
        icon: "mdi-cellphone",
        text:
          "Online shoppers are offered convenience and instant ease-of-access to our online store, no matter what device they’re using"
      },
      {
        color: "primary",
        dark: true,
        title: "Customer reviews of the product",
        icon: "mdi-pencil-box-outline",
        text:
          "You can read about the experiences of other people who have used the product."
      },
      {
        title: "Superior photos of product",
        icon: "mdi-image-size-select-actual",
        text: "A picture is worth a thousand words."
      },
      {
        title: "Advanced navigation and search functions",
        icon: "mdi-ice-pop",
        text: `The ‘search function’ is a cater for our customers,
           You dont have to know the actual names of the products you want to get.
            Search functionality gives you suggestions on the possible things you are looking for.`
      },
      {
        title: "24/7 Support",
        icon: "mdi-help-circle-outline",
        text: ""
      }
    ]
  })
};
</script>
