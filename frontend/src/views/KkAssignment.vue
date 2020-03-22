<template>
    <section>
        <b-collapse
            class="card"
            animation="slide"
            aria-id="contentIdForA11y3"
            :open="false"
            :class="{blue: color === 'is-blue'}"
        >
            <div slot="trigger" class="card-header" role="button" aria-controls="contentIdForA11y3">
                <div class="card-header-title">
                    <div>{{assignment.person.firstName}} {{assignment.person.lastName}} aus {{assignment.person.zipCode}} {{assignment.person.city}}</div>
                    <div>{{assignment.timesince}}</div>
                </div>
            </div>
            <div class="card-content">
                <div class="content">{{assignment.shoppingList}}</div>
            </div>
            <footer class="card-footer">
                <router-link class="custom-button blue" :to="{ name: 'AssignmentDetails', params: { id: assignment.id } }">
                    Jetzt helfen!
                </router-link>
            </footer>
        </b-collapse>
    </section>
</template>

<script>

export default {
    name: "KkAssignment",

    props: {
        assignment: {
            type: Object,
            required: true
        },
        color: {
            type: String,
            default: null
        }
    }
};
</script>

<style scoped lang="scss">
@import "@/components/Branding.scss";

.card {
    // margin: $generalmargin;
    margin-bottom: 16px;

    .card-header-title {
        display: flex;
        justify-content: space-between;

        div:last-child {
            text-align: right;
            font-weight: normal;
        }
    }
}

.custom-button {
    margin-bottom: 20px;
}
</style>
