package com.gud.noderflow.mapper;

import com.gud.noderflow.model.TemplateAttributes;
import com.gud.noderflow.model.UserEntityAttributes;
import com.gud.noderflow.persistance.entity.TemplateEntity;
import com.gud.noderflow.persistance.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE) //Skip all that is not mapped
public interface UserEntityMapper {

    UserEntityMapper INSTANCE = Mappers.getMapper( UserEntityMapper.class );

    public UserEntityAttributes toUserEntityAttributes(UserEntity entity);

    public  List<UserEntityAttributes> toListUserEntityAttributes(List<UserEntity> entities);

    public  UserEntity toUserEntity(UserEntityAttributes attributes);

    public  List<UserEntity> toListUserEntity(List<UserEntityAttributes> attributes);

}
