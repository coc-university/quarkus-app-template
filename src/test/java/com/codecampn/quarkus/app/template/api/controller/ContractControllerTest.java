package com.codecampn.quarkus.app.template.api.controller;

import com.codecampn.quarkus.app.template.api.model.ContractResponse;
import com.codecampn.quarkus.app.template.business.service.ContractService;
import com.codecampn.quarkus.app.template.business.service.ContractServiceDefault;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@QuarkusTest
public class ContractControllerTest {

    @Test
    public void testContractEndpoint() {
        // there should be a nicer way to mock it (e.g. via @InjectMock)
        ContractService contractService = Mockito.mock(ContractServiceDefault.class);
        when(contractService.findContract(any())).thenReturn(new ContractResponse().title("Versicherung ABC"));
        QuarkusMock.installMockForType(contractService, ContractService.class);

        ContractResponse response = given()
          .when().get("/v1/contract")
          .then()
                .statusCode(200)
                .extract().body().as(ContractResponse.class);

        assertThat(response.getTitle()).isEqualTo("Versicherung ABC");
    }

}