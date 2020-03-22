<template>
  <div :class="activated ? 'activated' : ''">
    <div v-show="assignment">
      <div class="title">
        <template v-if="!activated">
          <span>{{assignment.person.firstName}} {{assignment.person.lastName}}</span> hat eine Mission für dich!
        </template>
        <template v-if="activated">
          <span>Du</span>
          hast eine Mission für {{assignment.person.firstName}} {{assignment.person.lastName}}. Danke dafür!
        </template>
      </div>

      <p>{{assignment.timeSince}}</p>

      <pre class="address">
  {{assignment.person.address}}
  {{assignment.person.zipCode}} {{assignment.person.city}}
      </pre>

      <div ref="map" class="map"></div>

      <div class="buttons">
        <div v-if="isLoggedIn">
          <template v-if="!activated">
            <div class="custom-button blue" @click="activated = true">Mission annehmen!</div>
          </template>
          <template v-if="activated">
            <div class="custom-button orange">Kontakt aufnehmen!</div>
            <div
              class="custom-button blue"
              @click="$router.push('/dashboard');"
            >Mission abschliessen!</div>
          </template>
        </div>
        <div v-else>
          <div class="custom-button blue" @click="logIn()">Mission annehmen</div>
        </div>
      </div>
    </div>

    <b-loading :active="loading"></b-loading>
  </div>
</template>

<script>
import L from "leaflet";
import "leaflet-providers";
import { mapState } from "vuex";
import com from "../api/com";

export default {
  name: "KkAssignmentDetails",

  props: {
    id: {
      type: Number,
      required: true
    }
  },

  data() {
    return {
      loading: true,
      assignment: null,
      activated: false
    };
  },

  computed: {
    ...mapState(["isLoggedIn"])
  },

  watch: {
    assignment(value) {
      if (value !== null) {
        window.setTimeout(() => this.initializeMap(value.person.lat, value.person.lon), 500);
      }
    }
  },

  methods: {
    logIn() {
      this.$router.push("/einloggen");
    },

    initializeMap(lat, lon) {
      const map = L.map(this.$refs.map, {
        center: [lat, lon],
        zoom: 17
      });

      L.tileLayer.provider("Wikimedia").addTo(map);

      const karmaicon = L.icon({
        iconUrl: require("@/assets/illustrations/pin.png"),
        shadowUrl: require("@/assets/illustrations/pin_shadow.png"),

        iconSize: [100, 129], // size of the icon
        shadowSize: [200, 110], // size of the shadow
        iconAnchor: [50, 120], // point of the icon which will correspond to marker's location
        shadowAnchor: [78, 95], // the same for the shadow
        popupAnchor: [0, 0] // point from which the popup should open relative to the iconAnchor
      });

      L.marker([lat, lon], {
        icon: karmaicon
      }).addTo(map);
    }
  },

  mounted() {
    com.getMission(this.id).then(assignment => {
      this.assignment = assignment;
      this.loading = false;
    });
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
