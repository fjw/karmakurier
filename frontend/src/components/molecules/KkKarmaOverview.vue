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
    background-color: white;
    border-radius: 100%;
    box-shadow: 0px 0px 8px 0px rgba(white, 0.75);
}

.title {
    color: white;
}
</style>