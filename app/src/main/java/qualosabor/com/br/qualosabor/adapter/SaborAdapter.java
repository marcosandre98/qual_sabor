package qualosabor.com.br.qualosabor.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.models.Empresa;
import qualosabor.com.br.qualosabor.models.Sabor;

public class SaborAdapter extends ArrayAdapter<Sabor>{

    private final Context context;
    private final ArrayList<Sabor> elementos;

    public SaborAdapter(Context context, ArrayList<Sabor> elementos) {
        super(context, R.layout.linha_lista_sabor, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha_lista_sabor, parent, false);

        TextView txtNomeSabor = (TextView) rowView.findViewById(R.id.txtSaborLista);
        TextView txtIngredientes = (TextView) rowView.findViewById(R.id.txtIngredientesLista);
        ImageView imagemSabor = (ImageView) rowView.findViewById(R.id.imagemPizza);

        txtNomeSabor.setText(elementos.get(position).getNomeSabor());
        txtIngredientes.setText(elementos.get(position).getIngredientes());
//        imagemSabor.setImageResource(elementos.get(position).getImagem());

        return rowView;
    }

}
