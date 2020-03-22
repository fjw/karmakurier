<template>
    <div class="karma-wrapper">
        <div class="profile-wrapper">
            <img src="/dummy_profile.jpg" alt />
            <div class="name">Sebastian Klein</div>
        </div>
        <div class="title">34 Karma Punkte</div>
        <div
            class="karma-point"
            v-for="i in 34"
            :key="i"
            :style="{left: randomNumber(i)+'%', top: randomNumber(i)+'%'}"
        >
            <b-tooltip label="Vanessa beim Einkauf geholfen">
                <div class="filler"></div>
            </b-tooltip>
        </div>
    </div>
</template>

<script>
export default {
    methods: {
        randomNumber(index) {
            let randomNumbers = [];
            for (let i = 0; i < 34; i += 1) {
                randomNumbers.push(Math.round(Math.random() * 100));
            }
            return randomNumbers[index];
        }
    }
};
</script>

<style lang="scss" scoped>
@import "@/components/Branding.scss";

.karma-wrapper {
    position: relative;
    background-color: $blue;
    width: 100%;
    height: 240px;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
}

.karma-point {
    position: absolute;
    height: 10px;
    width: 10px;
    background-color: rgba(white, 0.4);
    border-radius: 100%;
    box-shadow: 0px 0px 8px 0px rgba(#c3c3ff, 0.75);

    &::after {
        content: "";
        position: absolute;
        width: 4px;
        height: 4px;
        border-radius: 100%;
        background-color: rgba(white, 0.8);
        box-shadow: 0px 0px 8px 0px rgba(#c3c3ff, 0.75);
        top: 3px;
        left: 3px;
    }
    .filler {
        transform: translate(0px, -8px);
        width: 10px;
        height: 10px;
    }
}

.title {
    z-index: 1;
    color: white;
    text-shadow: 0px 0px 8px rgba($black, 1);
}

.profile-wrapper {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    z-index: 1;
    .name {
        color: $black;
        border-radius: 1rem;
        background-color: white;
        padding: 0px 8px 0px 8px;
        margin-top: 8px;
    }
    // text-shadow: 0px 0px 8px rgba($black, 1);
    img {
        border: solid 3px white;
        width: 56px;
        height: 56px;
        border-radius: 100%;
        object-fit: cover;
    }
}
</style>