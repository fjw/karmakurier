<template>
    <div class="dashboard-wrapper">
        <!-- <div class="overview-wrapper">
            <div class="title">
                <span>245</span> Karma Punkte gesammelt.
            </div>
        </div>-->

        <div class="overview-wrapper">
            <div class="title">
                <span>{{assignments.length}}</span> Personen benötigen eine Einkaufsunterstüzung.
            </div>
        </div>

        <div class="plzfilterinput">
            <b-field label="PLZ">
                <b-input v-model="plzfilter"></b-input>
            </b-field>

            <p v-if="plzfilter === ''">Bitte geben Sie Ihre Postleitzahl an.</p>

            <p
                v-if="plzfilter !== '' && visibleassignments.length === 0"
            >Leider wurden keine Aufträge gefunden. Bitte suchen Sie auch nach Postleitzahlen im Umkreis.</p>
        </div>

        <kk-assignment
            class
            v-for="assignment in visibleassignments"
            :key="assignment.id"
            :id="assignment.id"
            :name="assignment.name"
            :date="assignment.date"
            :description="assignment.description"
            :town="assignment.town"
            :plz="assignment.plz"
        ></kk-assignment>

        <p v-show="loading">
            Aufträge werden über API-Call geholt...
        </p>
    </div>
</template>

<script>
import KkAssignment from "./KkAssignment";
import api from "../api";
import debounce from "lodash.debounce";

export default {
    components: { KkAssignment },
    data() {
        return {
            plzfilter: "81735",
            assignments: [
                {
                    id: 1,
                    plz: "81735",
                    town: "München",
                    time: Date.now(),
                    name: "Vanessa",
                    description:
                        "3 x Paracetamol\nBitte fragen Sie nach den günstigsten.\n\nWenn es noch Desinfiziermittel gibt würde ich 3 kleine Flaschen nehmen."
                },
                {
                    id: 2,
                    plz: "81735",
                    town: "München",
                    time: Date.now(),
                    name: "Harald",
                    description: "3 Äpfel\nEine Packung Oliven."
                },
                {
                    id: 3,
                    plz: "81735",
                    town: "München",
                    time: Date.now(),
                    name: "Hannelore",
                    description:
                        "Ich brauche nur diese einen Kornflakes. Die mit dem Affen auf der Verpackung. Bitte 4 Packungen."
                }
            ],

            // API client.
            client: null,

            // Loading state.
            loading: false
        };
    },

    computed: {
        visibleassignments() {
            return this.assignments.filter(
                assignment =>
                    assignment.plz.startsWith(this.plzfilter) &&
                    this.plzfilter !== ""
            );
        }
    },

    watch: {
        /**
         * Watch user input with debounce to not call API too often.
         */
        plzfilter: debounce(function () {
            this.fetchAssignmentsForZip()
        }, 750)
    },

    methods: {
        signup() {
            this.$router.push("/einloggen");
        },

        /**
         * Fetch assignments for currently entered ZIP code.
         */
        fetchAssignmentsForZip() {
            // Set loading state.
            this.loading = true;

            // Make API call.
            this.client.apis.default.get_orders__zipCode_({ zipCode: this.plzfilter })
                .then(response => {
                    // @todo Handle response
                    console.log(response);
                })
                .catch(error => {
                    // @todo Handle error?
                    console.error(error);
                })
                .finally(() => {
                    // Unset loading state.
                    this.loading = false;
                });
        }
    },

    async created() {
        // Fetch API client and store locally.
        this.client = await api;
    }
};
</script>

<style lang="scss" scoped>
@import "@/components/Branding.scss";

.dashboard-wrapper {
    // display: flex;
    // justify-content: center;
    // align-items: center;
    // flex-direction: column;
    padding: 40px 16px 64px 16px;
}

.overview-wrapper {
    border-radius: 4px;
    overflow: hidden;
    // box-shadow: 0px 4px 8px rgba($primary, 0.24);
    width: 100%;
    max-width: 320px;
    @media only screen and (min-width: 560px) {
        width: 100%;
        max-width: 512px;
    }
    .title {
        // background-color: $primary;
        span {
            font-weight: 700;
            color: $blue;
        }
        padding: 16px;
    }
}

.plzfilterinput {
    margin: 20px;

    .control {
        width: 90px;
    }
}
</style>
