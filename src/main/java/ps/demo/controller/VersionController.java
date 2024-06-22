package ps.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class VersionController {
    @GetMapping("/version")
    public String getVersion(@RequestParam(value = "num", defaultValue = "1", required = false) Integer num) {
        return "Result = " + 1 / num;

    }

    @GetMapping("/randomNum")
    public Integer getRandom() {
        int x = RandomUtils.nextInt(0, 10);
        log.info("randomNum = {}", x);
        return x;

    }
}