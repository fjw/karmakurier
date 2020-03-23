package org.karmakurier.backend.web.rest;

import org.apache.commons.lang3.StringUtils;
import org.karmakurier.backend.domain.Mission;
import org.karmakurier.backend.repository.MissionRepository;
import org.karmakurier.backend.security.AuthoritiesConstants;
import org.karmakurier.backend.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link org.karmakurier.backend.domain.Mission}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class MissionResource {

    private final Logger log = LoggerFactory.getLogger(MissionResource.class);

    private static final String ENTITY_NAME = "mission";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MissionRepository missionRepository;

    public MissionResource(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    /**
     * {@code POST  /missions} : Create a new mission.
     *
     * @param mission the mission to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new mission, or with status {@code 400 (Bad Request)} if the mission has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/missions")
    public ResponseEntity<Mission> createMission(@Valid @RequestBody Mission mission) throws URISyntaxException {
        log.debug("REST request to save Mission : {}", mission);
        if (mission.getId() != null) {
            throw new BadRequestAlertException("A new mission cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Mission result = missionRepository.save(mission);
        return ResponseEntity.created(new URI("/api/missions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /missions} : Updates an existing mission.
     *
     * @param mission the mission to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated mission,
     * or with status {@code 400 (Bad Request)} if the mission is not valid,
     * or with status {@code 500 (Internal Server Error)} if the mission couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/missions")
    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    public ResponseEntity<Mission> updateMission(@Valid @RequestBody Mission mission) throws URISyntaxException {
        log.debug("REST request to update Mission : {}", mission);
        if (mission.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Mission result = missionRepository.save(mission);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, mission.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /missions} : get all the missions.
     *
     * @param zipPrefix if given, only results that start with given zipPrefix are returned
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of missions in body.
     */
    @GetMapping("/missions")
    public List<Mission> getAllMissions(@RequestParam Optional<String> zipPrefix) {
        if (zipPrefix.isPresent() && StringUtils.isNotEmpty(zipPrefix.get())) {
            log.debug("REST request to get all Missions whose zip start with " + zipPrefix.get());
            return missionRepository.findByZipStartingWith(zipPrefix.get());
        } else {
            log.debug("REST request to get all Missions");
            return missionRepository.findAll();
        }
    }

    /**
     * {@code GET  /missions/:id} : get the "id" mission.
     *
     * @param id the id of the mission to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the mission, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/missions/{id}")
    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.USER + "\")")
    public ResponseEntity<Mission> getMission(@PathVariable Long id) {
        log.debug("REST request to get Mission : {}", id);
        Optional<Mission> mission = missionRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(mission);
    }

    /**
     * {@code DELETE  /missions/:id} : delete the "id" mission.
     *
     * @param id the id of the mission to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/missions/{id}")
    @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.ADMIN + "\")")
    public ResponseEntity<Void> deleteMission(@PathVariable Long id) {
        log.debug("REST request to delete Mission : {}", id);
        missionRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
