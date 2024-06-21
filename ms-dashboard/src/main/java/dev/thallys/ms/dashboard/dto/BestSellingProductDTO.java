package dev.thallys.ms.dashboard.dto;

public class BestSellingProductDTO {
    private Long productId;
    private Long count;

    public BestSellingProductDTO() {
    }

    public BestSellingProductDTO(Long productId, Long count) {
        this.productId = productId;
        this.count = count;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

}
