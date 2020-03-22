<template>
    <div class="karma-wrapper">
        <img class="outter" src="@/assets/illustrations/badge/karmakurier_rewards_04.svg" alt />
        <img class="inner" src="@/assets/illustrations/badge/karmakurier_rewards_03.svg" alt />
        <div class="karma-number">{{karmaPoints}}</div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            karmaPoints: 0
        };
    },
    methods: {
        animateValue(end, duration) {
            const self = this;
            let range = end - this.karmaPoints;
            let current = this.karmaPoints;
            let increment = end > this.karmaPoints ? 1 : -1;
            let stepTime = Math.abs(Math.floor(duration / range));
            let timer = setInterval(function() {
                current += increment;
                self.karmaPoints = current;
                if (current == end) {
                    clearInterval(timer);
                }
            }, stepTime);
        }
    },
    mounted() {
        this.animateValue(64, 5000);
    }
};
</script>

<style lang="scss" scoped>
@import "@/components/Branding.scss";

.karma-wrapper {
    position: relative;
    width: 56px;
    height: 56px;

    .outter {
        position: absolute;
    }
    .inner {
        position: absolute;
    }
    .karma-number {
        top: 9px;
        left: 16px;
        height: 42%;
        width: 42%;
        border-radius: 100%;
        border: solid 1.5px $primary;
        position: absolute;
        font-size: 12px;
        font-weight: 600;
        text-align: center;
        line-height: 20px;
    }
}
</style>