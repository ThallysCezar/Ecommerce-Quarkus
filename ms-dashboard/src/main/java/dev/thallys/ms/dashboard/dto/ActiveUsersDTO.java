package dev.thallys.ms.dashboard.dto;

public class ActiveUsersDTO {

    private long usuariosAtivos;

    public ActiveUsersDTO() {
    }

    public ActiveUsersDTO(long usuariosAtivos) {
        this.usuariosAtivos = usuariosAtivos;
    }

    public long getUsuariosAtivos() {
        return usuariosAtivos;
    }

    public void setUsuariosAtivos(long usuariosAtivos) {
        this.usuariosAtivos = usuariosAtivos;
    }

}