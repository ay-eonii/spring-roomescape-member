package roomescape.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import roomescape.exception.RoomEscapeException;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ReservationSaveRequestTest {

    @ParameterizedTest
    @CsvSource(value = {",2024-05-04", "name,"})
    public void reservation_NullNameOrDate_ThrownException(String name, LocalDate date) {
        assertThatThrownBy(() -> new ReservationSaveRequest(0L, name, date, 0L, 0L))
                .isInstanceOf(RoomEscapeException.class);
    }

    @Test
    public void reservation_NullReservationTime_ThrownException() {
        assertThatThrownBy(() -> new ReservationSaveRequest(0L, "테니", LocalDate.now(), null, 0L))
                .isInstanceOf(RoomEscapeException.class);
    }

    @Test
    public void reservation_NullTheme_ThrownException() {
        assertThatThrownBy(() -> new ReservationSaveRequest(0L, "테니", LocalDate.now(), 0L, null))
                .isInstanceOf(RoomEscapeException.class);
    }
}