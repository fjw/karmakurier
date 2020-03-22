<template>
    <div class="login-wrapper">
        <div class="form-wrapper">
            <div class="title">
                <span>Toll,</span> dass du dabei sein möchtest!
            </div>
            <p>
                Fülle nachfolgendes Formular in Ruhe aus
                Sobald du dich registriert hast kann es schon losgehen!
            </p>
            <p>Du kannst auf zwei unterschiedlichen Wegen mit unseren Hilfesuchenden in Kontakt treten.</p>
            <p>
                <span>1.</span> Du nimmst aktiv via Anruf Anfragen von Hilfesuchenden entgegen, die sich in deiner Nähe befinden und unterstützt diese bei der Dateneingabe in unser System.
            </p>
            <p>oder</p>
            <p>
                <span>2.</span> Du kannst aktuelle Anfragen von Hilfesuchenden direkt aus unserer Datenbank bestätigen
            </p>
            <p>Anschließend füllen du dein Karmakonto durch gute Taten auf und kannst diese jederzeit bei unseren Karma-Partnern einlösen.</p>
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
                    <b-checkbox
                        v-model="dataPrivacy"
                    >Ich bin damit einverstanden, dass karmakurier die von mir im vorstehenden Formular angegebenen personenbezogenen Daten für den Zweck der Kontaktaufnahme verarbeitet. Eine Weitergabe an Dritte findet nicht statt, es sei denn es wird ausdrücklich darauf hingewiesen. Unsere Datenschutzerklärung mit sämtlichen Informationen gemäß Art 13 DSGVO zur Datenverarbeitung durch karmakurier und zu Ihren Rechten können Sie unter Datenschutzerklärung einsehen. Den Datenschutzbeauftragten von karmakurier erreichen Sie unter info@karmakurier.de.</b-checkbox>
                </b-field>
                <b-button
                    class="btn"
                    type="is-blue"
                    @click="signup()"
                    v-model="dataPrivacy"
                    :disabled="!dataPrivacy"
                >Jetzt registrieren</b-button>
            </div>
        </div>
        <p>
            Du hast bereits einen Account? Dann
            <a href="/einloggen">logge dich hier ein.</a>
        </p>
    </div>
</template>

<script>
export default {
    data() {
        return {
            dataPrivacy: false
        };
    },
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
    width: 100%;
    max-width: 320px;
    @media only screen and (min-width: 560px) {
        width: 100%;
        max-width: 512px;
    }
    .title {
        // background-color: $primary;
        padding: 16px 0;
    }
    .form {
        padding: 16px 0;
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
    span {
        color: $blue;
        font-weight: 700;
    }
    @media only screen and (min-width: 560px) {
        width: 100%;
        max-width: 512px;
        // padding: 16px 0;
    }
}
</style>