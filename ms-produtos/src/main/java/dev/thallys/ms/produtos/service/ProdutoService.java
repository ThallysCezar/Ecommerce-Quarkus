package dev.thallys.ms.produtos.service;

import dev.thallys.ms.produtos.dto.ProdutoDTO;
import dev.thallys.ms.produtos.entity.Produto;
import dev.thallys.ms.produtos.mapper.ProdutoMapper;
import dev.thallys.ms.produtos.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
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

    @Transactional
    public List<ProdutoDTO> getAll() {
        return produtoRepository.listAll().stream()
                .map(produto -> produtoMapper.toDTO(produto))
                .collect(Collectors.toList());
    }

    @Transactional
    public ProdutoDTO getById(Long id) {
        return produtoRepository
                .findByIdOptional(id)
                .map(produtoMapper::toDTO)
                .orElse(null); // adicionar Excecao para cada
    }

    @Transactional
    public ProdutoDTO createProduto(ProdutoDTO dto) {
        Produto produto = produtoMapper.toEntity(dto);
        produtoRepository.persistAndFlush(produto);
        if (produtoRepository.isPersistent(produto)) {
            return produtoMapper.toDTO(produto);
        }
        return null; // adicionar Excecao para cada
    }

    @Transactional
    public ProdutoDTO updateProduto(ProdutoDTO dto) {
        return produtoRepository.findByIdOptional(dto.getId())
                .map(produtoToUpdate -> {
                    Produto produtoUpdated = produtoMapper.toEntity(dto);
                    produtoToUpdate.setTitulo(produtoUpdated.getTitulo());
                    produtoToUpdate.setAutor(produtoUpdated.getAutor());
                    produtoToUpdate.setDescricao(produtoUpdated.getDescricao());
                    produtoToUpdate.setPreco(produtoUpdated.getPreco());
                    produtoToUpdate.setEstoque(produtoUpdated.getEstoque());
                    produtoToUpdate.setEditora(produtoUpdated.getEditora());
                    produtoToUpdate.setCategoria(produtoUpdated.getCategoria());
                    produtoRepository.persist(produtoToUpdate);
                    return produtoMapper.toDTO(produtoToUpdate);
                })
                .orElse(null); // adicionar Excecao para cada
    }

    @Transactional
    public boolean deleteById(Long id) {
        return produtoRepository.deleteById(id);
    }

}