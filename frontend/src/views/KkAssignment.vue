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
                    <div>{{name}} aus {{city}}</div>
                    <div>{{timesince}}</div>
                </div>
            </div>
            <div class="card-content">
                <div class="content">{{assignment.shoppingList}}</div>
            </div>
            <footer class="card-footer">
                <div
                    class="custom-button blue"
                    @click="$router.push('/auftragsdetails')"
                >Jetzt helfen!</div>
            </footer>
        </b-collapse>
    </section>
</template>

<script>
import { formatRelative } from "date-fns";
import { de } from "date-fns/locale";

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
    },

    computed: {
        name() {
            return `${this.assignment.person.firstName} ${this.assignment.person.lastName}`;
        },
        city() {
            return `${this.assignment.person.zipCode} ${this.assignment.person.city}`;
        },
        timesince() {
            return formatRelative(this.assignment.date, new Date(), { locale: de });
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
