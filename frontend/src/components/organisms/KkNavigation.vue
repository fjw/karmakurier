<template>
    <nav class="navigation normalize-width">
        <div class="logo" @click="$router.push('/')">
            <img src="@/assets/logo.svg" alt="Karmakurier Logo" />
        </div>
        <i class="fas fa-bars"></i>
        <div class="menu-items">
            <ul>
                <li>
                    <router-link to="/suche-hilfe">suche</router-link>
                </li>
                <li>
                    <router-link to="/moechte-helfen">biete</router-link>
                </li>
                <li>
                    <router-link to="faq">faq</router-link>
                </li>
                <li>
                    <router-link to="kontakt">kontakt</router-link>
                </li>
            </ul>
        </div>
    </nav>
</template>

<script>
export default {
    name: "KkNavigation",
    props: {
        inverted: {
            type: Boolean,
            default: false
        }
    }
};
</script>

<style lang="scss" scoped>
@import "../Branding.scss";

.navigation {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.logo img {
    width: 7rem;
}

.fas {
    display: inline-block;
    font-size: 22px;
    @media only screen and (min-width: 560px) {
        display: none;
    }
}

.menu-items {
    display: none;
    @media only screen and (min-width: 560px) {
        display: block;
    }
    ul {
        display: flex;
        justify-content: flex-end;
        align-items: center;
        list-style: none;
        margin: 0;
        padding: 0;
        li {
            font-weight: 700;
            padding-left: 40px;
            a {
                color: $black;
            }
            &:hover {
                cursor: pointer;
                a {
                    color: $primary;
                }
            }
        }
    }
}
</style>
