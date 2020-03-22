<template>
    <div>

        <div class="leftright">
            <div class="title">
                <span>{{name}}</span> hat einen Auftrag für dich!
            </div>

            <p>
                vor 2 Minuten ( 22.03 14:00 )
            </p>
        </div>

        <p class="address">
            {{address}}<br>
            {{plz}} {{town}}
        </p>

        <div ref="map" class="map"></div>

        <pre>{{description}}</pre>

        <div class="buttons">
            <template v-if="!activated">
                <div class="custom-button blue" @click="activated = true">Auftrag annehmen!</div>
            </template>
            <template v-if="activated">
                <div class="custom-button orange">Kontakt aufnehmen!</div>
                <div class="custom-button blue">Auftrag abschliessen!</div>
            </template>
        </div>

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
                lon: 11.627320,
                activated: false
            };
        },

        mounted() {

            var map = L.map(this.$refs.map, {
                center: [this.lat, this.lon],
                zoom: 17
            });

            L.tileLayer.provider("Wikimedia").addTo(map);

            var karmaicon = L.icon({
                iconUrl: require('@/assets/illustrations/pin.png'),
                shadowUrl: require('@/assets/illustrations/pin_shadow.png'),

                iconSize:     [100, 129], // size of the icon
                shadowSize:   [200, 110], // size of the shadow
                iconAnchor:   [50, 120], // point of the icon which will correspond to marker's location
                shadowAnchor: [78, 95],  // the same for the shadow
                popupAnchor:  [0, 0] // point from which the popup should open relative to the iconAnchor
            });

            L.marker([this.lat, this.lon], {icon: karmaicon}).addTo(map);

        }

    }
</script>

<style scoped lang="scss">
    @import "@/components/Branding.scss";
    @import "~leaflet/dist/leaflet.css";

    p, h2, h1, .title {
        margin: 5px $generalmargin;
    }

    h2 {
        font-size: 1.5rem;
    }

    .map {
        height: 300px;
    }

    pre {
        margin-top: $generalmargin;
        font-family: $family-primary;
        background: $primary-background;

        font-size: 1.3rem;
    }

    .address {
        font-size: 1.3rem;
        margin: $generalmargin;
    }

    .leftright {
        display: flex;
        justify-content: space-between;

        p {
            text-align: right;
        }
    }

    .custom-button {
        width: 250px;
        margin: $generalmargin;
    }

    .buttons {
        display: flex;
        width: 700px;
        margin: auto;
    }

</style>