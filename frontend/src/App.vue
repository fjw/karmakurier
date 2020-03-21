<template>
  <div id="app">
    <Navigation />
    <router-view />
  </div>
</template>

<script>
import Navigation from "@/components/organisms/Navigation.vue";

export default {
  components: {
    Navigation
  }
};
</script>

<style lang="scss">
@import "~bulma/sass/utilities/_all";

$primary: #8c67ef;
$primary-invert: findColorInvert($primary);

$colors: (
  "primary": (
    $primary,
    $primary-invert
  )
);

// Links
$link: $primary;
$link-invert: $primary-invert;
$link-focus-border: $primary;

// Import Bulma and Buefy styles
@import "~bulma";
@import "~buefy/src/scss/buefy";

body {
  margin: 0;
}

#app {
  padding: 1rem 5rem;
}
</style>
