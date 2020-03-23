import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { IMission } from '@/shared/model/mission.model';
import MissionService from './mission.service';

@Component
export default class MissionDetails extends mixins(JhiDataUtils) {
  @Inject('missionService') private missionService: () => MissionService;
  public mission: IMission = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.missionId) {
        vm.retrieveMission(to.params.missionId);
      }
    });
  }

  public retrieveMission(missionId) {
    this.missionService()
      .find(missionId)
      .then(res => {
        this.mission = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
