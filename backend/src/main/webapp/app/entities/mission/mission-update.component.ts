import { Component, Inject } from 'vue-property-decorator';

import { mixins } from 'vue-class-component';
import JhiDataUtils from '@/shared/data/data-utils.service';

import { numeric, required, minLength, maxLength, minValue, maxValue } from 'vuelidate/lib/validators';

import UserService from '@/admin/user-management/user-management.service';

import AlertService from '@/shared/alert/alert.service';
import { IMission, Mission } from '@/shared/model/mission.model';
import MissionService from './mission.service';

const validations: any = {
  mission: {
    firstName: {
      required
    },
    lastName: {
      required
    },
    street: {
      required
    },
    zip: {
      required,
      minLength: minLength(5),
      maxLength: maxLength(5)
    },
    city: {
      required
    },
    email: {},
    phoneNumber: {},
    order: {
      required
    },
    priceCategory: {
      required
    },
    maxPrice: {},
    paymentMethod: {
      required
    }
  }
};

@Component({
  validations
})
export default class MissionUpdate extends mixins(JhiDataUtils) {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('missionService') private missionService: () => MissionService;
  public mission: IMission = new Mission();

  @Inject('userService') private userService: () => UserService;

  public users: Array<any> = [];
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.missionId) {
        vm.retrieveMission(to.params.missionId);
      }
      vm.initRelationships();
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.mission.id) {
      this.missionService()
        .update(this.mission)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('karmakurierApp.mission.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.missionService()
        .create(this.mission)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('karmakurierApp.mission.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public retrieveMission(missionId): void {
    this.missionService()
      .find(missionId)
      .then(res => {
        this.mission = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.userService()
      .retrieve()
      .then(res => {
        this.users = res.data;
      });
  }
}
