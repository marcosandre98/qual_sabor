package qualosabor.com.br.qualosabor.database;

public class ScriptSQL {

    public static String tabelas(){

        StringBuilder createSql = new StringBuilder();
        createSql.append("CREATE TABLE EMPRESA ( ");
        createSql.append("id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        createSql.append("razao_social VARCHAR (100) NOT NULL, ");
        createSql.append("nome_fantasia VARCHAR (100) NOT NULL, ");
        createSql.append("cnpj VARCHAR (20) NOT NULL, ");
        createSql.append("cep VARCHAR (15) NOT NULL, ");
        createSql.append("uf VARCHAR (2) NOT NULL, ");
        createSql.append("municipio VARCHAR (100) NOT NULL);");

        createSql.append("CREATE TABLE USUARIO ( ");
        createSql.append("login VARCHAR (50) PRIMARY KEY, ");
        createSql.append("email VARCHAR (100) NOT NULL, ");
        createSql.append("senha VARCHAR (100) NOT NULL, ");
        createSql.append("id_empresa INTEGER NOT NULL);");

        createSql.append("CREATE TABLE SABORES ( ");
        createSql.append("id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        createSql.append("nome_sabor VARCHAR (100) NOT NULL, ");
        createSql.append("ingredientes VARCHAR (800) NOT NULL, ");
        createSql.append("imagem BLOB, ");
        createSql.append("id_empresa INTEGER NOT NULL  );");

        createSql.append("CREATE TABLE CLIENTES ( ");
        createSql.append("id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        createSql.append("nome_cliente VARCHAR (100) NOT NULL, ");
        createSql.append("id_empresa INTEGER NOT NULL );");

        createSql.append("CREATE TABLE PEDIDOS ( ");
        createSql.append("id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        createSql.append("mesa VARCHAR (100) NOT NULL, ");
        createSql.append("id_sabor INTEGER NOT NULL, ");
        createSql.append("id_cliente INTEGER NOT NULL, ");
        createSql.append("id_empresa INTEGER NOT NULL );");

        return createSql.toString();
    }
}
