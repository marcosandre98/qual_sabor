package qualosabor.com.br.qualosabor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import qualosabor.com.br.qualosabor.R;
import qualosabor.com.br.qualosabor.models.Cliente;
import qualosabor.com.br.qualosabor.models.CodigoVerificacao;
import qualosabor.com.br.qualosabor.models.Pedido;
import qualosabor.com.br.qualosabor.models.Sabor;

public class PedidoAdapter extends ArrayAdapter<Pedido>{

    private final Context context;
    private final ArrayList<Pedido> elementos;

    public PedidoAdapter(Context context, ArrayList<Pedido> elementos) {
        super(context, R.layout.linha_lista_pedido, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha_lista_pedido, parent, false);

        TextView txtMesa = (TextView) rowView.findViewById(R.id.txtMesaLista);
        TextView txtNomeSabor = (TextView) rowView.findViewById(R.id.txtSaborListaPedido);
        TextView txtNomeCliente = (TextView) rowView.findViewById(R.id.txtClienteListaPedido);

        Cliente cliente = Cliente.findById(Cliente.class, Long.valueOf(elementos.get(position).getIdCliente()));
        Sabor sabor = Sabor.findById(Sabor.class, Long.valueOf(elementos.get(position).getIdSabor()));

        txtMesa.setText("Mesa: " + elementos.get(position).getNumeroMesa().toString());
        //txtNomeSabor.setText("Sabor: " + sabor.getNomeSabor());
        txtNomeCliente.setText("Cliente: " + cliente.getNomeCliente());

        return rowView;
    }

}