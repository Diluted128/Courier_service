package com.delly.delly.service;

import com.delly.delly.dao.District;
import com.delly.delly.repositories.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    DistrictRepository districtRepository;

    @Autowired
    public DistrictService(DistrictRepository districtRepository){
        this.districtRepository = districtRepository;
    }

    public List<District> getAllDistricts(){
        return districtRepository.findAll();
    }
}
