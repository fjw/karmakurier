<template>
    <div class="wrapper">
        <div class="top3">
            <div class="top3__place">
                <div class="top3__place-winner">
                    <img src="/dummy_profile.jpg" alt />
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
                    <img src="/dummy_profile.jpg" alt />
                </div>
                <div class="top3__place-block top3__place-3">
                    <span>3</span>
                </div>
            </div>
        </div>
        <div class="columns is-centered is-desktop">
            <div class="column is-half">
                <b-table :data="data">
                    <template slot-scope="props">
                        <b-table-column field="id" label="Platz" width="40" numeric>
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

                        <b-table-column field="user.karmaPoints" label="Karma Punkte" centered>
                            <template slot="header" slot-scope="{ column }">
                                <b-tooltip :label="column.label" dashed>
                                    {{ column.label }}
                                </b-tooltip>
                            </template>
                            <span class="tag is-success">
                                {{ props.row.karmaPoints }}
                            </span>
                        </b-table-column>
                    </template>
                </b-table>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            data: [
                { place: 1, firstName: 'Flores', lastName: 'Simmons', karmaPoints: '34' },
                { place: 2, firstName: 'John', lastName: 'Jacobs', karmaPoints: '33' },
                { place: 3, firstName: 'Tina', lastName: 'Gilbert', 'karmaPoints': '31' },
                { place: 4, firstName: 'Clarence', lastName: 'Flores', karmaPoints: '27' },
                { place: 5, firstName: 'Ralf', lastName: 'Mustermann', karmaPoints: '24' },
                { place: 6, firstName: 'Sofie', lastName: 'Higins', karmaPoints: '22' },
                { place: 7, firstName: 'Flores', lastName: 'Flores', karmaPoints: '20' },
                { place: 8, firstName: 'John', lastName: 'Gilbert', karmaPoints: '15' },
                { place: 9, firstName: 'Mustermann', lastName: 'Lee', karmaPoints: '11' },
                { place: 10, firstName: 'Kai', lastName: 'Wagner', karmaPoints: '9' }
            ],
        };
    },
};
</script>

<style lang="scss" scoped>
@import "@/components/Branding.scss";

.top3 {
    display: flex;
    align-items: flex-end;
    justify-content: center;

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
            color: white;
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
</style>
