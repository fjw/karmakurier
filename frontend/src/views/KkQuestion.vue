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
                        {{title}}
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
                    {{text}}
                </div>
            </div>
        </b-collapse>
    </section>
</template>

<script>
    export default {
        name: "KkQuestion",

        props: {
            id: {
                type: Number,
                required: true
            },
            title: String,
            text: String,
            open: Boolean
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
