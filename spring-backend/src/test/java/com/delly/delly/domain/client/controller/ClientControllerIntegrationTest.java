package com.delly.delly.domain.client.controller;
import com.delly.delly.domain.user.client.Client;
import com.delly.delly.domain.user.client.ClientRepository;
import com.delly.delly.domain.role.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import javax.transaction.Transactional;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ClientControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void shouldAddNewClientAndReturnID() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/client/register")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content("{ \"email\": \"jacky@gmail.com\", \"password\": \"wsfm237AjSn12\" }")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful()).andReturn();

        String response = mvcResult.getResponse().getContentAsString();

        assertThat(response, matchesPattern("Client: \\d+ created"));
    }

    @Test
    public void shouldThrow400WhenClientIsAlreadyCreated() throws Exception {

        //when
        Client client = new Client(
                "jacky384@gmail.com",
                "Jacky",
                "Rambo",
                "fjJ39JSb",
                "93859324",
                null,
                null,
                 new Role("CLIENT"),
                null
        );
        clientRepository.save(client);

        //given
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/client/register")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content("{ \"email\": \"jacky384@gmail.com\", \"password\": \"wsfm237AjSn12\" }")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError()).andReturn();

        String response = Objects.requireNonNull(mvcResult.getResolvedException()).getMessage();

        //then
        Assertions.assertEquals(response, "User already exists with email: " + client.getLogin());
    }

    @Test
    public void shouldFindClientAndReturnID() throws Exception {
        // given
        Client client = new Client(
                "jacky@gmail.com",
                "32",
                "3",
                "wsfm237AjSn12",
                "93859324",
                null,
                null,
                new Role("CLIENT"),
                null
        );

        Client savedClient = clientRepository.save(client);

        //when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/client/login")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content("{ \"email\": \"jacky@gmail.com\", \"password\": \"wsfm237AjSn12\" }")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful()).andReturn();

        String response = mvcResult.getResponse().getContentAsString();

        //then
        Assertions.assertEquals(Integer.parseInt(response), savedClient.getId());
    }

    @Test
    public void shouldTrow404WhenUserIsNotFound() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/client/login")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content("{ \"email\": \"jacky@gmail.com\", \"password\": \"wsfm237AjSn12\" }")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError()).andReturn();

        String response = Objects.requireNonNull(mvcResult.getResolvedException()).getMessage();

        //then
        Assertions.assertEquals(response, "User not found with email: jacky@gmail.com");
    }
}