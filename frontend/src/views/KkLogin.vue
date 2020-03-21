<template>
    <div class="login-wrapper">
        <div class="form-wrapper">
            <div class="title">Moin, moin</div>
            <div class="form">
                <b-field label="E-Mail">
                    <b-input></b-input>
                </b-field>
                <b-field label="Passwort">
                    <b-input type="password"></b-input>
                </b-field>
                <b-button type="is-primary">Einloggen</b-button>
            </div>
        </div>
        <p>
            Noch kein Account? Dann
            <a href="/signup">registriere dich jetzt hier.</a>
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
    padding: 64px 16px 64px 16px;
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