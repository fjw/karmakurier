<template>
  <div class="login-wrapper">
    <div class="form-wrapper">
      <div class="title">
        <span>Toll,</span> dass du dabei sein möchtest!
      </div>
      <div class="form">
        <b-field class="firstname" label="Vorname">
          <b-input></b-input>
        </b-field>
        <b-field class="lastname" label="Nachname">
          <b-input></b-input>
        </b-field>
        <b-field class="street" label="Straße">
          <b-input></b-input>
        </b-field>
        <b-field class="zip" label="PLZ">
          <b-input></b-input>
        </b-field>
        <b-field class="city" label="Stadt">
          <b-input></b-input>
        </b-field>
        <b-field class="email" label="E-Mail">
          <b-input></b-input>
        </b-field>
        <b-field class="phone" label="Telefon">
          <b-input></b-input>
        </b-field>
        <b-field class="password" label="Passwort">
          <b-input type="password"></b-input>
        </b-field>
        <b-field class="confirm-password" label="Passwort wiederholen">
          <b-input type="password"></b-input>
        </b-field>

        <b-field class="mobility" label="Ich habe ein:">
          <div>
            <b-checkbox>Auto</b-checkbox>
            <b-checkbox>Fahrrad</b-checkbox>
          </div>
        </b-field>

        <b-field class="privacy" label="Datenschutz">
          <b-checkbox>Ja, ich habe die Datenschutzerklärung gelesen und stimme dieser zu.</b-checkbox>
        </b-field>
        <b-button class="btn" type="is-blue" @click="signup()">Jetzt registrieren</b-button>
      </div>
    </div>
    <p>
      Du hast bereits einen Account? Dann
      <a href="/l">logge dich hier ein.</a>
    </p>
  </div>
</template>

<script>
export default {
  methods: {
    signup() {
      this.$router.push("/einloggen");
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
    max-width: 512px;
  }
  .title {
    // background-color: $primary;
    padding: 16px;
  }
  .form {
    padding: 0 16px 16px 16px;
    @media only screen and (min-width: 560px) {
      display: grid;
      grid-column-gap: 8px;
      grid-template-areas:
        "firstname lastname"
        "street street"
        "zip city"
        "email phone"
        "password confirmPassword"
        "mobility mobility"
        "privacy privacy"
        "btn -";
      grid-template-columns: 50% 50%;

      .firstname {
        grid-area: firstname;
      }
      .lastname {
        grid-area: lastname;
      }
      .street {
        grid-area: street;
      }
      .zip {
        grid-area: zip;
      }
      .city {
        grid-area: city;
      }
      .email {
        grid-area: email;
      }
      .phone {
        grid-area: phone;
      }
      .password {
        grid-area: password;
      }
      .confirm-password {
        grid-area: confirmPassword;
      }
      .mobility {
        grid-area: mobility;
      }
      .privacy {
        grid-area: privacy;
      }
      .btn {
        grid-area: btn;
      }
    }
  }
}

p {
  width: 100%;
  max-width: 320px;
  margin-top: 12px;
  @media only screen and (min-width: 560px) {
    width: 100%;
    max-width: 512px;
    padding: 0 16px;
  }
}
</style>