<template>
    <div class="legal-wrapper normalize-width">
        <div class="title">Datehnschutz</div>
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
    align-items: left;
    flex-direction: column;
}

.title {
    // background-color: $primary;
    span {
        font-weight: 700;
        color: $blue;
    }
    padding: 16px 0;
}

h2 {
    color: $blue;
    font-weight: 700;
    font-size: 1.2rem;
    margin-top: 16px;
}

h3 {
    font-weight: 600;
    font-size: 1rem;
    margin-top: 16px;
}
</style>
