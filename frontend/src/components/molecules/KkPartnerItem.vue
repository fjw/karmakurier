<template>
  <div class="card">
    <div class="card-image">
      <img :src="logoUrl" alt="logo" />
    </div>
    <div class="card-footer">
      <a href="#" class="card-footer-item">Bei {{name}} einlösen</a>
    </div>
  </div>
</template>

<script>
export default {
  name: "KkPartnerItem",
  props: {
    name: String,
    logoUrl: String
  }
};
</script>