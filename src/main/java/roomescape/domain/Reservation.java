package roomescape.domain;

import roomescape.exception.IllegalTimeException;

import java.time.LocalDate;

public class Reservation {
    private final Long id;
    private final String name;
    private final LocalDate date;
    private final ReservationTime time;

    public Reservation(Long id, String name, LocalDate date, ReservationTime time) {
        validateName(name);
        validateDate(date);
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
    }

    private void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 예약자 이름입니다.");
        }
    }

    private void validateDate(LocalDate date) {
        if (date == null) {
            throw new IllegalDateException("[ERROR] 유효하지 않은 날짜입니다.");
        }
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalDateException("[ERROR] 이미 지난 날짜입니다.");
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public ReservationTime getTime() {
        return time;
    }

    public Long getReservationTimeId() {
        return time.getId();
    }
}
