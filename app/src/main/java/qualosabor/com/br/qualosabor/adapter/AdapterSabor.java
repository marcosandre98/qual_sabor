package qualosabor.com.br.qualosabor.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.models.Sabor;

public class AdapterSabor extends BaseAdapter {

    private final List<Sabor> sabores;

    public AdapterSabor(List<Sabor> sabores, Activity act) {
        this.sabores = sabores;
    }

    @Override
    public int getCount() {
        return sabores.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View rowView = inflater.inflate(R.layout.linha_lista_sabor, parent, false);
//
//        TextView txtNomeSabor = (TextView) rowView.findViewById(R.id.txtNomeSabor);
//        TextView txtIngredientes = (TextView) rowView.findViewById(R.id.txtIngre);
//        TextView txtImagemSabor = (TextView) rowView.findViewById(R.id.txtImagem);
//
//        txtNomeSabor.setText(elementos.get(position).getNomeSabor());
//        txtIngredientes.setText(elementos.get(position).getIngredientes());
////        txtImagemSabor.setText(elementos.get(position).getImagem());
//
//        return rowView;
//    }

}
