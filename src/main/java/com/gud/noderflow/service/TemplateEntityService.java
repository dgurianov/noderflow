package com.gud.noderflow.service;

import com.gud.noderflow.mapper.TemplateEntityToAttributesMapper;
import com.gud.noderflow.model.TemplateAttributes;
import com.gud.noderflow.persistance.repository.TemplateEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateEntityService {

    @Autowired
    TemplateEntityRepository repository;

    public TemplateAttributes getEntityById(String id ){
        return TemplateEntityToAttributesMapper.INSTANCE.toTemplateAttributes(
        repository.findById(id).orElse(null)
        );
    }

    public List<TemplateAttributes> getAllEntities(){
        return TemplateEntityToAttributesMapper.INSTANCE.toListTemplateAttributes(repository.findAll());
    }

    public List<TemplateAttributes> storeAllEntities(List<TemplateAttributes> body){
        repository.deleteAll();
        repository.saveAll(TemplateEntityToAttributesMapper.INSTANCE.toListTemplateEntity(body));
        return getAllEntities();

    }
 }
