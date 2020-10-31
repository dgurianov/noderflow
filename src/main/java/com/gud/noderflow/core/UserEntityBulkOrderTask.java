package com.gud.noderflow.core;

import com.gud.noderflow.core.enricher.UserEntityEnricher;
import com.gud.noderflow.persistance.entity.UserEntity;
import com.gud.noderflow.persistance.repository.UserEntityRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

public class UserEntityBulkOrderTask implements BulkOrderTask{

    @Getter @Setter
    private Long quantity;

    private UserEntityRepository repository;

    @Autowired
    private UserEntityEnricher enricher;

    public UserEntityBulkOrderTask(Long quantity, UserEntityRepository repository, UserEntityEnricher enricher){
        this.setQuantity(quantity);
        this.repository = repository;
        this.enricher = enricher;
    }

    @Override
    public String call() throws Exception {
        Long counter = this.getQuantity();
        while(counter > 0 ){
            UserEntity newUserEntity = UserEntity.class.newInstance();
            enricher.enrich(newUserEntity);
            counter--;
            repository.save(newUserEntity);
        }
        return "OK";
    }


    @Override
    public String toString() {
        return "UserEntityBulkOrderTask{" +
                "quantity=" + quantity +
                ", repository=" + repository +
                ", enricher=" + enricher +
                '}';
    }
}
