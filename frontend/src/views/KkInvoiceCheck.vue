<template>
    <div class="login-wrapper normalize-width">
        <div class="form-wrapper">
            <div class="title">
                <span>Einkauf #52</span> Belegüberprüfung
            </div>
            <div class="form">
                <b-field class="invoice" label="Beleg">
                    <b-input type="file"></b-input>
                </b-field>
                <b-field class="amount" label="€ Gesamtbetrag">
                    <b-input type="number"></b-input>
                </b-field>
                <b-button
                    class="btn"
                    type="is-blue"
                    @click="$router.push('/mein-profil')"
                >Jetzt Beleg prüfen lassen</b-button>
            </div>
        </div>
        <p>
            Dein Beleg ist zerstört oder nicht mehr vorhanden? Dann schreib uns eine E-Mail an
            <a>beleg@karmakurier.org</a>
        </p>
    </div>
</template>

<script>
export default {
    props: {},

    computed: {}
};
</script>

<style scoped lang="scss">
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
