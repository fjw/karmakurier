<template>
  <div :class="activated ? 'activated' : ''">
    <div class="title">
      <template v-if="!activated">
        <span>{{name}}</span> hat eine Mission für dich!
      </template>
      <template v-if="activated">
        <span>Du</span>
        hast eine Mission für {{name}}. Danke dafür!
      </template>
    </div>

    <p>vor 2 Minuten ( 22.03 14:00 )</p>

    <pre class="address">
{{address}}
{{plz}} {{town}}</pre>

    <div ref="map" class="map"></div>

    <div class="buttons">
      <div v-if="isLoggedIn">
        <template v-if="!activated">
          <div class="custom-button blue" @click="activated = true">Mission annehmen!</div>
        </template>
        <template v-if="activated">
          <div class="custom-button orange">Kontakt aufnehmen!</div>
          <div class="custom-button blue" @click="$router.push('/dashboard');">Mission abschliessen!</div>
        </template>
      </div>
      <div v-else>
        <div class="custom-button blue" @click="logIn()">Mission annehmen</div>
      </div>
    </div>
  </div>
</template>

<script>
import L from "leaflet";
import "leaflet-providers";
import { mapState } from "vuex";

export default {
  name: "KkAssignmentDetails",

  data() {
    return {
      name: "Annette",
      address: "Hofangerstr. 21",
      date: Date.now(),
      description:
        "- eine Tüte Chips\n- 700t Klopapier\nbringen Sie ne Grapfruit mit wenns die gibt, BIO bitte",
      plz: "81735",
      town: "München",
      lat: 48.109136,
      lon: 11.62732,
      activated: false
    };
  },

  computed: mapState(["isLoggedIn"]),

  methods: {
    logIn() {
      this.$router.push("/einloggen");
    }
  },

  mounted() {
    var map = L.map(this.$refs.map, {
      center: [this.lat, this.lon],
      zoom: 17
    });

    L.tileLayer.provider("Wikimedia").addTo(map);

    var karmaicon = L.icon({
      iconUrl: require("@/assets/illustrations/pin.png"),
      shadowUrl: require("@/assets/illustrations/pin_shadow.png"),

      iconSize: [100, 129], // size of the icon
      shadowSize: [200, 110], // size of the shadow
      iconAnchor: [50, 120], // point of the icon which will correspond to marker's location
      shadowAnchor: [78, 95], // the same for the shadow
      popupAnchor: [0, 0] // point from which the popup should open relative to the iconAnchor
    });

    L.marker([this.lat, this.lon], { icon: karmaicon }).addTo(map);
  }
};
</script>

<style scoped lang="scss">
@import "@/components/Branding.scss";
@import "~leaflet/dist/leaflet.css";

p,
h2,
h1,
.title {
  margin: 5px $generalmargin;
}

h2 {
  font-size: 1.5rem;
}

.map {
  height: 300px;
}

pre {
  font-family: $family-primary;
  background: $primary-background;

  font-size: 1.3rem;
  padding: 20px;
}

/*
    .address {
        font-size: 1.3rem;
        margin-top: $generalmargin;
    }
    */

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
  justify-content: center;
}
</style>