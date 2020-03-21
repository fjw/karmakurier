<template>
  <div class="navigation-wrapper">
    <img src="@/assets/logo.png" alt="Logo Bild" />
  </div>
</template>

<script>
export default {
  name: "KkNavigation"
};
</script>

<style lang="scss" scoped>
.navigation-wrapper {
  padding: 12px 0 12px 0;
  height: 24px;
  width: 100%;
  display: flex;
  justify-content: center;
  align-content: center;
  box-shadow: 0px 4px 4px rgba(black, 0.02);
  border-bottom: solid 1px rgba(black, 0.08);
  img {
    height: 100%;
    width: auto;
  }
}
</style>