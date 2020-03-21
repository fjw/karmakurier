<template>
    <div>
        <h1 class="title">Auftrag</h1>

        <div class="leftright">
            <h2>
                {{name}}
            </h2>

            <p>
                vor 2 Minuten ( 22.03 14:00 )
            </p>
        </div>

        <p>
            {{address}}<br>
            {{plz}} {{town}}
        </p>

        <div ref="map" class="map"></div>

        <pre>{{description}}</pre>

    </div>
</template>

<script>

    import L from 'leaflet';
    import 'leaflet-providers';

    export default {
        name: "KkAssignmentDetails",

        data() {
            return {
                name: "Annette",
                address: "Hofangerstr. 21",
                date: Date.now(),
                description: "- eine Tüte Chips\n- 700t Klopapier\nbringen Sie ne Grapfruit mit wenns die gibt, BIO bitte",
                plz: "81735",
                town: "München",
                lat: 48.109136,
                lon: 11.627320
            };
        },

        mounted() {

            var map = L.map(this.$refs.map, {
                center: [this.lat, this.lon],
                zoom: 17
            });

            L.tileLayer.provider("Wikimedia").addTo(map);

        }

    }
</script>

<style scoped lang="scss">
    @import "@/components/Branding.scss";
    @import "~leaflet/dist/leaflet.css";

    p, h2, h1 {
        margin: 5px $generalmargin;
    }

    h2 {
        font-size: 1.5rem;
    }

    .map {
        height: 200px;
    }

    pre {
        margin-top: $generalmargin;
        font-family: $family-primary;
        background: $primary-background;
    }

    .leftright {
        display: flex;
        justify-content: space-between;

        p {
            text-align: right;
        }
    }

</style>