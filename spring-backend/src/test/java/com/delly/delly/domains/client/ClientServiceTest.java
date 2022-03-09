package com.delly.delly.domains.client;

import com.delly.delly.domains.address.AddressRepository;
import com.delly.delly.domains.creditcard.CreditCardRepository;
import com.delly.delly.domains.district.DistrictRepository;
import com.delly.delly.exception.exceptions.UserAlreadyExistException;
import com.delly.delly.exception.exceptions.UserNotFoundException;
import org.h2.engine.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

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
                null
        );
        Mockito.when(clientRepository.findClientByEmail("jacky384@gmail.com")).thenReturn(Optional.of(client));

        String expectedMessage = "User already exists with email: " + client.getEmail();

        // when
        UserAlreadyExistException exception = assertThrows(UserAlreadyExistException.class,() -> {
            clientService.insertClientsCredential(client);
        });

       //then
        assertEquals(exception.getMessage(), expectedMessage);
    }




}