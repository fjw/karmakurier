package org.karmakurier.backend.repository;

import org.karmakurier.backend.domain.Mission;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Mission entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {

    @Query("select mission from Mission mission where mission.assignedHelper.login = ?#{principal.username}")
    List<Mission> findByAssignedHelperIsCurrentUser();

    /**
     * Returns all missions whose zip codes start with given prefix
     * @param zipPrefix
     * @return
     */
    List<Mission> findByZipStartingWith(String zipPrefix);
}
