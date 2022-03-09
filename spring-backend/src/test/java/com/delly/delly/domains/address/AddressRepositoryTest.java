package com.delly.delly.domains.address;

import com.delly.delly.domains.client.Client;
import com.delly.delly.domains.client.ClientRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AddressRepositoryTest {

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private ClientRepository clientRepository;


    @Test
    void shouldReturnClientWithID() {
        // given
        Address address = new Address(
                "72",
                "3",
                "193-32",
                "Blake ST",
                "Kansas City",
                null
        );

        Client client = new Client(
                "jacky384@gmail.com",
                "32",
                "3",
                "fjJ39JSb",
                "93859324",
                null,
                 address,
                null
        );
        clientRepository.save(client);
        addressRepository.save(address);

    }



    @Test
    void getAddressByCompanyIDAnAndDistrictID() {
    }
}