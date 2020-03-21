<template>
    <div id="app">
        <Navigation />
        <router-view />
    </div>
</template>

<script>
import Navigation from "@/components/organisms/Navigation.vue";

export default {
    components: {
        Navigation
    }
};
</script>

<style lang="scss">
body {
    margin: 0;
}

#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: black;
}
</style>
