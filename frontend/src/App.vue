<template>
  <div id="app" class="container">
    <Navigation />
    <router-view />
  </div>
</template>

<script>
import Navigation from "@/components/organisms/KkNavigation.vue";

export default {
  components: {
    Navigation
  }
};
</script>

<style lang="scss">
@import "@/components/Branding.scss";

body {
  margin: 0;
}

#app {
  // padding: 1rem 5rem;
}
</style>
