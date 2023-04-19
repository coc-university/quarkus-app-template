package com.codecampn.quarkus.app.template.business.service;

import com.codecampn.quarkus.app.template.api.model.ContractResponse;

import java.util.List;

public interface ContractService {

    ContractResponse findContract(String name);
    List<ContractResponse> findAllContracts();
}
