package quiniela.tu.acierta.aciertatuquiniela;

import android.app.Activity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by XTO on 18/10/2016.
 */
public class ArrayAdapterResultadosDirecto extends ArrayAdapter<String>
{
    Activity          context;
    ArrayList<String> arrayResultadosPartidosDirecto;
    ArrayList<String> arrayEquipoIzda;
    ArrayList<String> arrayEquipoDcha;
    ArrayList<String> arrayQuiniDIA;
    ArrayList<String> arrayQuiniHORA;
    ArrayList<String> arrayResultadosPartidosDirecto1x2;
    public ArrayAdapterResultadosDirecto(Activity context,ArrayList<String> arrayEquipoIzda,ArrayList<String> arrayEquipoDcha, ArrayList<String> arrayResultadosPartidosDirecto,ArrayList<String> arrayQuiniDIA,ArrayList<String> arrayQuiniHORA)
    {
        super(context, R.layout.layout_adapter_resultados_directo_row, arrayResultadosPartidosDirecto);
        this.arrayEquipoIzda = arrayEquipoIzda;
        this.arrayResultadosPartidosDirecto = arrayResultadosPartidosDirecto;
        this.arrayEquipoDcha = arrayEquipoDcha;
        this.arrayQuiniDIA = arrayQuiniDIA;
        this.arrayQuiniHORA = arrayQuiniHORA;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View rowView = layoutInflater.inflate(R.layout.layout_adapter_resultados_directo_row,null);
        if(arrayEquipoDcha!=null)
        {
            TextView tv = (TextView) rowView.findViewById(R.id.tvTexto);
            try
            {

                String cadena = arrayQuiniDIA.get(position) + " " + arrayQuiniHORA.get(position) + " " + arrayEquipoIzda.get(position) + " - " + arrayEquipoDcha.get(position) + " " + arrayResultadosPartidosDirecto.get(position).replace("---","");
                String cadenaUTF8 = new String(cadena.getBytes(), "UTF-8");
                String encodedText = Html.fromHtml(cadena).toString();
                tv.setText( encodedText );
            }
            catch(Exception e)
            {
                // mostrar el error al usuario o en un log
            }
        }
        return rowView;
    }
}
