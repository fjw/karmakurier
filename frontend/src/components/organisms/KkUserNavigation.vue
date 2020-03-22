<template>
    <nav class="navigation normalize-width">
        <div class="profile-pic" @click="$router.push('/mein-profil')">
            <img src="/dummy_profile.jpg" alt />
        </div>

        <div class="right">
            <div class="karma" @click="$router.push('/redeem')">
                <KarmaIcon />
            </div>

            <div class="hamburger-menu" @click="expandMenu = true">
                <i class="fas fa-bars"></i>
            </div>

            <div class="menu-items">
                <ul>
                    <li>
                        <router-link to="/mein-profil">mein profil</router-link>
                    </li>
                    <li>
                        <router-link to="/meine-auftraege">meine aufräge</router-link>
                    </li>
                    <li>
                        <router-link to="auftraege">aufträge finden</router-link>
                    </li>
                    <li @click="logOut()">
                        <router-link to="einloggen">ausloggen</router-link>
                    </li>
                </ul>
            </div>
        </div>

        <div class="open-menu" :class="{expand: expandMenu}">
            <div class="top normalize-width">
                <div class="logo" @click="$router.push('/mein-profil')">
                    <img src="@/assets/logo_inverted.svg" alt="Karmakurier Logo" />
                </div>

                <div class="hamburger-menu" @click="expandMenu = false">
                    <i class="fas fa-times"></i>
                </div>
            </div>
            <div class="items normalize-width">
                <ul>
                    <li @click="$router.push('/mein-profil'); expandMenu = false">Mein Profil</li>
                    <li @click="$router.push('/meine-auftraege'); expandMenu = false">Meine Aufträge</li>
                    <li @click="$router.push('/auftraege'); expandMenu = false">Aufträge finden</li>
                    <li @click="logOut(); expandMenu = false">Ausloggen</li>
                </ul>
            </div>
        </div>
    </nav>
</template>

<script>
import KarmaIcon from "@/components/atoms/KarmaIcon.vue";

export default {
    data() {
        return {
            expandMenu: false
        };
    },
    components: {
        KarmaIcon
    },
    props: {},
    methods: {
        logOut() {
            this.$store.dispatch("logOut");
            this.$router.push("/einloggen");
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

.karma {
    cursor: pointer;
    width: 4rem;
    @media only screen and (min-width: 910px) {
        width: 3rem;
    }
}

.hamburger-menu {
    display: flex;
    justify-content: center;
    align-items: center;
    cursor: pointer;
    border-radius: 100%;
    height: 40px;
    width: 40px;
    &:hover {
        background-color: rgba($primary, 0.16);
    }
    @media only screen and (min-width: 910px) {
        display: none;
    }
}

.fas {
    display: inline-block;
    font-size: 22px;
}

.profile-pic {
    img {
        width: 56px;
        height: 56px;
        border-radius: 100%;
        border: solid 2px $blue;
    }
}

.menu-items {
    display: none;
    @media only screen and (min-width: 910px) {
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
            a {
                color: $black;
                padding-left: 40px;
            }
            img {
                margin-left: 16px;
                width: 48px;
                height: 48px;
                border-radius: 100%;
            }
            &.helper-login {
                a {
                    color: $blue;
                }
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

.right {
    display: flex;
    justify-content: flex-end;
    align-items: center;
}

.open-menu {
    z-index: 99;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 0%;
    background-color: $primary;
    overflow: hidden;
    transition: all 0.16s ease;

    &.expand {
        height: 100%;
    }

    .top {
        display: flex;
        justify-content: space-between;
        align-items: center;
        i {
            color: $blue;
        }
    }

    .hamburger-menu {
        margin-top: 12px;
    }

    .items {
        ul {
            margin: 0;
            width: 100%;
            li {
                padding: 16px 0;
                text-align: center;
                font-weight: 700;
                font-size: 1.6rem;
                color: white;
                cursor: pointer;
                &:hover {
                    background-color: #ff9065;
                }
            }
        }
    }
}
</style>
