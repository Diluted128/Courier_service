package com.delly.delly.domain.role;

import liquibase.pro.packaged.R;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.UnknownServiceException;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public ResponseEntity<String> saveRole(String role){
         roleRepository.save(new Role(role));
         return new ResponseEntity<>("Role " + role + " successfully created.", HttpStatus.OK);
    }

    public ResponseEntity<Role> getRole(String name) throws UnknownServiceException {
        Role role = roleRepository.findByName(name).orElseThrow(
                () -> new UnknownServiceException("Role not found")
        );
        return new ResponseEntity<>(role, HttpStatus.OK);
    }
}
