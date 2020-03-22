<template>
    <div class="login-wrapper">
        <div class="form-wrapper">
            <div class="title">
                <span>In 2 Minuten</span> zum neuen Passwort.
            </div>

            <b-notification
                v-if="showSuccess"
                type="is-success"
                aria-close-label="Close notification"
            >Bitte überprüfe deinen E-Mail Eingang. Wir haben dir eine E-Mail geschickt mit der du dein Passwort zurücksetzen kannst.</b-notification>

            <div class="form">
                <b-field label="E-Mail">
                    <b-input></b-input>
                </b-field>
                <b-button class="btn" type="is-blue" @click="showSuccess = true">Jetzt zurücksetzen</b-button>
            </div>
        </div>
        <p>
            Dir ist dein Passwort gerade wieder eingefallen? Dann
            <router-link to="/einloggen">klick hier.</router-link>
        </p>
    </div>
</template>

<script>
export default {
    data() {
        return {
            showSuccess: false
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
