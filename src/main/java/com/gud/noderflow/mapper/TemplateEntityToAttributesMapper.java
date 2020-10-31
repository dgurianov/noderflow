package com.gud.noderflow.mapper;

import com.gud.noderflow.model.TemplateAttributes;
import com.gud.noderflow.persistance.entity.TemplateEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE) //Skip all that is not mapped
public interface TemplateEntityToAttributesMapper {
    //TODO: REmove file

    TemplateEntityToAttributesMapper INSTANCE = Mappers.getMapper( TemplateEntityToAttributesMapper.class );

    public TemplateAttributes toTemplateAttributes(TemplateEntity entity);

    public  List<TemplateAttributes> toListTemplateAttributes(List<TemplateEntity> entity);

    public  TemplateEntity toTemplateEntity(TemplateAttributes attributes);

    public  List<TemplateEntity> toListTemplateEntity(List<TemplateAttributes> attributes);

}
