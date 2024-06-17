package ps.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {
    @GetMapping("/version")
    public String getVersion(@RequestParam(value = "num", defaultValue = "1", required = false) Integer num) {
        return "Result = " + 1 / num;

    }
}