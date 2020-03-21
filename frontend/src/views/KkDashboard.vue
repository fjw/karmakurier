<template>
    <div class="dashboard-wrapper">
        <KkKarmaOverview />
        <div class="normalize-width">
            <KkTaskList />
        </div>
    </div>
</template>

<script>
import KkKarmaOverview from "@/components/molecules/KkKarmaOverview";
import KkTaskList from "@/components/organisms/KkTaskList";

export default {
    components: {
        KkTaskList,
        KkKarmaOverview
    }
};
</script>

<style lang="scss" scoped>
@import "@/components/Branding.scss";
</style>
