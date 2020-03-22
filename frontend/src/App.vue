<template>
    <div id="app">
        <KkNavigation />
        <router-view />
        <KkFooter />
    </div>
</template>

<script>
import KkNavigation from "@/components/organisms/KkNavigation.vue";
import KkFooter from "@/components/organisms/KkFooter.vue";

export default {
    components: {
        KkNavigation,
        KkFooter
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
    margin: auto;
    width: 100%;
    max-width: 1200px;
    padding: 0.75rem 24px 0.75rem 24px;
    @media only screen and (min-width: 512px) {
        padding: 0.75rem 3rem 0.75rem 3rem;
    }
}
</style>
