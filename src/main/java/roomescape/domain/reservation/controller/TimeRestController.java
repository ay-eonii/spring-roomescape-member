package roomescape.domain.reservation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import roomescape.domain.reservation.dto.TimeMemberResponse;
import roomescape.domain.reservation.dto.TimeSaveRequest;
import roomescape.domain.reservation.service.ReservationTimeService;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/times")
public class TimeRestController {

    private final ReservationTimeService reservationTimeService;

    public TimeRestController(ReservationTimeService reservationTimeService) {
        this.reservationTimeService = reservationTimeService;
    }

    @GetMapping
    public ResponseEntity<List<roomescape.domain.reservation.dto.TimeResponse>> getTimes() {
        List<roomescape.domain.reservation.dto.TimeResponse> responses = reservationTimeService.findAllTimes();

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/member")
    public ResponseEntity<List<TimeMemberResponse>> getTimes(@RequestParam LocalDate date, @RequestParam Long themeId) {
        List<TimeMemberResponse> responses = reservationTimeService.findAllTimes(date, themeId);

        return ResponseEntity.ok(responses);
    }

    @PostMapping
    public ResponseEntity<roomescape.domain.reservation.dto.TimeResponse> createTime(@RequestBody TimeSaveRequest request) {
        roomescape.domain.reservation.dto.TimeResponse response = reservationTimeService.saveTime(request);

        URI location = URI.create("/times/" + response.id());
        return ResponseEntity.created(location).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTime(@PathVariable Long id) {
        reservationTimeService.deleteTimeById(id);

        return ResponseEntity.noContent().build();
    }
}