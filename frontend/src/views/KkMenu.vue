<template>
  <div class="wrapper">
    <KkNavigation :inverted="true" />
    <main>
      <b-menu>
        <b-menu-list>
          <b-menu-item label="Home"></b-menu-item>
          <b-menu-item label="Dashboard"></b-menu-item>
        </b-menu-list>
      </b-menu>
    </main>
  </div>
</template>

<script>
import KkNavigation from "../components/organisms/KkNavigation.vue";

export default {
  name: "KkMenu",
  components: {
    KkNavigation
  }
};
</script>

<style lang="scss" scoped>
@import "../components/Branding.scss";

main {
  background-color: $primary;
  flex: 1 1 0;
  font-size: 200%;
}

.wrapper {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}
</style>