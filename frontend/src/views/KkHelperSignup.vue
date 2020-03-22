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

            <ValidationObserver v-slot="{ handleSubmit }">
                <div class="form">
                    <ValidationProvider
                        name="Vorname"
                        rules="required"
                        v-slot="{ errors, valid }"
                        class="firstname"
                    >
                        <b-field
                            label="Vorname"
                            :type="{ 'is-danger': errors[0], 'is-success': valid }"
                            :message="errors"
                        >
                            <b-input v-model="signUpData.firstName"></b-input>
                        </b-field>
                    </ValidationProvider>

                    <ValidationProvider
                        name="Nachname"
                        rules="required"
                        v-slot="{ errors, valid }"
                        class="lastname"
                    >
                        <b-field
                            label="Nachname"
                            :type="{ 'is-danger': errors[0], 'is-success': valid }"
                            :message="errors"
                        >
                            <b-input v-model="signUpData.lastName"></b-input>
                        </b-field>
                    </ValidationProvider>

                    <ValidationProvider
                        name="Straße und HausNr"
                        rules="required"
                        v-slot="{ errors, valid }"
                        class="street"
                    >
                        <b-field
                            label="Straße und HausNr"
                            :type="{ 'is-danger': errors[0], 'is-success': valid }"
                            :message="errors"
                        >
                            <b-input v-model="signUpData.street"></b-input>
                        </b-field>
                    </ValidationProvider>

                    <ValidationProvider
                        name="PLZ"
                        rules="required"
                        v-slot="{ errors, valid }"
                        class="zip"
                    >
                        <b-field
                            label="PLZ"
                            :type="{ 'is-danger': errors[0], 'is-success': valid }"
                            :message="errors"
                        >
                            <b-input v-model="signUpData.zip"></b-input>
                        </b-field>
                    </ValidationProvider>

                    <ValidationProvider
                        name="Stadt"
                        rules="required"
                        v-slot="{ errors, valid }"
                        class="city"
                    >
                        <b-field
                            label="Stadt"
                            :type="{ 'is-danger': errors[0], 'is-success': valid }"
                            :message="errors"
                        >
                            <b-input v-model="signUpData.city"></b-input>
                        </b-field>
                    </ValidationProvider>

                    <b-field label="E-Mail (optional)">
                        <b-input v-model="signUpData.email"></b-input>
                    </b-field>

                    <ValidationProvider
                        name="Telefon"
                        rules="required"
                        v-slot="{ errors, valid }"
                        class="phone"
                    >
                        <b-field
                            label="Telefon"
                            :type="{ 'is-danger': errors[0], 'is-success': valid }"
                            :message="errors"
                        >
                            <b-input v-model="signUpData.phone"></b-input>
                        </b-field>
                    </ValidationProvider>

                    <ValidationProvider
                        name="Passwort"
                        rules="required|min:8"
                        v-slot="{ errors, valid }"
                        class="password"
                    >
                        <b-field
                            label="Passwort"
                            :type="{ 'is-danger': errors[0], 'is-success': valid }"
                            :message="errors"
                        >
                            <b-input type="password" v-model="signUpData.password"></b-input>
                        </b-field>
                    </ValidationProvider>

                    <b-field
                        class="confirm-password"
                        label="Passwort wiederholen"
                        :message="signUpData.password != signUpData.confirmedPassword ? 'Passwörter stimmen nicht überein.':''"
                    >
                        <b-input type="password" v-model="signUpData.confirmedPassword"></b-input>
                    </b-field>

                    <b-field class="mobility" label="Ich habe ein:">
                        <div>
                            <b-checkbox v-model="signUpData.hasCar">Auto</b-checkbox>
                            <b-checkbox v-model="signUpData.hasBicycle">Fahrrad</b-checkbox>
                        </div>
                    </b-field>

                    <ValidationProvider
                        name="Datenschutz"
                        rules="required"
                        v-slot="{ errors, valid }"
                        class="privacy"
                    >
                        <b-field
                            label="Datenschutz"
                            :type="{ 'is-danger': errors[0], 'is-success': valid }"
                            :message="errors"
                        >
                            <b-checkbox
                                v-model="dataPrivacy"
                            >Ich bin damit einverstanden, dass karmakurier die von mir im vorstehenden Formular angegebenen personenbezogenen Daten für den Zweck der Kontaktaufnahme verarbeitet. Eine Weitergabe an Dritte findet nicht statt, es sei denn es wird ausdrücklich darauf hingewiesen. Unsere Datenschutzerklärung mit sämtlichen Informationen gemäß Art 13 DSGVO zur Datenverarbeitung durch karmakurier und zu Ihren Rechten können Sie unter Datenschutzerklärung einsehen. Den Datenschutzbeauftragten von karmakurier erreichen Sie unter info@karmakurier.de.</b-checkbox>
                        </b-field>
                    </ValidationProvider>

                    <b-button
                        class="btn"
                        type="is-blue"
                        @click="handleSubmit(signup)"
                        v-model="dataPrivacy"
                        :disabled="!dataPrivacy"
                    >Jetzt registrieren</b-button>
                </div>
            </ValidationObserver>
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
            dataPrivacy: false,
            signUpData: {
                firstName: "",
                lastName: "",
                street: "",
                zip: "",
                city: "",
                email: "",
                phone: "",
                hasCar: "",
                hasBicycle: "",
                password: "",
                confirmedPassword: ""
            }
        };
    },
    methods: {
        signup() {
            this.$store.dispatch("signUp", this.signUpData);
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