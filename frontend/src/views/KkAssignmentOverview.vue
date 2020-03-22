<template>
  <div class="normalize-width">
    <div class="plzfilterinput">
      <div class="title" v-if="zipCode !== ''">
        <span>{{assignments.length}}</span> Personen benötigen eine Einkaufsunterstüzung.
      </div>

      <div class="title" v-if="zipCode === ''">
        Bitte geben Sie Ihre <span>Postleitzahl</span> an.
      </div>

      <b-field label="PLZ">
        <b-input v-model="zipCode"></b-input>
      </b-field>

      <p v-if="zipCode !== '' && assignments.length === 0">
        Leider wurden keine Missionen gefunden. Bitte suchen Sie auch nach Postleitzahlen im Umkreis.
      </p>
    </div>

    <kk-assignment
      class
      v-for="assignment in assignments"
      :key="assignment.id"
      :assignment="assignment"
    ></kk-assignment>

    <b-loading :active="loading"></b-loading>
  </div>
</template>

<script>
import KkAssignment from "./KkAssignment";
import com from "../api/com";
import debounce from "lodash.debounce";
import parseISO from "date-fns/parseISO";

export default {
  name: "KkAssignmentOverview",
  components: { KkAssignment },
  data() {
    return {
      // Zip code.
      zipCode: "",

      // Found assignments.
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
      if (value !== "" && value.length >= 3) {
        this.fetchAssignmentsForZip();
      } else {
        this.assignments = [];
      }
    }, 500)
  },

  methods: {
    /**
     * Fetch assignments for currently entered ZIP code.
     */
    fetchAssignmentsForZip() {
      // Set loading state.
      this.loading = true;

      // Make API call.
      com.getMissionsInRegion(this.zipCode)
        .then(data => {
          this.assignments = data.map(assignment => {
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
};
</script>

<style scoped lang="scss">
.plzfilterinput {
  margin: 20px 0;

  .control {
    width: 90px;
  }
}
</style>
