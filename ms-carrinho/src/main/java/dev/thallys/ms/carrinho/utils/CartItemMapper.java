package dev.thallys.ms.carrinho.utils;

import dev.thallys.ms.carrinho.dto.CartItemDTO;
import dev.thallys.ms.carrinho.entity.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "cdi",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CartItemMapper {

    // --- Entity to DTO
    @Mapping(target = "id", expression = "java(cartItem.getId())")
    CartItemDTO toDTO(CartItem cartItem);

    // -- DTO to Entity
    @Mapping(target = "id", ignore = true)
    CartItem toEntity(CartItemDTO cartItemDTO);

    // -- MERGE
    @Mapping(target = "id", ignore = true)
    void merge(@MappingTarget CartItem target, CartItem source);

}