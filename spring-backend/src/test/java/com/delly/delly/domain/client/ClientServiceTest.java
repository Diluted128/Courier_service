package com.delly.delly.domain.client;

import com.delly.delly.domain.address.AddressRepository;
import com.delly.delly.domain.user.client.Client;
import com.delly.delly.domain.user.client.ClientRepository;
import com.delly.delly.domain.user.client.service.ClientService;
import com.delly.delly.domain.creditcard.CreditCardRepository;
import com.delly.delly.domain.district.DistrictRepository;
import com.delly.delly.domain.role.Role;
import com.delly.delly.exception.exceptions.UserAlreadyExistException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    private CreditCardRepository creditCardRepository;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private DistrictRepository districtRepository;

    @InjectMocks
    private ClientService clientService;

    @Test
    public void shouldThrowUserAlreadyExistsException(){

        // given
        Client client = new Client(
                "jacky384@gmail.com",
                "32",
                "3",
                "fjJ39JSb",
                "93859324",
                null,
                 null,
                  new Role("CLIENT"),
                null
        );
        Mockito.when(clientRepository.findClientByLogin("jacky384@gmail.com")).thenReturn(Optional.of(client));

        String expectedMessage = "User already exists with email: " + client.getLogin();

        // when
        UserAlreadyExistException exception = assertThrows(UserAlreadyExistException.class,() -> {
            clientService.addClient(client);
        });

       //then
        assertEquals(exception.getMessage(), expectedMessage);
    }
}