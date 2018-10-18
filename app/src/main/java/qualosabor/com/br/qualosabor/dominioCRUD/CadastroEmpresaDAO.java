package qualosabor.com.br.qualosabor.dominioCRUD;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.SQLException;
        import android.database.sqlite.SQLiteDatabase;
        import android.util.Log;

        import java.lang.reflect.Array;
        import java.util.ArrayList;

        import qualosabor.com.br.qualosabor.database.DataBase;
        import qualosabor.com.br.qualosabor.dominioCRUD.entidades.Empresa;

public class CadastroEmpresaDAO {
    private SQLiteDatabase conn;
    private DataBase dataBase;

    public CadastroEmpresaDAO(Context context) {
        //so foi craido a coenxao com o banco igual foi feito na classe MAAIN
        this.dataBase = new DataBase(context);
        this.conn = this.dataBase.getWritableDatabase();
        //con a com feitoa na linha a cima pode inserir no banco
    }

    public Boolean insert(Empresa empresa){
        ContentValues values = new ContentValues();

        values.put("razao_social", empresa.getRazao_social());
        values.put("nome_fantasia", empresa.getNome_fantasia());
        values.put("cnpj", empresa.getCnpj());
        values.put("cep", empresa.getCep());
        values.put("uf", empresa.getUf());
        values.put("municipio", empresa.getMunicipio());

        try{
            conn.insertOrThrow("EMPRESA", null, values);
            Log.i("teste", "Empresa " + empresa.getId() +" Inserida com sucesso!");
            return true;
        }catch(SQLException erro){
            Log.e("teste", "Erro " + erro.getMessage());
            return false;
        }

    }
    public ArrayList<Empresa> buscaEmpresas(Context context){
        ArrayList<Empresa> adpEmpresas = new ArrayList<>();

        Cursor cursor = conn.query("EMPRESA", null, null, null, null, null, null, null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                Empresa emp = new Empresa();
                emp.setId(cursor.getInt(0));
                emp.setNome_fantasia(cursor.getString(1));
                emp.setCnpj(cursor.getString(2));
                emp.setRazao_social(cursor.getString(3));
                emp.setCep(cursor.getString(4));
                emp.setUf(cursor.getString(5));
                emp.setMunicipio(cursor.getString(6));

                adpEmpresas.add(emp);
                Log.d("teste", cursor.getString(0) + " Nome Fantasia " + cursor.getString(1));


            } while(cursor.moveToNext());
        }

        return adpEmpresas;



    }
    public void delete(int id){

    }
    public void update(int id){

    }
}
