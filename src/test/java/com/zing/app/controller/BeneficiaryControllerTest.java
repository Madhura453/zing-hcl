package com.zing.app.controller;

import com.zing.app.model.BeneficiaryDetails;
import com.zing.app.service.BeneficiaryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeneficiaryController.class)
public class BeneficiaryControllerTest {

    @MockBean
    private BeneficiaryService beneficiaryService;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void givenCustomerId_thenReturnOkStatusBeneficiaryDetails() throws Exception{

        long id = 1L;
        BeneficiaryDetails details = new BeneficiaryDetails();
        details.setId(1l);
        details.setName("abc");
        details.setAccountNumber(1234);
        List<BeneficiaryDetails> beneficiaryDetails = new ArrayList<>(
                Arrays.asList(details));
        when(beneficiaryService.findAllBeneficiaryDetails(id)).thenReturn(beneficiaryDetails);
        mockMvc.perform(get("/v1/mybank/beneficiaries/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(beneficiaryDetails.size()))
                .andDo(print());
    }

    @Test
    public void givenCustomerId_thenReturnNotFoundBeneficiaryDetails() throws Exception{

        long id = 1L;
        List<BeneficiaryDetails> beneficiaryDetails = new ArrayList<>();
        when(beneficiaryService.findAllBeneficiaryDetails(id)).thenReturn(beneficiaryDetails);
        mockMvc.perform(get("/v1/mybank/beneficiaries/1"))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

}
