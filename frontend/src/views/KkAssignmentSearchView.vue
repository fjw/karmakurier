<template>
  <div class="normalize-width">
    <KkTaskList />
  </div>
</template>

<script>
import KkTaskList from "../components/organisms/KkTaskList.vue";

export default {
  name: "KkAssignmentSearchView",
  components: {
    KkTaskList
  }
};
</script>