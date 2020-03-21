<template>
    <div class="karma-wrapper">
        <div class="title">34 Karma Punkte</div>
        <div
            class="karma-point"
            v-for="i in 34"
            :key="i"
            :style="{left: randomNumber(i)+'%', top: randomNumber(i)+'%'}"
        ></div>
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
}

.title {
    z-index: 1;
    color: white;
    text-shadow: 0px 0px 8px rgba($black, 1);
}
</style>