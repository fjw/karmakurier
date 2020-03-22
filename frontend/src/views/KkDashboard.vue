<template>
  <div class="dashboard-wrapper">
    <KkKarmaOverview />

    <div class="normalize-width"></div>
  </div>
</template>

<script>
import KkKarmaOverview from "@/components/molecules/KkKarmaOverview";

export default {
  components: {
    KkKarmaOverview
  }
};
</script>

<style lang="scss" scoped>
@import "@/components/Branding.scss";
</style>
