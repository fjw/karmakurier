package org.karmakurier.backend.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.karmakurier.backend.web.rest.TestUtil;

public class MissionTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Mission.class);
        Mission mission1 = new Mission();
        mission1.setId(1L);
        Mission mission2 = new Mission();
        mission2.setId(mission1.getId());
        assertThat(mission1).isEqualTo(mission2);
        mission2.setId(2L);
        assertThat(mission1).isNotEqualTo(mission2);
        mission1.setId(null);
        assertThat(mission1).isNotEqualTo(mission2);
    }
}
