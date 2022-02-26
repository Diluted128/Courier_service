package com.delly.delly.domains.district;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
