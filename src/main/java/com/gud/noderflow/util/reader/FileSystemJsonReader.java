package com.gud.noderflow.util.reader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gud.noderflow.persistance.entity.TemplateEntity;
import com.gud.noderflow.persistance.repository.TemplateEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@Component
@Slf4j
@Order(Ordered.LOWEST_PRECEDENCE)
public class FileSystemJsonReader implements DataReader<TemplateEntity> {

    //TODO: re-think whether it is loader or reader.
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    TemplateEntityRepository repo;

    @Value("${gud.load.data.endpoint}")
    private String filePathString;

    @PostConstruct
    @Override
    public List<TemplateEntity> readAll() {
        try {
            readToDatabase();
        } catch (Exception e) {
            log.error("There was a problem to read file {}", filePathString);
            return Collections.emptyList();
        }
        return repo.findAll();
    }

    public void readToDatabase() throws Exception {
        List<TemplateEntity> list = objectMapper.readValue(getClass().getResourceAsStream(filePathString), new TypeReference<List<TemplateEntity>>() {
        });
        repo.saveAll(list);

    }
}
