package org.karmakurier.backend.web.rest;

import org.karmakurier.backend.KarmakurierApp;
import org.karmakurier.backend.domain.Mission;
import org.karmakurier.backend.repository.MissionRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.karmakurier.backend.security.AuthoritiesConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.karmakurier.backend.domain.enumeration.PriceCategory;
import org.karmakurier.backend.domain.enumeration.PaymentMethod;
/**
 * Integration tests for the {@link MissionResource} REST controller.
 */
@SpringBootTest(classes = KarmakurierApp.class)

@AutoConfigureMockMvc
@WithMockUser
public class MissionResourceIT {

    private static final String DEFAULT_FIRST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_FIRST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_LAST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_LAST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_STREET = "AAAAAAAAAA";
    private static final String UPDATED_STREET = "BBBBBBBBBB";

    private static final String DEFAULT_ZIP = "AAAAA";
    private static final String UPDATED_ZIP = "BBBBB";

    private static final String DEFAULT_CITY = "AAAAAAAAAA";
    private static final String UPDATED_CITY = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_PHONE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_PHONE_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_ORDER = "AAAAAAAAAA";
    private static final String UPDATED_ORDER = "BBBBBBBBBB";

    private static final PriceCategory DEFAULT_PRICE_CATEGORY = PriceCategory.PREMIUM;
    private static final PriceCategory UPDATED_PRICE_CATEGORY = PriceCategory.CHEAP;

    private static final BigDecimal DEFAULT_MAX_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_MAX_PRICE = new BigDecimal(2);

    private static final PaymentMethod DEFAULT_PAYMENT_METHOD = PaymentMethod.PAYPAL;
    private static final PaymentMethod UPDATED_PAYMENT_METHOD = PaymentMethod.CASH;

    @Autowired
    private MissionRepository missionRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restMissionMockMvc;

    private Mission mission;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Mission createEntity(EntityManager em) {
        Mission mission = new Mission()
            .firstName(DEFAULT_FIRST_NAME)
            .lastName(DEFAULT_LAST_NAME)
            .street(DEFAULT_STREET)
            .zip(DEFAULT_ZIP)
            .city(DEFAULT_CITY)
            .email(DEFAULT_EMAIL)
            .phoneNumber(DEFAULT_PHONE_NUMBER)
            .order(DEFAULT_ORDER)
            .priceCategory(DEFAULT_PRICE_CATEGORY)
            .maxPrice(DEFAULT_MAX_PRICE)
            .paymentMethod(DEFAULT_PAYMENT_METHOD);
        return mission;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Mission createUpdatedEntity(EntityManager em) {
        Mission mission = new Mission()
            .firstName(UPDATED_FIRST_NAME)
            .lastName(UPDATED_LAST_NAME)
            .street(UPDATED_STREET)
            .zip(UPDATED_ZIP)
            .city(UPDATED_CITY)
            .email(UPDATED_EMAIL)
            .phoneNumber(UPDATED_PHONE_NUMBER)
            .order(UPDATED_ORDER)
            .priceCategory(UPDATED_PRICE_CATEGORY)
            .maxPrice(UPDATED_MAX_PRICE)
            .paymentMethod(UPDATED_PAYMENT_METHOD);
        return mission;
    }

    @BeforeEach
    public void initTest() {
        mission = createEntity(em);
    }

    @Test
    @Transactional
    public void createMission() throws Exception {
        int databaseSizeBeforeCreate = missionRepository.findAll().size();

        // Create the Mission
        restMissionMockMvc.perform(post("/api/missions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mission)))
            .andExpect(status().isCreated());

        // Validate the Mission in the database
        List<Mission> missionList = missionRepository.findAll();
        assertThat(missionList).hasSize(databaseSizeBeforeCreate + 1);
        Mission testMission = missionList.get(missionList.size() - 1);
        assertThat(testMission.getFirstName()).isEqualTo(DEFAULT_FIRST_NAME);
        assertThat(testMission.getLastName()).isEqualTo(DEFAULT_LAST_NAME);
        assertThat(testMission.getStreet()).isEqualTo(DEFAULT_STREET);
        assertThat(testMission.getZip()).isEqualTo(DEFAULT_ZIP);
        assertThat(testMission.getCity()).isEqualTo(DEFAULT_CITY);
        assertThat(testMission.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testMission.getPhoneNumber()).isEqualTo(DEFAULT_PHONE_NUMBER);
        assertThat(testMission.getOrder()).isEqualTo(DEFAULT_ORDER);
        assertThat(testMission.getPriceCategory()).isEqualTo(DEFAULT_PRICE_CATEGORY);
        assertThat(testMission.getMaxPrice()).isEqualTo(DEFAULT_MAX_PRICE);
        assertThat(testMission.getPaymentMethod()).isEqualTo(DEFAULT_PAYMENT_METHOD);
    }

    @Test
    @Transactional
    public void createMissionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = missionRepository.findAll().size();

        // Create the Mission with an existing ID
        mission.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restMissionMockMvc.perform(post("/api/missions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mission)))
            .andExpect(status().isBadRequest());

        // Validate the Mission in the database
        List<Mission> missionList = missionRepository.findAll();
        assertThat(missionList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkFirstNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = missionRepository.findAll().size();
        // set the field null
        mission.setFirstName(null);

        // Create the Mission, which fails.

        restMissionMockMvc.perform(post("/api/missions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mission)))
            .andExpect(status().isBadRequest());

        List<Mission> missionList = missionRepository.findAll();
        assertThat(missionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkLastNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = missionRepository.findAll().size();
        // set the field null
        mission.setLastName(null);

        // Create the Mission, which fails.

        restMissionMockMvc.perform(post("/api/missions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mission)))
            .andExpect(status().isBadRequest());

        List<Mission> missionList = missionRepository.findAll();
        assertThat(missionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkStreetIsRequired() throws Exception {
        int databaseSizeBeforeTest = missionRepository.findAll().size();
        // set the field null
        mission.setStreet(null);

        // Create the Mission, which fails.

        restMissionMockMvc.perform(post("/api/missions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mission)))
            .andExpect(status().isBadRequest());

        List<Mission> missionList = missionRepository.findAll();
        assertThat(missionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkZipIsRequired() throws Exception {
        int databaseSizeBeforeTest = missionRepository.findAll().size();
        // set the field null
        mission.setZip(null);

        // Create the Mission, which fails.

        restMissionMockMvc.perform(post("/api/missions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mission)))
            .andExpect(status().isBadRequest());

        List<Mission> missionList = missionRepository.findAll();
        assertThat(missionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCityIsRequired() throws Exception {
        int databaseSizeBeforeTest = missionRepository.findAll().size();
        // set the field null
        mission.setCity(null);

        // Create the Mission, which fails.

        restMissionMockMvc.perform(post("/api/missions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mission)))
            .andExpect(status().isBadRequest());

        List<Mission> missionList = missionRepository.findAll();
        assertThat(missionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkPriceCategoryIsRequired() throws Exception {
        int databaseSizeBeforeTest = missionRepository.findAll().size();
        // set the field null
        mission.setPriceCategory(null);

        // Create the Mission, which fails.

        restMissionMockMvc.perform(post("/api/missions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mission)))
            .andExpect(status().isBadRequest());

        List<Mission> missionList = missionRepository.findAll();
        assertThat(missionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkPaymentMethodIsRequired() throws Exception {
        int databaseSizeBeforeTest = missionRepository.findAll().size();
        // set the field null
        mission.setPaymentMethod(null);

        // Create the Mission, which fails.

        restMissionMockMvc.perform(post("/api/missions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mission)))
            .andExpect(status().isBadRequest());

        List<Mission> missionList = missionRepository.findAll();
        assertThat(missionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllMissions() throws Exception {
        // Initialize the database
        missionRepository.saveAndFlush(mission);

        // Get all the missionList
        restMissionMockMvc.perform(get("/api/missions?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(mission.getId().intValue())))
            .andExpect(jsonPath("$.[*].firstName").value(hasItem(DEFAULT_FIRST_NAME)))
            .andExpect(jsonPath("$.[*].lastName").value(hasItem(DEFAULT_LAST_NAME)))
            .andExpect(jsonPath("$.[*].street").value(hasItem(DEFAULT_STREET)))
            .andExpect(jsonPath("$.[*].zip").value(hasItem(DEFAULT_ZIP)))
            .andExpect(jsonPath("$.[*].city").value(hasItem(DEFAULT_CITY)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].phoneNumber").value(hasItem(DEFAULT_PHONE_NUMBER)))
            .andExpect(jsonPath("$.[*].order").value(hasItem(DEFAULT_ORDER.toString())))
            .andExpect(jsonPath("$.[*].priceCategory").value(hasItem(DEFAULT_PRICE_CATEGORY.toString())))
            .andExpect(jsonPath("$.[*].maxPrice").value(hasItem(DEFAULT_MAX_PRICE.intValue())))
            .andExpect(jsonPath("$.[*].paymentMethod").value(hasItem(DEFAULT_PAYMENT_METHOD.toString())));
    }
    
    @Test
    @Transactional
    public void getMission() throws Exception {
        // Initialize the database
        missionRepository.saveAndFlush(mission);

        // Get the mission
        restMissionMockMvc.perform(get("/api/missions/{id}", mission.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(mission.getId().intValue()))
            .andExpect(jsonPath("$.firstName").value(DEFAULT_FIRST_NAME))
            .andExpect(jsonPath("$.lastName").value(DEFAULT_LAST_NAME))
            .andExpect(jsonPath("$.street").value(DEFAULT_STREET))
            .andExpect(jsonPath("$.zip").value(DEFAULT_ZIP))
            .andExpect(jsonPath("$.city").value(DEFAULT_CITY))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.phoneNumber").value(DEFAULT_PHONE_NUMBER))
            .andExpect(jsonPath("$.order").value(DEFAULT_ORDER.toString()))
            .andExpect(jsonPath("$.priceCategory").value(DEFAULT_PRICE_CATEGORY.toString()))
            .andExpect(jsonPath("$.maxPrice").value(DEFAULT_MAX_PRICE.intValue()))
            .andExpect(jsonPath("$.paymentMethod").value(DEFAULT_PAYMENT_METHOD.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingMission() throws Exception {
        // Get the mission
        restMissionMockMvc.perform(get("/api/missions/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    @WithMockUser(authorities = AuthoritiesConstants.ADMIN)
    public void updateMission() throws Exception {
        // Initialize the database
        missionRepository.saveAndFlush(mission);

        int databaseSizeBeforeUpdate = missionRepository.findAll().size();

        // Update the mission
        Mission updatedMission = missionRepository.findById(mission.getId()).get();
        // Disconnect from session so that the updates on updatedMission are not directly saved in db
        em.detach(updatedMission);
        updatedMission
            .firstName(UPDATED_FIRST_NAME)
            .lastName(UPDATED_LAST_NAME)
            .street(UPDATED_STREET)
            .zip(UPDATED_ZIP)
            .city(UPDATED_CITY)
            .email(UPDATED_EMAIL)
            .phoneNumber(UPDATED_PHONE_NUMBER)
            .order(UPDATED_ORDER)
            .priceCategory(UPDATED_PRICE_CATEGORY)
            .maxPrice(UPDATED_MAX_PRICE)
            .paymentMethod(UPDATED_PAYMENT_METHOD);

        restMissionMockMvc.perform(put("/api/missions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedMission)))
            .andExpect(status().isOk());

        // Validate the Mission in the database
        List<Mission> missionList = missionRepository.findAll();
        assertThat(missionList).hasSize(databaseSizeBeforeUpdate);
        Mission testMission = missionList.get(missionList.size() - 1);
        assertThat(testMission.getFirstName()).isEqualTo(UPDATED_FIRST_NAME);
        assertThat(testMission.getLastName()).isEqualTo(UPDATED_LAST_NAME);
        assertThat(testMission.getStreet()).isEqualTo(UPDATED_STREET);
        assertThat(testMission.getZip()).isEqualTo(UPDATED_ZIP);
        assertThat(testMission.getCity()).isEqualTo(UPDATED_CITY);
        assertThat(testMission.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testMission.getPhoneNumber()).isEqualTo(UPDATED_PHONE_NUMBER);
        assertThat(testMission.getOrder()).isEqualTo(UPDATED_ORDER);
        assertThat(testMission.getPriceCategory()).isEqualTo(UPDATED_PRICE_CATEGORY);
        assertThat(testMission.getMaxPrice()).isEqualTo(UPDATED_MAX_PRICE);
        assertThat(testMission.getPaymentMethod()).isEqualTo(UPDATED_PAYMENT_METHOD);
    }

    @Test
    @Transactional
    @WithMockUser(authorities = AuthoritiesConstants.ADMIN)
    public void updateNonExistingMission() throws Exception {
        int databaseSizeBeforeUpdate = missionRepository.findAll().size();

        // Create the Mission

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restMissionMockMvc.perform(put("/api/missions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(mission)))
            .andExpect(status().isBadRequest());

        // Validate the Mission in the database
        List<Mission> missionList = missionRepository.findAll();
        assertThat(missionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    @WithMockUser(authorities = AuthoritiesConstants.ADMIN)
    public void deleteMission() throws Exception {
        // Initialize the database
        missionRepository.saveAndFlush(mission);

        int databaseSizeBeforeDelete = missionRepository.findAll().size();

        // Delete the mission
        restMissionMockMvc.perform(delete("/api/missions/{id}", mission.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Mission> missionList = missionRepository.findAll();
        assertThat(missionList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
