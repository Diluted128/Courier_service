package com.delly.delly.domain.user;

import com.delly.delly.domain.user.administrator.Administrator;
import com.delly.delly.domain.user.client.Client;
import com.delly.delly.domain.user.client.ClientRepository;
import com.delly.delly.domain.user.courier.Courier;
import com.delly.delly.domain.user.courier.CourierRepository;
import com.delly.delly.domain.user.officeworker.OfficeWorker;
import com.delly.delly.domain.user.officeworker.OfficeWorkerRepository;
import com.delly.delly.domain.user.administrator.AdministratorRepository;
import com.delly.delly.exception.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final ClientRepository clientRepository;
    private final CourierRepository courierRepository;
    private final OfficeWorkerRepository officeWorkerRepository;
    private final AdministratorRepository administratorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Client> client = clientRepository.findClientByUsername(username);
        Optional<Courier> courier = courierRepository.findCourierByUsername(username);
        Optional<OfficeWorker> officeWorker = officeWorkerRepository.findOfficeWorkerByUsername(username);
        Optional<Administrator> administrator = administratorRepository.findAdministratorByUsername(username);

       Optional<? extends User> user =  Stream.of(client, courier, officeWorker, administrator)
                                        .filter(Optional::isPresent)
                                           .findFirst()
                                              .orElseThrow(() -> new EntityNotFoundException("User: " + username + " not found."));

      return new org.springframework.security.core.userdetails.User(
              user.get().getUsername(),
              user.get().getPassword(),
              List.of(new SimpleGrantedAuthority(user.get().getRole().getName())));
    }
}
