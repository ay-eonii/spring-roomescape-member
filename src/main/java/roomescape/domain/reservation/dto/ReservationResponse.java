package roomescape.domain.reservation.dto;

import roomescape.domain.reservation.domain.ReservationTime;
import roomescape.domain.theme.domain.Theme;

import java.time.LocalDate;

public record ReservationResponse(
        Long id,
        String name,
        LocalDate date,
        ReservationTime time,
        Theme theme
) {
}
