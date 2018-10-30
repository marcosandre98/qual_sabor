package qualosabor.com.br.qualosabor.dao;

import android.util.Log;

import qualosabor.com.br.qualosabor.models.Empresa;

//
//        import android.content.ContentValues;
//        import android.content.Context;
//        import android.database.Cursor;
//        import android.database.SQLException;
//        import android.database.sqlite.SQLiteDatabase;
//        import android.util.Log;
//
//        import java.lang.reflect.Array;
//        import java.util.ArrayList;
//
//
public class CadastroEmpresaDAO {

    public Boolean insert(Empresa empresa) {
        try {
            empresa.save();
            Log.i("teste", "Empresa " + empresa.getId() + " Inserida com sucesso!");
            return true;
        } catch(Exception erro) {
            Log.e("teste", "Erro " + erro.getMessage());
            return false;
        }

    }
}

//        Listagem de todos Empresas persistidos no banco */
//        for (Empresa empr : Empresa.listAll(Empresa.class)) {
//            Log.d("SUGAR", "Empresa id: " + empr.getId());
//        }

//    public ArrayList<Empresa> buscaEmpresas(Context context){
//        ArrayList<Empresa> adpEmpresas = new ArrayList<>();
//
//        Cursor cursor = conn.query("EMPRESA", null, null, null, null, null, null, null);
//
//        if(cursor.getCount() > 0){
//            cursor.moveToFirst();
//            do{
//                Empresa emp = new Empresa();
//                emp.setId(cursor.getInt(0));
//                emp.setNome_fantasia(cursor.getString(1));
//                emp.setCnpj(cursor.getString(2));
//                emp.setRazao_social(cursor.getString(3));
//                emp.setCep(cursor.getString(4));
//                emp.setUf(cursor.getString(5));
//                emp.setMunicipio(cursor.getString(6));
//
//                adpEmpresas.add(emp);
//                Log.d("teste", cursor.getString(0) + " Nome Fantasia " + cursor.getString(1));
//
//
//            } while(cursor.moveToNext());
//        }
//
//        return adpEmpresas;
//
//
//
//    }
//    public void delete(int id){
//
//    }
//    public void update(int id){
//
//    }
//}
