<template>
  <nav class="navigation">
    <a class="menu">
      <i class="fas fa-bars"></i>
    </a>

    <div class="logo">
      <router-link to="/">
        <img src="@/assets/logo.svg" alt="Karmakurier Logo" />
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
  name: "KkNavigation"
};
</script>

<style lang="scss" scoped>
.navigation {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 0.5rem;
}

.menu,
.search {
  font-size: 22px;
}

.logo img {
  width: 10rem;
}
</style>