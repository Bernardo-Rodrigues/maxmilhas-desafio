package com.maxmilhas.desafio.api.integration;

import com.maxmilhas.desafio.api.domain.entities.Cpf;
import com.maxmilhas.desafio.api.repositories.CpfRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
public class CpfIntegrationTest implements WithAssertions {

    private static final String CPF_CONTROLLER_BASE_URL = "/cpf";

    @Autowired
    private MockMvc mvc;
    @Autowired
    private CpfRepository cpfRepository;

    @AfterAll
    public void deleteAll(){
        cpfRepository.deleteAll();
    }

    @Test
    void givenARequestToListAllCpfsWhenThereAreCpfsRegisteredThenReturnAllOfThem() throws Exception {
        MockHttpServletResponse response = mvc.perform(
                        get(CPF_CONTROLLER_BASE_URL)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn().getResponse();

        Integer responseLength = response.getContentAsString().split("cpf").length - 1;
        Integer itemsSaved = cpfRepository.findAll().size();

        assertThat(responseLength).isEqualTo(itemsSaved);
    }

    @Test
    void givenARequestToVerifyIfACpfIsRegisteredWhenItIsThenReturnIt() throws Exception {
        Cpf cpfRegistered = cpfRepository.findAll().get(0);

        MockHttpServletResponse response = mvc.perform(
                        get(CPF_CONTROLLER_BASE_URL + "/" + cpfRegistered.getCpf())
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn().getResponse();

        assertThat(response.getContentAsString()).contains(cpfRegistered.getCpf());
    }
}
