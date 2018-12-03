package qualosabor.com.br.qualosabor.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.models.Empresa;
import qualosabor.com.br.qualosabor.models.Sabor;

public class SaborAdapter extends ArrayAdapter<Sabor>{

    private Context context;
    private List<Sabor> elementos;

    public SaborAdapter(@NonNull Context context, List<Sabor> elementos) {
        super(context, R.layout.linha_lista_sabor, elementos);
        this.context = context;
        this.elementos = elementos;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha_lista_sabor, parent, false);

        TextView txtNomeSabor = (TextView) rowView.findViewById(R.id.txtNomeSabor);
        TextView txtIngredientes = (TextView) rowView.findViewById(R.id.txtIngre);
        TextView txtImagemSabor = (TextView) rowView.findViewById(R.id.txtImagem);

        txtNomeSabor.setText(elementos.get(position).getNomeSabor());
        txtIngredientes.setText(elementos.get(position).getIngredientes());
//        txtImagemSabor.setText(elementos.get(position).getImagem());

        return rowView;
    }

}
