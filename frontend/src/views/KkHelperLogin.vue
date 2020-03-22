<template>
  <div class="login-wrapper">
    <div class="form-wrapper">
      <div class="title">
        <span>Mega-schön</span> dich wiederzusehen!
      </div>
      <div class="form">
        <b-field class="phone" label="Telefon">
          <b-input type="number"></b-input>
        </b-field>
        <b-field class="password" label="Passwort">
          <b-input type="password"></b-input>
        </b-field>
        <b-button class="btn" type="is-blue" @click="login()">Jetzt anmelden</b-button>
      </div>
    </div>
    <p>
      Du hast dein Passwort vergessen? Dann
      <router-link to="forgot-password">klick hier.</router-link>
    </p>
  </div>
</template>

<script>
export default {
  methods: {
    login() {
      this.$store.commit("logIn");
      this.$router.go(-1); // go back
    }
  }
};
</script>

<style lang="scss" scoped>
@import "@/components/Branding.scss";

.login-wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  padding: 40px 16px 64px 16px;
}

.form-wrapper {
  border-radius: 4px;
  overflow: hidden;
  // box-shadow: 0px 4px 8px rgba($primary, 0.24);
  width: 100%;
  max-width: 320px;
  @media only screen and (min-width: 560px) {
    width: 100%;
    max-width: 420px;
  }
  .title {
    // background-color: $primary;
    span {
      font-weight: 700;
      color: $blue;
    }
    padding: 16px;
  }
  .form {
    padding: 0 16px 16px 16px;
  }
}

p {
  width: 100%;
  max-width: 320px;
  margin-top: 12px;
  padding: 0px 16px;
  @media only screen and (min-width: 560px) {
    width: 100%;
    max-width: 420px;
  }
}
</style>
