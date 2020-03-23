import { mixins } from 'vue-class-component';

import { Component, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IMission } from '@/shared/model/mission.model';
import AlertMixin from '@/shared/alert/alert.mixin';

import JhiDataUtils from '@/shared/data/data-utils.service';

import MissionService from './mission.service';

@Component
export default class Mission extends mixins(JhiDataUtils, Vue2Filters.mixin, AlertMixin) {
  @Inject('missionService') private missionService: () => MissionService;
  private removeId: number = null;

  public missions: IMission[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllMissions();
  }

  public clear(): void {
    this.retrieveAllMissions();
  }

  public retrieveAllMissions(): void {
    this.isFetching = true;

    this.missionService()
      .retrieve()
      .then(
        res => {
          this.missions = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public prepareRemove(instance: IMission): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeMission(): void {
    this.missionService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('karmakurierApp.mission.deleted', { param: this.removeId });
        this.alertService().showAlert(message, 'danger');
        this.getAlertFromStore();
        this.removeId = null;
        this.retrieveAllMissions();
        this.closeDialog();
      });
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
