package roomescape.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import roomescape.exception.RoomEscapeException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ThemeTest {

    @ParameterizedTest
    @CsvSource(value = {",description,thumbnail", "name,,thumbnail", "name,description,"})
    void theme_Null_ThrownException(String name, String description, String thumbnail) {
        assertThatThrownBy(() -> new Theme(0L, name, description, thumbnail))
                .isInstanceOf(RoomEscapeException.class);
    }
}