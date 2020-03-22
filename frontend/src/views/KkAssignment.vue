<template>
    <section>

        <b-collapse class="card" animation="slide" aria-id="contentIdForA11y3" :open="false">
            <div
                    slot="trigger"
                    class="card-header"
                    role="button"
                    aria-controls="contentIdForA11y3">
                <div class="card-header-title">
                    <div>
                        {{name}} aus {{plz}} {{town}}
                    </div>
                    <div>
                        {{timesince}}
                    </div>
                </div>
            </div>
            <div class="card-content">
                <div class="content">
                    {{description}}
                </div>
            </div>
            <footer class="card-footer">
                <div class="custom-button blue" @click="$router.push('/auftragsdetails')">Jetzt helfen!</div>
            </footer>
        </b-collapse>

    </section>
</template>

<script>
    export default {
        name: "KkAssignment",

        props: {
            id: {
                type: Number,
                required: true
            },
            name: String,
            date: Date,
            description: String,
            plz: String,
            town: String,
            open: Boolean
        },

        data() {
            return {
            };
        },

        computed: {
            timesince() {

                return "vor 2 Minuten";
            }
        }
    }
</script>

<style scoped lang="scss">
    @import "@/components/Branding.scss";

    .card {
        margin: $generalmargin;

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
