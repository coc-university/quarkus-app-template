package com.codecampn.quarkus.app.template.db.repository;

import com.codecampn.quarkus.app.template.db.model.Contract;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class ContractRepositoryTest {

    @Inject
    ContractRepository contractRepository;

    @Test
    void shouldReturnContractFromDatabase() {
        // arrange: h2-db has contract entries by default after startup via liquibase
        String contractName = "Versicherung 1";
        // act
        Optional<Contract> contract = contractRepository.findContractByName(contractName);
        // assert
        assertThat(contract).isNotEmpty();
    }

}
