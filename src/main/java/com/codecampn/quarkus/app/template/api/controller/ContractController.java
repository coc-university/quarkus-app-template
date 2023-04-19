package com.codecampn.quarkus.app.template.api.controller;

import com.codecampn.quarkus.app.template.api.model.ContractResponse;
import com.codecampn.quarkus.app.template.business.service.ContractService;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RequiredArgsConstructor
public class ContractController implements V1Api {

    private final ContractService contractService;

    @Override
    public ContractResponse getContract(String name) {
        return contractService.findContract(name);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ContractResponse> getAllContracts() {
        return contractService.findAllContracts();
    }
}
