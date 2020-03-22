<template>
  <div class="wrapper">
    <div class="overview-wrapper">
      <div class="title">
        <span>{{assignments.length}}</span> Personen benötigen eine Einkaufsunterstüzung.
      </div>
    </div>

    <div class="plzfilterinput">
      <b-field label="PLZ">
        <b-input v-model="zipCode"></b-input>
      </b-field>

      <p v-if="zipCode === ''">Bitte geben Sie Ihre Postleitzahl an.</p>

      <p
        v-if="zipCode !== '' && assignments.length === 0"
      >Leider wurden keine Missionen gefunden. Bitte suchen Sie auch nach Postleitzahlen im Umkreis.</p>
    </div>

    <KkTaskItem
      class
      v-for="assignment in assignments"
      :key="assignment.id"
      :assignment="assignment"
    ></KkTaskItem>

    <b-loading :active="loading"></b-loading>
  </div>
</template>

<script>
import KkTaskItem from "@/components/molecules/KkTaskItem";
import api from "../../api";
import debounce from "lodash.debounce";
import parseISO from "date-fns/parseISO";

export default {
  components: { KkTaskItem },
  data() {
    return {
      // Zip code filter.
      zipCode: "",

      // Assignments for zip code filter.
      assignments: [],

      // Total number of assignments.
      assignmentCount: 12,

      // API client.
      client: null,

      // Loading state.
      loading: false
    };
  },

  watch: {
    /**
     * Watch user input with debounce to not call API too often.
     */
    zipCode: debounce(function(value) {
      if (value !== "") {
        this.fetchAssignmentsForZip();
      } else {
        this.assignments = [];
      }
    }, 750)
  },

  methods: {
    /**
     * Fetch assignments for currently entered ZIP code.
     */
    fetchAssignmentsForZip() {
      // Set loading state.
      this.loading = true;

      // Make API call.
      this.client.apis.default
        .get_orders__zipCode_({ zipCode: this.zipCode })
        .then(response => {
          this.assignments = response.body.map(assignment => {
            assignment.date = parseISO(assignment.date);

            return assignment;
          });
        })
        .catch(error => {
          // @todo Handle error?
          console.error(error);
        })
        .finally(() => {
          // Unset loading state.
          this.loading = false;
        });
    }
  },

  async created() {
    // Fetch API client and store locally.
    this.client = await api;
  }
};
</script>

<style lang="scss" scoped>
@import "@/components/Branding.scss";

.plzfilterinput {
  .control {
    width: 90px;
  }
}

.overview-wrapper {
  border-radius: 4px;
  overflow: hidden;
  // box-shadow: 0px 4px 8px rgba($primary, 0.24);
  width: 100%;
  max-width: 320px;
  @media only screen and (min-width: 560px) {
    width: 100%;
    max-width: 512px;
  }
  .title {
    // background-color: $primary;
    span {
      font-weight: 700;
      color: $blue;
    }
    padding: 16px 0 16px 0;
  }
}
</style>
