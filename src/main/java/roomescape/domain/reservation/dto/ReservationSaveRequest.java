package roomescape.domain.reservation.dto;

import roomescape.global.exception.RoomEscapeException;

import java.time.LocalDate;
import java.util.Objects;

public record ReservationSaveRequest(
        Long id,
        String name,
        LocalDate date,
        Long timeId,
        Long themeId
) {
    public ReservationSaveRequest {
        try {
            Objects.requireNonNull(name, "[ERROR] 이름은 null일 수 없습니다.");
            Objects.requireNonNull(date, "[ERROR] 날짜는 null일 수 없습니다.");
            Objects.requireNonNull(timeId, "[ERROR] 시간은 null일 수 없습니다.");
            Objects.requireNonNull(themeId, "[ERROR] 테마는 null일 수 없습니다.");
        } catch (NullPointerException e) {
            throw new RoomEscapeException(e.getMessage());
        }
    }
}
