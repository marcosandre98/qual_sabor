package qualosabor.com.br.qualosabor.models;

import com.orm.SugarRecord;

public class Empresa extends SugarRecord {

    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private String cep;
    private String uf;
    private String municipio;


    public Empresa (String razaoSocial, String nomeFantasia, String cnpj, String cep, String uf, String municipio) {
        this.setRazaoSocial(razaoSocial);
        this.setNomeFantasia(nomeFantasia);
        this.setCnpj(cnpj);
        this.setCep(cep);
        this.setUf(uf);
        this.setMunicipio(municipio);
    }

    public Empresa () {

    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

}
