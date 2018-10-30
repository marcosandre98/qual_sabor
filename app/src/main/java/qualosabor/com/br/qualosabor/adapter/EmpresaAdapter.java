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

import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.models.Empresa;

public class EmpresaAdapter extends ArrayAdapter<Empresa>{

    private Context context;
    private ArrayList<Empresa> elementos;

    public EmpresaAdapter(@NonNull Context context, ArrayList<Empresa> elementos) {
        super(context, R.layout.linha_lista_empresa, elementos);
        this.context = context;
        this.elementos = elementos;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha_lista_empresa, parent, false);

        TextView txtNomeEmpresa = (TextView) rowView.findViewById(R.id.txtNomeEmpresa);
        TextView txtCodigoEmpresa = (TextView) rowView.findViewById(R.id.txtCodigoEmpresa);
        TextView txtCnpjEmpresa = (TextView) rowView.findViewById(R.id.txtCnpjEmpresa);

        txtNomeEmpresa.setText(elementos.get(position).getRazaoSocial());
//        txtCodigoEmpresa.setText(Integer.toString(elementos.get(position).getId()));
        txtCnpjEmpresa.setText(elementos.get(position).getCnpj());

        return rowView;
    }

}
