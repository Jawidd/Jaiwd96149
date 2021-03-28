<template>
  <base-info-card title="Features">
    <a
      v-for="feature in features"
      :key="feature"
      :text="feature"
      class="mb-8 grey--text body-1 d-block text-none"
      v-html="`&rsaquo; ${feature}`"
    />
  </base-info-card>
</template>

<script>
export default {
  name: "SectionFeaturesAlt",

  data: () => ({
    features: [
      "DETAILED DESCRIPTIONS",
      "Easy Customization",
      "User Friendly Interface",
      "24/7 Support",
      "Advanced Navigation"
    ]
  })
};
</script>
