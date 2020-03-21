<template>
    <div id="app" class="container">
        <KkNavigation />
        <router-view />
    </div>
</template>

<script>
import KkNavigation from "@/components/organisms/KkNavigation.vue";

export default {
    components: {
        KkNavigation
    }
};
</script>

<style lang="scss">
@import "@/components/Branding.scss";

body {
    margin: 0;
    font-size: 16px;
}

#app {
    min-height: 100%;
}

.normalize-width {
    padding: 0.75rem 24px 0.75rem 24px;
    @media only screen and (min-width: 512px) {
        padding: 0.75rem 3rem 0.75rem 3rem;
    }
}
</style>
