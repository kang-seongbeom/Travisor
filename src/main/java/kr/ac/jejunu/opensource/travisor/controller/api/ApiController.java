package kr.ac.jejunu.opensource.travisor.controller.api;

import kr.ac.jejunu.opensource.travisor.dto.Dto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @PostMapping("test")
    public void callAPI() {
    }
}
