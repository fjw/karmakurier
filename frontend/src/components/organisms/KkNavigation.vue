<template>
  <nav class="navigation" :class="{inverted: inverted }">
    <router-link to="/menu" class="menu">
      <i class="fas fa-bars"></i>
    </router-link>

    <div class="logo">
      <router-link to="/">
        <img v-if="!inverted" src="@/assets/logo.svg" alt="Karmakurier Logo" />
        <img v-if="inverted" src="@/assets/logo_inverted.svg" alt="Karmakurier Logo" />
      </router-link>
    </div>

    <div class="search">
      <router-link to="/search">
        <i class="fas fa-search"></i>
      </router-link>
    </div>
  </nav>
</template>

<script>
export default {
  name: "KkNavigation",
  props: {
    inverted: {
      type: Boolean,
      default: false
    }
  }
};
</script>

<style lang="scss" scoped>
@import "../Branding.scss";

.navigation {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 0.75rem;
}

.menu,
.search {
  font-size: 22px;
}

.logo img {
  width: 10rem;
}

.inverted {
  background-color: $primary;
  color: $secondary;
  a {
    color: $secondary;
  }
}
</style>