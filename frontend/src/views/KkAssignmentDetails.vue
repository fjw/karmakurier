<template>
    <div>
        <h1>Auftrag</h1>

        <h2>
            {{name}}
        </h2>

        <p>
            vor 2 Minuten ( 22.03 14:00 )
        </p>

        <p>
           {{plz}} {{town}}
        </p>


        <div ref="map" class="map"></div>


    </div>
</template>

<script>

    import L from 'leaflet';
    import 'leaflet-providers';

    export default {
        name: "KkAssignmentDetails",

        props: {
            name: String,
            date: Date,
            description: String,
            plz: String,
            town: String,
            lat: {
                default: 48.137154
            } ,
            lon: {
                default: 11.576124
            }
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

    @import "~leaflet/dist/leaflet.css";

    .map {
        height: 200px;
    }

</style>