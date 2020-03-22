<template>
    <div class="profile-wrapper normalize-width">
        <h2 class="title">Mein Profil</h2>
        <div class="seperator">
            <h3 class="subtitle">Jetzige Missonen</h3>
            <div class="tasks">
                <kk-assignment
                    v-for="assignment in myAssignments"
                    :key="assignment.id"
                    :assignment="assignment"
                    color="is-blue"
                ></kk-assignment>
            </div>
        </div>
        <div class="seperator">
            <h3 class="subtitle">Neue Missonen</h3>
            <div class="tasks">
                <kk-assignment
                    v-for="assignment in possibleAssignments"
                    :key="assignment.id"
                    :assignment="assignment"
                ></kk-assignment>

                <p v-if="possibleAssignments.length === 0">
                    Derzeit sind keine Missionen an deiner PLZ verfügbar.
                </p>
            </div>
        </div>
        <b-button type="is-light" @click="$router.push('/auftraege')">Mehr anzeigen</b-button>

        <div class="stats">
            <h3 class="subtitle">Statistik</h3>
            <div class="box">
                <h4>
                    Missionen in Prüfung:
                    <span>4</span>
                </h4>
                <h4>
                    Wartende Karmapunkte:
                    <span>420</span>
                </h4>
                <h4>
                    Abgeschlossene Missionen:
                    <span>12</span>
                </h4>
            </div>
        </div>

        <div>
            <div class="field">
                <div class="btns">
                    <b-switch type="is-success">Erreichbar für Anrufe</b-switch>

                    <b-button
                        type="is-primary"
                        @click="$router.push('/beleg-check')"
                    >Belege einreichen</b-button>
                </div>
            </div>
        </div>

        <b-loading :active="loading"></b-loading>
    </div>
</template>

<script>
import KkAssignment from "@/views/KkAssignment";
import com from "../api/com";

// Dummy zip code from user profile.
const zipCode = "81735";

export default {
    components: {
        KkAssignment
    },

    data() {
        return {
            myAssignments: [],
            possibleAssignments: [],
            loading: true
        };
    },

    created() {
        Promise.all([com.getMyMissions(), com.getMissionsInRegion(zipCode)])
            .then(([myAssignments, possibleAssignments]) => {
                this.myAssignments = myAssignments;
                this.possibleAssignments = possibleAssignments;
                this.loading = false;
            });
    }
};
</script>

<style lang="scss" scoped>
@import "@/components/Branding.scss";

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

h4 {
    span {
        color: $blue;
        font-weight: 700;
    }
}
</style>
