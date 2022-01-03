package com.delly.delly.Service;

import com.delly.delly.dao.Deliver;
import com.delly.delly.repositories.DeliverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliverService {

    DeliverRepository deliverRepository;

    @Autowired
    public DeliverService(DeliverRepository deliverRepository) {
        this.deliverRepository = deliverRepository;
    }

    public Integer getDeliverByEmailAndPassword(String email, String password){
        return deliverRepository.getDeliverByEmailAndPassword(email, password);
    }
}
