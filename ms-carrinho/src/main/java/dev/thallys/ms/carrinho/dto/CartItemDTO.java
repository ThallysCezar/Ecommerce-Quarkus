package dev.thallys.ms.carrinho.dto;

import jakarta.persistence.Id;

import java.util.Set;

public class CartItemDTO {

    @Id
    private Long id;
    private Long usuarioId;
    private Set<Long> productIds;
    private int quantity;

    public CartItemDTO() {
    }

    public CartItemDTO(Long id, Long usuarioId, Set<Long> productIds, int quantity) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.productIds = productIds;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Set<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(Set<Long> productIds) {
        this.productIds = productIds;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}