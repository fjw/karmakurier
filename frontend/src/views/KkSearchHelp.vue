<template>
  <div class="login-wrapper">
    <div class="form-wrapper">
      <div class="title">
        Sie sind in
        <span>guten Händen.</span>
      </div>
        <p>Füllen Sie nachfolgendes Formular in Ruhe aus - Wir finden so schnell wie möglich den passenden Alltagshelfer für Sie.</p>
        <p></p>
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

        <b-field class="shopping-list" label="Was brauchen Sie?">
          <b-input type="textarea" v-model="models.textarea" />
        </b-field>

        <b-field class="preffered" label="Ich kaufe eher">
          <div>
            <b-radio v-model="models.prefered" native-value="premium">Premium</b-radio>
            <b-radio
              class="radio-group-radio"
              v-model="models.prefered"
              native-value="günstig"
            >Günstig</b-radio>
          </div>
        </b-field>
        <b-field label="Maximaler Einkaufswert">
          <b-input type="number" v-model="models.price" />
        </b-field>



        <b-field label="Zahlung">
            <div>
                <b-radio v-model="models.prefered" native-value="cash">Bargeld</b-radio>
                <b-radio v-model="models.prefered" class="radio-group-radio"
                        native-value="PayPal"
                >PayPal</b-radio>
            </div>
        </b-field>

        <b-field class="privacy" label="Datenschutz">
          <b-checkbox
            v-model="models.agbCheckbox"
          >Ich bin damit einverstanden, dass karmakurier die von mir im vorstehenden Formular angegebenen personenbezogenen Daten für den Zweck der Kontaktaufnahme verarbeitet. Eine Weitergabe an Dritte findet nicht statt, es sei denn es wird ausdrücklich darauf hingewiesen. Unsere Datenschutzerklärung mit sämtlichen Informationen gemäß Art 13 DSGVO zur Datenverarbeitung durch karmakurier und zu Ihren Rechten können Sie unter Datenschutzerklärung einsehen. Den Datenschutzbeauftragten von karmakurier erreichen Sie unter info@karmakurier.de</b-checkbox>
        </b-field>
        <b-button
          class="btn"
          type="is-blue"
          :disabled="!models.agbCheckbox"
          @click="$router.push('/danke')"
        >Jetzt Einkaufshelfer benachrichtigen</b-button>
      </div>
    </div>
    <p>
      Sie können auch
      <a>+48 732 10 00 73 anrufen</a> und die Bestellung über das Telefon aufgeben.
    </p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      models: {
        firstName: "",
        lastName: "",
        street: "",
        plz: null,
        city: "",
        phoneNumber: null,
        prefered: "billig",
        textarea: "",
        price: null,
        paymentMethod: "paypal",
        agbCheckbox: false
      }
    };
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
    span {
      font-weight: 700;
      color: $primary;
    }
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
        "shoppingList shoppingList"
        "preffered maxPayment"
        "paymentMethod -"
        "privacy privacy"
        "btn btn";
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
      .shopping-list {
        grid-area: shoppingList;
      }
      .max-payment {
        grid-area: maxPayment;
      }
      .payment-method {
        grid-area: paymentMethod;
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