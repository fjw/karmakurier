<template>
    <div class="profile-wrapper normalize-width">
        <div class="seperator">
            <h3 class="subtitle">Jetzige Missonen</h3>
            <div class="tasks">
                <kk-assignment
                    class
                    :key="assignments[0].id"
                    :name="assignments[0].name"
                    :date="assignments[0].date"
                    :description="assignments[0].description"
                    :town="assignments[0].town"
                    :plz="assignments[0].plz"
                ></kk-assignment>
            </div>
        </div>
        <div class="seperator">
            <h3 class="subtitle">Neue Missonen</h3>
            <div class="tasks">
                <kk-assignment
                    class
                    v-for="(assignment) in visibleassignments"
                    :key="assignment.id"
                    :name="assignment.name"
                    :date="assignment.date"
                    :description="assignment.description"
                    :town="assignment.town"
                    :plz="assignment.plz"
                ></kk-assignment>
            </div>
        </div>
        <b-button type="is-light" @click="$router.push('/auftraege')">Mehr anzeigen</b-button>

        <div class="stats">
            <h3 class="subtitle">Statistik</h3>
            <div class="box">
                <h4>Missionen in Prüfung: 4</h4>
                <h4>Wartende Karmapunkte: 420</h4>
                <h4>Abgeschlossene Missionen: 12</h4>
            </div>
        </div>

        <div>
            <div class="field">
                <div class="btns">
                    <b-switch type="is-success">Erreichbar für Anrufe</b-switch>

                    <b-button type="is-primary">Belege prüfen</b-button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import KkAssignment from "@/views/KkAssignment";

export default {
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
    },
    components: {
        KkAssignment
    }
};
</script>

<style lang="scss" scoped>
.stats {
    margin: 24px 0;
}

.btns > * {
    margin-bottom: 16px;
    margin-right: 16px;
}
.btns {
    display: block;
    @media only screen and (min-width: 512px) {
        display: flex;
        justify-content: flex-start;
        align-items: center;
    }
}
</style>