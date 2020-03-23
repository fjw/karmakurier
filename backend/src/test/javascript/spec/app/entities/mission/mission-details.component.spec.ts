/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import MissionDetailComponent from '@/entities/mission/mission-details.vue';
import MissionClass from '@/entities/mission/mission-details.component';
import MissionService from '@/entities/mission/mission.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Mission Management Detail Component', () => {
    let wrapper: Wrapper<MissionClass>;
    let comp: MissionClass;
    let missionServiceStub: SinonStubbedInstance<MissionService>;

    beforeEach(() => {
      missionServiceStub = sinon.createStubInstance<MissionService>(MissionService);

      wrapper = shallowMount<MissionClass>(MissionDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { missionService: () => missionServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundMission = { id: 123 };
        missionServiceStub.find.resolves(foundMission);

        // WHEN
        comp.retrieveMission(123);
        await comp.$nextTick();

        // THEN
        expect(comp.mission).toBe(foundMission);
      });
    });
  });
});
