package com.delly.delly.domain.district;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DistrictService {

    DistrictRepository districtRepository;

    public ResponseEntity<List<District>> getAllDistricts(){
        return new ResponseEntity<>(districtRepository.findAll(), HttpStatus.OK);
    }
}
