<template>
    <div class="login-wrapper">
        <div class="form-wrapper">
            <div class="title">Du bist klasse!</div>
            <div class="form">
                <b-field label="Vorname">
                    <b-input></b-input>
                </b-field>
                <b-field label="Nachname">
                    <b-input></b-input>
                </b-field>
                <b-field label="Straße">
                    <b-input></b-input>
                </b-field>
                <b-field label="PLZ">
                    <b-input></b-input>
                </b-field>
                <b-field label="Stadt">
                    <b-input></b-input>
                </b-field>
                <b-field label="E-Mail">
                    <b-input></b-input>
                </b-field>
                <b-field label="Passwort">
                    <b-input type="password"></b-input>
                </b-field>

                <b-field label="Ich habe ein:">
                    <div>
                        <b-checkbox>Auto</b-checkbox>
                        <b-checkbox>Fahrrad</b-checkbox>
                    </div>
                </b-field>

                <b-field label="Datenschutz">
                    <b-checkbox>Ja, ich habe die Datenschutzerklärung gelesen und stimme dieser zu.</b-checkbox>
                </b-field>
                <b-button type="is-primary">Jetzt registrieren</b-button>
            </div>
        </div>
        <p>
            Du hast bereits einen Account? Dann
            <a href="/login">logge dich hier ein.</a>
        </p>
    </div>
</template>

<script>
export default {};
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
    box-shadow: 0px 4px 8px rgba($primary, 0.24);
    width: 100%;
    max-width: 320px;
    .title {
        background-color: $primary;
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
}
</style>