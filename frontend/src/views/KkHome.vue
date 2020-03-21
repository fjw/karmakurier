<template>
    <div class="home-wrapper normalize-width">
        <div class="stage">
            <h1 class="title">willkommen bei karmakurier.</h1>
            <p
                class="subtitle"
            >Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.</p>
        </div>
        <div class="cta-wrapper">
            <div class="cta">
                <img src="@/assets/illustrations/orange_persons.png" alt="brauche hilfe bild" />
                <div class="custom-button orange">Ich brauche hilfe</div>
            </div>
            <div class="middle">
                <img src="@/assets/illustrations/arrow.png" alt="pfeil bild" />
            </div>
            <div class="cta">
                <div class="custom-button blue">Ich möchte helfen</div>
                <img src="@/assets/illustrations/blue_persons.png" alt="kann helfen bild" />
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
    max-width: 512px;
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
        }
        @media only screen and (min-width: 960px) {
            flex-direction: row;
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

.custom-button {
    min-width: 200px;
    border: 3px solid $primary;
    border-radius: 8px;
    padding: 6px 12px 6px 12px;
    font-weight: 700;
    font-size: 1.2rem;
    cursor: pointer;
    text-align: center;
    transition: all 0.16s ease;
    &.orange {
        position: relative;
        border: 3px solid $primary;
        &::after {
            position: absolute;
            content: "0800 123 456";
            background-color: white;
            border-radius: 1rem;
            padding: 2px 6px 2px 6px;
            bottom: -14px;
            left: 50%;
            transform: translateX(-50%);
            font-size: 12px;
            box-shadow: 0px 4px 8px rgba($primary, 0.24);
            border: 1px solid rgba($black, 0.16);
            color: $black;
        }
        &:hover {
            color: white;
            background-color: $primary;
        }
    }
    &.blue {
        border: 3px solid $blue;
        &:hover {
            color: white;
            background-color: $blue;
        }
    }
}
</style>