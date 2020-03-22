<template>
    <div id="app">
        <div class="demo normalize-width">
            Achtung Prototyp. Beliebige Zugangsdaten können verwendet werden. Bitte liked und teilt
            <a
                href="https://www.youtube.com/watch?v=6Kr9JdEWCt8"
                target="_blank"
            >unser Video auf Youtube.</a>
        </div>
        <template v-if="$route.name !== 'HelperDashboard'">
            <KkPublicNavigation v-if="isLoggedIn === false" />
            <KkUserNavigation v-else-if="isLoggedIn === true" />
        </template>
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
    margin-top: 8px;
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

.demo {
    border: solid 3px $primary;
    border-radius: 8px;
    // padding: 8px;
    margin: auto;
    font-weight: 700;
}
</style>
