<template>
  <nav class="navigation normalize-width">
    <div class="logo" @click="isLoggedIn ? $router.push('/dashboard') : $router.push('/')">
      <!-- <img src="@/assets/logo.svg" alt="Karmakurier Logo" /> -->
      <video autoplay muted>
        <source src="@/assets/logo_animated_cropped.mp4" type="video/mp4" />
      </video>
    </div>
    <i class="fas fa-bars"></i>

    <div class="menu-items" v-if="isLoggedIn">
      <ul>
        <li>
          <router-link to="/dashboard">Hey, Sebastian</router-link>
        </li>
        <li @click="$router.push('/dashboard')">
          <img src="/dummy_profile.jpg" alt />
        </li>
      </ul>
    </div>

    <div class="menu-items" v-else>
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
        <li class="helper-login">
          <router-link to="einloggen">helfer login</router-link>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
import { mapState } from "vuex";

export default {
  props: {},
  computed: mapState(["isLoggedIn"])
};
</script>

<style lang="scss" scoped>
@import "../Branding.scss";

.navigation {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.logo {
  cursor: pointer;
}

.logo img {
  width: 7rem;
}

.logo video {
  width: 8rem;
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
</style>
