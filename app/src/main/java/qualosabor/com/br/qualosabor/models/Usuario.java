package qualosabor.com.br.qualosabor.models;

import com.orm.SugarRecord;

public class Usuario extends SugarRecord {

    private String loginUsuario;
    private String senha;
    private String email;
    private Integer idEmpresa;


    public Usuario (String loginUsuario, String senha, String email, Integer idEmpresa) {
        this.loginUsuario = loginUsuario;
        this.senha = senha;
        this.email = email;
        this.idEmpresa = idEmpresa;
    }

    public Usuario () {

    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
