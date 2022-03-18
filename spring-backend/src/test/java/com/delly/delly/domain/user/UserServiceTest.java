package com.delly.delly.domain.user;

import com.delly.delly.domain.role.Role;
import com.delly.delly.domain.user.administrator.AdministratorRepository;
import com.delly.delly.domain.user.client.Client;
import com.delly.delly.domain.user.client.ClientRepository;
import com.delly.delly.exception.exceptions.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.delly.delly.domain.user.courier.CourierRepository;
import com.delly.delly.domain.user.officeworker.OfficeWorkerRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private CourierRepository courierRepository;

    @Mock
    private OfficeWorkerRepository officeWorkerRepository;

    @Mock
    private AdministratorRepository administratorRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void shouldFindUserWithUsername(){
        // given

        Client client = new Client(
                "rob.mek@gmail.com",
                "32",
                "3",
                "fjJ39JSb",
                "93859324",
                null,
                null,
                new Role("CLIENT"),
                null
        );

        Mockito.when(clientRepository.findClientByUsername(client.getUsername())).thenReturn(Optional.of(client));
        Mockito.when(courierRepository.findCourierByUsername(client.getUsername())).thenReturn(Optional.empty());
        Mockito.when(officeWorkerRepository.findOfficeWorkerByUsername(client.getUsername())).thenReturn(Optional.empty());
        Mockito.when(administratorRepository.findAdministratorByUsername(client.getUsername())).thenReturn(Optional.empty());

        // when
        UserDetails userDetails = userService.loadUserByUsername(client.getUsername());

        // then
        assert(userDetails != null);
        Assertions.assertEquals(userDetails.getUsername(), "rob.mek@gmail.com");
        Assertions.assertEquals(userDetails.getPassword(), "fjJ39JSb");
//      assert(userDetails.getAuthorities().equals(List.of(new SimpleGrantedAuthority(client.getRole().getName()))));
    }

    @Test
    public void shouldNotFindUserAndThrowException(){
        // given
        Client client = new Client(
                "rob.mek@gmail.com",
                "32",
                "3",
                "fjJ39JSb",
                "93859324",
                null,
                null,
                new Role("CLIENT"),
                null
        );

        Mockito.when(clientRepository.findClientByUsername(client.getUsername())).thenReturn(Optional.empty());
        Mockito.when(courierRepository.findCourierByUsername(client.getUsername())).thenReturn(Optional.empty());
        Mockito.when(officeWorkerRepository.findOfficeWorkerByUsername(client.getUsername())).thenReturn(Optional.empty());
        Mockito.when(administratorRepository.findAdministratorByUsername(client.getUsername())).thenReturn(Optional.empty());

        // when
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class,() -> {
            userService.loadUserByUsername(client.getUsername());
        });

        // then
        Assertions.assertEquals(exception.getMessage(), "User rob.mek@gmail.com not found.");
    }
}
