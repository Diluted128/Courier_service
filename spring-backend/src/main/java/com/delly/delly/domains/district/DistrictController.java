package com.delly.delly.domains.district;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class DistrictController {

    DistrictService districtService;

    @GetMapping("/districts")
    public ResponseEntity<List<District>> getAllDistricts() {
        return districtService.getAllDistricts();
    }
}
