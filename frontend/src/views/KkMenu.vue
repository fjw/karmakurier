<template>
  <div>
    <KkNavigation :inverted="true" />
    <h1>Menu</h1>
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