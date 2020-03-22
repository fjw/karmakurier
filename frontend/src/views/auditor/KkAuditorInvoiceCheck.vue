<template>
    <div class="login-wrapper normalize-width">
        <div class="form-wrapper">
            <div class="title">
                <span>Einkauf #52</span> Belegüberprüfung
            </div>
            <div class="comparison-wrapper">
                <div class="box">
                    <ul>
                        <li>1x Butter</li>
                        <li>25x Toilettenpapier</li>
                        <li>38kg Weizenmehl</li>
                    </ul>
                    <div class="bottom-info orange">Maximalbetrag 10€</div>
                </div>
                <div class="box">
                    <img src="/dummy_beleg.jpg" alt />
                    <div class="bottom-info">Gezahlt 18.45€</div>
                </div>
            </div>
            <div class="btns">
                <b-button type="is-success">Passt! Zahlung starten</b-button>
                <br />
                <br />
                <b-button type="is-danger">Hier stimmt was nicht. Rückfrage stellen</b-button>
            </div>
        </div>
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
    // box-shadow: 0px 4px 8px rgba($primary, 0.24);
    width: 100%;
    @media only screen and (min-width: 560px) {
        width: 100%;
        max-width: 800px;
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

.comparison-wrapper {
    display: flex;
    justify-content: space-around;

    .box {
        overflow: hidden;
        position: relative;
        width: calc(50% - 16px);
        height: 420px;
        padding: 0 0 64px 0;
        ul {
            margin: 0;
            padding: 16px;
        }
        img {
            width: 100%;
            height: 100%;
            object-fit: contain;
        }
        .bottom-info {
            position: absolute;
            bottom: 0;
            width: 100%;
            height: 56px;
            background-color: $blue;
            color: white;
            font-weight: 700;
            font-size: 1.4rem;
            display: flex;
            justify-content: center;
            align-items: center;
            &.orange {
                background-color: $primary;
            }
        }
    }
}

.btns {
    text-align: center;
}
</style>
