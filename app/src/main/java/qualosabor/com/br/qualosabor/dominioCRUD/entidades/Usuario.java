package qualosabor.com.br.qualosabor.dominioCRUD.entidades;

public class Usuario {

    private String loginUsuario;
    private String senha;
    private Integer idEmpresa;


    public Usuario (String loginUsuario, String senha, Integer idEmpresa) {
        this.loginUsuario = loginUsuario;
        this.senha = senha;
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

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
