<template>
  <div id="app" class="container">
    <router-view />
  </div>
</template>

<script>
export default {};
</script>

<style lang="scss">
@import "@/components/Branding.scss";

body {
  margin: 0;
  font-size: 16px;
}

#app {
  min-height: 100%;
}
</style>
