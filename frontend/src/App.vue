<template>
    <div id="app">
        <KkPublicNavigation v-if="isLoggedIn === false" />
        <KkUserNavigation v-else-if="isLoggedIn === true" />
        <router-view />
        <KkFooter />
    </div>
</template>

<script>
import KkPublicNavigation from "@/components/organisms/KkPublicNavigation.vue";
import KkUserNavigation from "@/components/organisms/KkUserNavigation.vue";
import KkFooter from "@/components/organisms/KkFooter.vue";

export default {
    components: {
        KkPublicNavigation,
        KkUserNavigation,
        KkFooter
    },
    computed: {
        isLoggedIn() {
            return this.$store.state.isLoggedIn;
        }
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
