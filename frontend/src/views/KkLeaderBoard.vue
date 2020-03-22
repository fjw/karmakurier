<template>
    <div class="normalize-width">
        <KkKarmaHeader></KkKarmaHeader>

        <div
                class="custom-button orange"
                @click="$router.push('/redeem')"
        >Punkte einlösen</div>


        <div class="wrapper">
            <div class="title">
                <span>Die tollsten Helfer</span> in deiner Nähe!
            </div>
            <div class="top3">
                <div class="top3__place">
                    <div class="top3__place-winner">
                        <img src="/dummy_profile_2.jpg" alt />
                    </div>
                    <div class="top3__place-block top3__place-2">
                        <span>2</span>
                    </div>
                </div>
                <div class="top3__place">

                    <div class="top3__place-winner">
                        <img src="/dummy_profile.jpg" alt />
                    </div>
                    <div class="top3__place-block top3__place-1">
                        <span>1</span>
                    </div>
                </div>

                <div class="top3__place">
                    <div class="top3__place-winner">
                        <img src="/dummy_profile_lady.jpg" alt />
                    </div>
                    <div class="top3__place-block top3__place-3">
                        <span>3</span>
                    </div>
                </div>
            </div>
            <div class="columns is-centered is-desktop">
                <div class="column is-half">
                    <b-table :data="data" :row-class="(row, index) => row.place === 1 && 'is-you'">
                        <template slot-scope="props">
                            <b-table-column field="user.place" label="Platz" width="40" numeric>
                                <template slot="header" slot-scope="{ column }">
                                    <b-tooltip :label="column.label" dashed>
                                        {{ column.label }}
                                    </b-tooltip>
                                </template>
                                {{ props.row.place }}
                            </b-table-column>

                            <b-table-column field="user.firstName" label="Vorname">
                                <template slot="header" slot-scope="{ column }">
                                    <b-tooltip :label="column.label" dashed>
                                        {{ column.label }}
                                    </b-tooltip>
                                </template>
                                {{ props.row.firstName }}
                            </b-table-column>

                            <b-table-column field="user.lastName" label="Nachname">
                                <template slot="header" slot-scope="{ column }">
                                    <b-tooltip :label="column.label" dashed>
                                        {{ column.label }}
                                    </b-tooltip>
                                </template>
                                {{ props.row.lastName }}
                            </b-table-column>

                            <b-table-column field="user.karmaPoints" label="Karma Punkte" numeric centered>
                                <template slot="header" slot-scope="{ column }">
                                    <b-tooltip :label="column.label" dashed>
                                        {{ column.label }}
                                    </b-tooltip>
                                </template>
                                <span class="tag primary-tag">
                                    {{ props.row.karmaPoints }}
                                </span>
                            </b-table-column>
                        </template>
                    </b-table>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    components: {
        KkKarmaHeader: () => import('./KkKarmaHeader.vue'),
    },
    data() {
        return {
            data: [
                { place: 1, firstName: 'Sebastian', lastName: 'Klein', karmaPoints: 36 },
                { place: 2, firstName: 'John', lastName: 'Jacobs', karmaPoints: 33 },
                { place: 3, firstName: 'Tina', lastName: 'Gilbert', karmaPoints: 31 },
                { place: 4, firstName: 'Clarence', lastName: 'Flores', karmaPoints: 27 },
                { place: 5, firstName: 'Ralf', lastName: 'Mustermann', karmaPoints: 24 },
                { place: 6, firstName: 'Sofie', lastName: 'Higins', karmaPoints: 22 },
                { place: 7, firstName: 'Flores', lastName: 'Flores', karmaPoints: 20 },
                { place: 8, firstName: 'John', lastName: 'Gilbert', karmaPoints: 15 },
                { place: 9, firstName: 'Mustermann', lastName: 'Lee', karmaPoints: 11 },
                { place: 10, firstName: 'Kai', lastName: 'Wagner', karmaPoints: 9 }
            ],
        };
    },
};
</script>

<style lang="scss" scoped>
@import "@/components/Branding.scss";

.title {
    text-align: center;
}

.top3 {
    display: flex;
    align-items: flex-end;
    justify-content: center;
    margin-bottom: 20px;

    &__place {
        display: flex;
        flex-direction: column;
        align-items: center;

        &-block {
            width: 70px;
            background-color: $primary;
            box-shadow: inset -10px 0 0 0 darken($primary, 10%);
            display: flex;
            justify-content: center;
            align-items: center;
            color: $white;
            font-size: 1.5em;
        }

        &-winner {
            border-radius: 50%;
            overflow: hidden;
            margin-bottom: 15px;
            width: 50px;
            height: 50px;
        }

        &-1 {
            height: 100px;
            font-size: 2em;
        }

        &-2 {
            height: 75px
        }

        &-3 {
            height: 50px
        }
    }
}
.tag {
    &.primary-tag {
        background-color: $secondary;
        color: $white
    }
}

    .custom-button {
        width: 200px;
        margin: 0 auto 40px auto;
    }
</style>
