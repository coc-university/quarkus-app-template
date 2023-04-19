package com.codecampn.quarkus.app.template.db.repository;

import com.codecampn.quarkus.app.template.db.model.Contract;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class ContractRepository implements PanacheRepositoryBase<Contract, UUID> {

    public Optional<Contract> findContractByName(String name) {
        return find("name", name).firstResultOptional();
    }
}