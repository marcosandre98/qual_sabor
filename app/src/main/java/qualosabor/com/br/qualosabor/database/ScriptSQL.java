package qualosabor.com.br.qualosabor.database;

public class ScriptSQL {

    public static String tabelaEmpresa(){

        StringBuilder sqlEmpresa = new StringBuilder();
        sqlEmpresa.append("CREATE TABLE EMPRESA ( ");
        sqlEmpresa.append("id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sqlEmpresa.append("razao_social VARCHAR (200), ");
        sqlEmpresa.append("cnpj VARCHAR (13) );");


        return sqlEmpresa.toString();
    }
}
