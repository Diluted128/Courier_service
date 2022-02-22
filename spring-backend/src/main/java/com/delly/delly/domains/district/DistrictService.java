package com.delly.delly.domains.district;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DistrictService {

    DistrictRepository districtRepository;

    public List<District> getAllDistricts(){
        return districtRepository.findAll();
    }
}
