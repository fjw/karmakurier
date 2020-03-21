<template>
    <div>

        <kk-assignment class=""
            v-for="assignment in assignments"
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
        components: {KkAssignment},
        data() {
            return {
                assignments: [

                    {
                        id: 1,
                        plz: "81735",
                        town: "München",
                        time: Date.now(),
                        name: "Vanessa",
                        description: "3 x Paracetamol\nBitte fragen Sie nach den günstigsten.\n\nWenn es noch Desinfiziermittel gibt würde ich 3 kleine Flaschen nehmen."
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
                        plz: "81373",
                        town: "München",
                        time: Date.now(),
                        name: "Hannelore",
                        description: "Ich brauche nur diese einen Kornflakes. Die mit dem Affen auf der Verpackung. Bitte 4 Packungen."
                    }
                ]
            };
        },

    }
</script>

<style scoped>

</style>