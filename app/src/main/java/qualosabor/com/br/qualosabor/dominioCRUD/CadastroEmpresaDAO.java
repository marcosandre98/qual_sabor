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

    public void insert(Empresa empresa){
        ContentValues values = new ContentValues();

        values.put("razao_social", empresa.getRazao_social() );
        values.put("cnpj", empresa.getCnpj());
        try{
            conn.insertOrThrow("EMPRESA", null, values);
            Log.i("igor", "Empresa " + empresa.getRazao_social() +" Inserida com sucesso!");
        }catch(SQLException erro){
            Log.e("igor", "Erro " + erro.getMessage());
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
                emp.setRazao_social(cursor.getString(1));
                emp.setCnpj(cursor.getString(2));

                adpEmpresas.add(emp);
                Log.d("carr", cursor.getString(0) + " Razao " + cursor.getString(1));


            } while(cursor.moveToNext());
        }

        return adpEmpresas;



    }
    public void delete(int id){

    }
    public void update(int id){

    }
}
