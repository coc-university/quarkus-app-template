package com.codecampn.quarkus.app.template.business.service;

import com.codecampn.quarkus.app.template.api.model.ContractResponse;
import com.codecampn.quarkus.app.template.db.model.Contract;
import com.codecampn.quarkus.app.template.db.repository.ContractRepository;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@QuarkusTest
public class ContractServiceTest {

    @Inject
    ContractService contractService;

    @Test
    void shouldReturnContractResponse() {
        // arrange // there should be a nicer way to mock it (e.g. via @InjectMock)
        ContractRepository contractRepository = Mockito.mock(ContractRepository.class);
        when(contractRepository.findContractByName("Test")).thenReturn(Optional.of(new Contract("Test")));
        QuarkusMock.installMockForType(contractRepository, ContractRepository.class);
        // act
        ContractResponse contractResponse = contractService.findContract("Test");
        // assert
        assertThat(contractResponse.getTitle()).isEqualTo("Test");
    }

}

// this does not work:

//@QuarkusTest
//public class ContractServiceTest {
//
//    @InjectMock
//    ContractRepository contractRepository;
//
//    @Inject
//    ContractServiceDefault contractService;
//
//    @Test
//    void shouldReturnContractResponse() {
//        // arrange
//        when(contractRepository.findContractByName("Test")).thenReturn(Optional.of(new Contract("Test")));
//        // act
//        ContractResponse contractResponse = contractService.findContract("Test");
//        // assert
//        assertThat(contractResponse.getTitle()).isEqualTo("Test");
//    }
//
//}
