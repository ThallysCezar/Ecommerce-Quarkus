package dev.thallys.ms.carrinho.utils;

import dev.thallys.ms.carrinho.dto.UserCartDTO;
import dev.thallys.ms.carrinho.entity.UserCart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "cdi",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserCartMapper {

    // --- Entity to DTO
    @Mapping(target = "id", expression = "java(userCart.getId())")
    UserCartDTO toDTO(UserCart userCart);

    // -- DTO to Entity
    @Mapping(target = "id", ignore = true)
    UserCart toEntity(UserCartDTO cartItemDTO);

    // -- MERGE
    @Mapping(target = "id", ignore = true)
    void merge(@MappingTarget UserCart target, UserCart source);

}
