package com.gud.noderflow.persistance.repository;

import com.gud.noderflow.persistance.entity.TemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TemplateEntityRepository extends JpaRepository<TemplateEntity, String> {
}
