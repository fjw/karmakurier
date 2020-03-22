<template>
    <div class="legal-wrapper">
        <div class="title">Allgemeine Geschäftsbedingungen</div>
        <p>todo</p>
    </div>
</template>

<script>
export default {
    methods: {}
};
</script>

<style lang="scss" scoped>
@import "@/components/Branding.scss";

.legal-wrapper {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    padding: 40px 16px 64px 16px;
}

.title {
    // background-color: $primary;
    span {
        font-weight: 700;
        color: $blue;
    }
    padding: 16px;
}

p {
}
</style>
