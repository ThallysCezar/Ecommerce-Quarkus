package dev.thallys.ms.dashboard.dto;

public class InactiveUsersDTO {

    private long usuariosInativos;

    public InactiveUsersDTO() {
    }

    public InactiveUsersDTO(long usuariosInativos) {
        this.usuariosInativos = usuariosInativos;
    }

    public long getUsuariosInativos() {
        return usuariosInativos;
    }

    public void setUsuariosInativos(long usuariosInativos) {
        this.usuariosInativos = usuariosInativos;
    }

}