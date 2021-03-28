<template>
  <base-section id="map" space="0">
    <iframe
      allowfullscreen
      aria-hidden="false"
      frameborder="0"
      height="500"
      src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d472.8788942304253!2d62.21128062414823!3d34.36778755599686!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x0!2zMzTCsDIyJzAzLjQiTiA2MsKwMTInNDEuNyJF!5e0!3m2!1sen!2s!4v1610726194029!5m2!1sen!2s"
      style="border:0; display: block;"
      tabindex="0"
      width="100%"
    />
  </base-section>
</template>

<script>
export default {
  name: "SectionMap",

  provide: {
    heading: { align: "center" }
  }
};
</script>
