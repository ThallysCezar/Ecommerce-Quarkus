package dev.thallys.ms.produtos.mapper;

import dev.thallys.ms.produtos.dto.ProdutoDTO;
import dev.thallys.ms.produtos.entity.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "cdi",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProdutoMapper {
    // --- Entity to DTO
    @Mapping(target = "id", expression = "java(produto.getId())")
    ProdutoDTO toDTO(Produto produto);

    // -- DTO to Entity
    @Mapping(target = "id", ignore = true)
    Produto toEntity(ProdutoDTO produtoDTO);

    // -- MERGE
    @Mapping(target = "id", ignore = true)
    void merge(@MappingTarget Produto target, Produto source);
}