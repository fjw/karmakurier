/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import MissionComponent from '@/entities/mission/mission.vue';
import MissionClass from '@/entities/mission/mission.component';
import MissionService from '@/entities/mission/mission.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-alert', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {}
  }
};

describe('Component Tests', () => {
  describe('Mission Management Component', () => {
    let wrapper: Wrapper<MissionClass>;
    let comp: MissionClass;
    let missionServiceStub: SinonStubbedInstance<MissionService>;

    beforeEach(() => {
      missionServiceStub = sinon.createStubInstance<MissionService>(MissionService);
      missionServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<MissionClass>(MissionComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          alertService: () => new AlertService(store),
          missionService: () => missionServiceStub
        }
      });
      comp = wrapper.vm;
    });

    it('should be a Vue instance', () => {
      expect(wrapper.isVueInstance()).toBeTruthy();
    });

    it('Should call load all on init', async () => {
      // GIVEN
      missionServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllMissions();
      await comp.$nextTick();

      // THEN
      expect(missionServiceStub.retrieve.called).toBeTruthy();
      expect(comp.missions[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      missionServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      comp.removeMission();
      await comp.$nextTick();

      // THEN
      expect(missionServiceStub.delete.called).toBeTruthy();
      expect(missionServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
