package roomescape.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/reservation")
    public String getReservationPage() {
        return "/reservation";
    }

    @GetMapping
    public String getAdminPageByRedirect() {
        return "index";
    }
}
