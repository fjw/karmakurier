<template>
    <div class="normalize-width">
        <div class="plzfilterinput">
            <div class="title" v-if="plzfilter !== ''">
                <span>{{assignments.length}}</span> Personen benötigen eine Einkaufsunterstüzung.
            </div>

            <div class="title" v-if="plzfilter === ''">
                Bitte geben Sie Ihre
                <span>Postleitzahl</span> an.
            </div>

            <b-field label="PLZ">
                <b-input v-model="plzfilter"></b-input>
            </b-field>

            <p
                v-if="plzfilter !== '' && visibleassignments.length === 0"
            >Leider wurden keine Aufträge gefunden. Bitte suchen Sie auch nach Postleitzahlen im Umkreis.</p>
        </div>

        <kk-assignment
            class
            v-for="assignment in visibleassignments"
            :key="assignment.id"
            :name="assignment.name"
            :date="assignment.date"
            :description="assignment.description"
            :town="assignment.town"
            :plz="assignment.plz"
        ></kk-assignment>
    </div>
</template>

<script>
import KkAssignment from "./KkAssignment";
export default {
    name: "KkAssignmentOverview",
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
            ]
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
    }
};
</script>

<style scoped lang="scss">
.plzfilterinput {
    margin: 20px 0;

    .control {
        width: 90px;
    }
}
</style>