<template>
    <section>

        <b-collapse class="card" animation="slide" aria-id="contentIdForA11y3" :open="false">
            <div
                    slot="trigger"
                    slot-scope="props"
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
                <a class="card-header-icon">
                    <b-icon
                            :icon="props.open ? 'menu-down' : 'menu-up'">
                    </b-icon>
                </a>
            </div>
            <div class="card-content">
                <div class="content">
                    {{description}}
                </div>
            </div>
            <footer class="card-footer">
                <router-link class="card-footer-item" to="/auftragsdetails">Jetzt helfen!</router-link>
            </footer>
        </b-collapse>

    </section>
</template>

<script>
    export default {
        name: "KkAssignment",

        props: {
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
</style>