<template>
    <div class="navigation-wrapper">
        <img src="@/assets/logo.png" alt="Logo Bild" />
    </div>
</template>

<script>
export default {};
</script>

<style lang="scss" scoped>
@import "@/Components/Branding.scss";

.navigation-wrapper {
    padding: 12px 0 12px 0;
    height: 48px;
    width: 100%;
    display: flex;
    justify-content: center;
    align-content: center;
    box-shadow: 0px 4px 4px rgba(black, 0.04);
    background-color: $primary;
    img {
        height: 100%;
        width: auto;
    }
}
</style>