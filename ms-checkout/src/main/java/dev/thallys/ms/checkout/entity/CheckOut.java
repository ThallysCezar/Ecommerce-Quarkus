package dev.thallys.ms.checkout.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "checkout")
public class CheckOut extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Double total;
    private String status;

    @Column(name = "formapagamento")
    private String formaPagamento;

    public CheckOut() {
    }

    public CheckOut(Long id, Long userId, Double total, String status, String formaPagamento) {
        this.id = id;
        this.userId = userId;
        this.total = total;
        this.status = status;
        this.formaPagamento = formaPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Override
    public String toString() {
        return "CheckOut{" +
                "id=" + id +
                ", userId=" + userId +
                ", total=" + total +
                ", status='" + status + '\'' +
                ", formaPagamento='" + formaPagamento + '\'' +
                '}';
    }

}