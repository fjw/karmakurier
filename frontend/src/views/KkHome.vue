<template>
    <div class="home-wrapper normalize-width">
        <div class="stage">
            <h1 class="title">
                füreinander. miteinander.
            </h1>
            <p
                class="subtitle"
            >Wir bringen Hilfesuchende und Helfende aus Ihrer Umgebung schnell, unmittelbar und einfach zusammen.</p>
        </div>
        <div class="cta-wrapper">
            <div class="cta">
                <img
                    src="@/assets/illustrations/karmakurier_illustration_01.png"
                    alt="brauche hilfe bild"
                />
                <div class="custom-button-wrap">
                    <div
                        class="custom-button orange"
                        @click="$router.push('/suche-hilfe')"
                    >Ich brauche Hilfe</div>
                    <div class="custom-button-text">
                        Wir verbinden Sie via Telefon oder online mit potentiellen Helfern aus Ihrer Nähe.
                        <div class="phone">
                            <i class="fas fa-phone-volume"></i>
                            <a>+48 732 10 00 73</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="middle">
                <img src="@/assets/illustrations/arrow.png" alt="pfeil bild" />
            </div>
            <div class="cta">
                <div class="custom-button-wrap">
                    <div
                        class="custom-button blue"
                        @click="$router.push('/moechte-helfen')"
                    >Ich möchte helfen</div>
                    <div
                        class="custom-button-text"
                    >Helfen Sie in Ihrer Nachbarschaft und verdienen Sie Anerkennung.</div>
                </div>
                <img
                    src="@/assets/illustrations/karmakurier_illustration_02.png"
                    alt="kann helfen bild"
                />
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "KkHome",
    components: {}
};
</script>

<style lang="scss" scoped>
@import "@/components/Branding.scss";

.home-wrapper {
    padding-top: 3rem;
    @media only screen and (min-width: 560px) {
        // display: flex;
        // justify-content: center;
        // align-items: center;
    }
}

.title {
    font-size: 2.4rem;
    font-weight: 700;
    @media only screen and (min-width: 560px) {
        font-size: 3rem;
    }
}

.subtitle {
    font-size: 16px;
    font-weight: 600;
    padding-top: 24px;
    @media only screen and (min-width: 560px) {
        padding-top: 32px;
    }
}

.stage {
    margin: auto;
    width: 100%;
    max-width: 600px;
    text-align: center;
}

.cta-wrapper {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    @media only screen and (min-width: 960px) {
        flex-direction: row;
    }
    .cta {
        display: flex;
        justify-content: center;
        align-items: center;
        img {
            max-height: none;
            max-width: 6rem;
            margin: 16px;
            @media only screen and (min-width: 960px) {
                max-height: 10rem;
                max-width: none;
            }
        }
        &:last-child {
            flex-direction: row-reverse;
            margin-top: 24px;
            @media only screen and (min-width: 512px) {
                margin-top: 0px;
            }
        }
        @media only screen and (min-width: 960px) {
            flex-direction: row;
            margin-top: 0px;
        }
    }
    .middle {
        display: none;
        width: 100%;
        max-width: 5rem;
        @media only screen and (min-width: 960px) {
            display: block;
        }
        img {
            width: 100%;
        }
    }
}

.custom-button.orange {
    max-width: 220px;
    margin-top: 25px;
    &::after {
        width: 130px;
        position: absolute;
        background-color: white;
        border-radius: 1rem;
        padding: 2px 6px 2px 6px;
        bottom: -14px;
        left: 50%;
        transform: translateX(-50%);
        font-size: 12px;
        box-shadow: 0 4px 8px rgba($primary, 0.24);
        border: 1px solid rgba($black, 0.16);
        color: $black;
    }
}

.custom-button {
    &-wrap {
        position: relative;
    }
    &-text {
        padding-top: 15px;
        max-width: 220px;
        .phone {
            font-weight: 700;
            i {
                color: $primary;
                margin-right: 8px;
            }
        }
    }
}
</style>
