package dev.thallys.ms.dashboard.dto;

public class TotalSalesDTO {

    private String total;

    public TotalSalesDTO() {
    }

    public TotalSalesDTO(String totalDeVendas) {
        this.total = totalDeVendas;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}