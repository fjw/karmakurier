<template>
    <div class="dashboard-wrapper">
        <div class="normalize-width">
            <KkAuditList />
        </div>
    </div>
</template>

<script>
import KkAuditList from "@/components/organisms/KkAuditList";

export default {
    components: {
        KkAuditList
    }
};
</script>

<style lang="scss" scoped>
@import "@/components/Branding.scss";
</style>
