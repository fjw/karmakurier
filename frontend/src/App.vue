<template>
    <div id="app">
        <template v-if="$route.name !== 'HelperDashboard'">
            <KkPublicNavigation v-if="isLoggedIn === false" />
            <KkUserNavigation v-else-if="isLoggedIn === true" />
        </template>
        <router-view />
        <KkFooter />
        <div class="demo-wrapper">
            <div class="normalize-width">
                <div class="demo">
                    <img src="@/assets/karmakurier_achtung.svg" alt="achtung icon" />
                    <div class="text">
                        Achtung Prototyp. Beliebige Zugangsdaten können verwendet werden. Bitte liked und teilt
                        <a
                            href="https://www.youtube.com/watch?v=6Kr9JdEWCt8"
                            target="_blank"
                        >unser Video auf Youtube.</a>
                    </div>
                </div>
            </div>
        </div>
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
    margin-bottom: 60px;
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

.demo-wrapper {

    position: fixed;
    bottom: 0;
    width: 100%;

    .demo {
        border: solid 3px gold;
        border-radius: 8px;
        padding: 8px 12px 8px 12px;
        margin: 8px 0;
        font-weight: 700;
        text-align: left;
        display: inline-flex;
        justify-content: space-between;
        align-items: center;
        background: white;
        text-align: center;

        .text {
            display: inline;
        }

        a {
            margin-left: 4px;

            &:hover {
                text-decoration: underline;
                color: $primary;
            }
        }

        img {
            display: inline-block;
            height: 32px;
            width: 32px;
            margin-right: 16px;
        }

        @media only screen and (min-width: 512px) {
            display: block;
            img {
                margin-bottom: -6px;
            }
        }
        @media only screen and (min-width: 1100px) {
            img {
                margin-bottom: -10px;
                margin-right: 8px;
            }
        }

    }
}
</style>
