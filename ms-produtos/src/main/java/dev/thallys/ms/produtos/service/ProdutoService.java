package dev.thallys.ms.produtos.service;

import dev.thallys.ms.produtos.dto.ProdutoDTO;
import dev.thallys.ms.produtos.entity.Produto;
import dev.thallys.ms.produtos.mapper.ProdutoMapper;
import dev.thallys.ms.produtos.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static jakarta.ws.rs.core.Response.Status.BAD_REQUEST;
import static jakarta.ws.rs.core.Response.Status.NOT_FOUND;

@ApplicationScoped
public class ProdutoService {

    @Inject
    ProdutoRepository produtoRepository;

    @Inject
    ProdutoMapper produtoMapper;

    public List<Produto> findAll() {
        return produtoRepository.listAll();
    }

    public Response getAll() {
        List<ProdutoDTO> produtos =
                produtoRepository.listAll().stream()
                        .map(produto -> produtoMapper.toDTO(produto))
                        .collect(Collectors.toList());
        return Response.ok(produtos).build();
    }

    public Response getById(Long id) {
        return produtoRepository
                .findByIdOptional(id)
                .map(produto -> Response.ok(produtoMapper.toDTO(produto)).build())
                .orElse(Response.status(NOT_FOUND).build());
    }

    public Response createProduto(ProdutoDTO dto) {
        Produto produto = produtoMapper.toEntity(dto);
        produtoRepository.persist(produto);
        if (produtoRepository.isPersistent(produto)) {
            return Response.created(URI.create("/produtos/" + produto.getId())).build();
        }
        return Response.status(NOT_FOUND).build();
    }

    public Response updateProduto(ProdutoDTO dto) {
        return produtoRepository
                .findByIdOptional(dto.getId())
                .map(
                        produtoToUpdate -> {
                            Produto produtoUpdated = produtoMapper.toEntity(dto);
                            produtoToUpdate.setTitulo(produtoUpdated.getTitulo());
                            produtoToUpdate.setAutor(produtoUpdated.getAutor());
                            produtoToUpdate.setDescricao(produtoUpdated.getDescricao());
                            produtoToUpdate.setPreco(produtoUpdated.getPreco());
                            produtoToUpdate.setEstoque(produtoUpdated.getEstoque());
                            produtoToUpdate.setEditora(produtoUpdated.getEditora());
                            produtoToUpdate.setCategoria(produtoUpdated.getCategoria());
                            produtoRepository.persist(produtoToUpdate);
                            return Response.ok(produtoMapper.toDTO(produtoUpdated)).build();
                        })
                .orElse(Response.status(NOT_FOUND).build());
    }

    public Response deleteById(Long id) {
        boolean deleted = produtoRepository.deleteById(id);
        return deleted ? Response.noContent().build() : Response.status(BAD_REQUEST).build();
    }
}