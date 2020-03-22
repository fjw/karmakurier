<template>
  <div class="normalize-width">
    <h1 class="title">Karmapunkte einlösen</h1>
    <p class="subtitle">Bei folgenden Partnern können Sie Ihre Karmapunkte einlösen:</p>
    <section>
      <KkPartnerList />
    </section>
  </div>
</template>

<script>
import KkPartnerList from "../components/organisms/KkPartnerList.vue";

export default {
  name: "KkKarmaRedeem",
  components: {
    KkPartnerList
  }
};
</script>