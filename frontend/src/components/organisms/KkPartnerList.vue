<template>
  <div class="columns">
    <div class="column">
      <KkPartnerItem name="Tegut" logoUrl="/img/partners/tegut.png" />
    </div>
    <div class="column">
      <KkPartnerItem name="Rewe" logoUrl="/img/partners/rewe.png" />
    </div>
    <div class="column">
      <KkPartnerItem name="Karstadt" logoUrl="/img/partners/karstadt.jpeg" />
    </div>
  </div>
</template>

<script>
import KkPartnerItem from "../molecules/KkPartnerItem.vue";

export default {
  name: "KkPartnerList",
  components: {
    KkPartnerItem
  }
};
</script>