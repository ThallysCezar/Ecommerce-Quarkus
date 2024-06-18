package dev.thallys.ms.carrinho.dto;

public class UserCartDTO {

    private Long id;
    private String userName;
    private String email;

    public UserCartDTO() {
    }

    public UserCartDTO(Long id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserCartDTO{" + "id=" + id + ", userName='" + userName + '\'' + ", email='" + email + '\'' + '}';
    }

}