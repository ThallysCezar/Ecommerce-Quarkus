package dev.thallys.ms.carrinho.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class CartItem extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usercart_id", nullable = false)
    private UserCart usercart;

    @ElementCollection
    @CollectionTable(name = "cart_item_product_ids", joinColumns = @JoinColumn(name = "cartitem_id"))
    @Column(name = "product_id")
    private Set<Long> productIds = new HashSet<>();
    private int quantity;

    public CartItem() {
    }

    public CartItem(Long id, UserCart usercart, Set<Long> productIds, int quantity) {
        this.id = id;
        this.usercart = usercart;
        this.productIds = productIds;
        this.quantity = quantity;
    }

    public CartItem(Long productId, int quantity) {
    }

    public UserCart getUser() {
        return usercart;
    }

    public void setUser(UserCart usercart) {
        this.usercart = usercart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", usercart=" + usercart +
                ", productIds=" + productIds +
                ", quantity=" + quantity +
                '}';
    }

}