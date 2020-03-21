<template>
    <div class="dashboard-wrapper normalize-width">
        <!-- <div class="overview-wrapper">
            <div class="title">
                <span>245</span> Karma Punkte gesammelt.
            </div>
        </div>-->
        <KkTaskList />
    </div>
</template>

<script>
import KkTaskList from "@/components/organisms/KkTaskList";

export default {
    components: {
        KkTaskList
    }
};
</script>

<style lang="scss" scoped>
@import "@/components/Branding.scss";
</style>
