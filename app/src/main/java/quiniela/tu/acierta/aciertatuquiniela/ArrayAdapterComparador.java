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
public class ArrayAdapterComparador extends ArrayAdapter<String>
{
    Activity          context;
    ArrayList<String> arrayQuiniPERC1;
    ArrayList<String> arrayQuiniPERCx;
    ArrayList<String> arrayQuiniPERC2;
    ArrayList<String> arrayQuiniHIST1;
    ArrayList<String> arrayQuiniHISTx;
    ArrayList<String> arrayQuiniHIST2;
    ArrayList<String> arrayQuini15A;
    ArrayList<String> arrayQuini15B;
    ArrayList<String> arrayUsersVotedUno;
    ArrayList<String> arrayUsersVotedEquis;
    ArrayList<String> arrayUsersVotedDos;
    public ArrayAdapterComparador(Activity context,
                                          ArrayList<String> arrayQuiniPERC1,
                                          ArrayList<String> arrayQuiniPERCx,
                                          ArrayList<String> arrayQuiniPERC2,
                                          ArrayList<String> arrayQuiniHIST1,
                                          ArrayList<String> arrayQuiniHISTx,
                                          ArrayList<String> arrayQuiniHIST2,
                                          ArrayList<String> arrayQuini15A,
                                          ArrayList<String> arrayQuini15B,
                                          ArrayList<String> arrayUsersVotedUno,
                                          ArrayList<String> arrayUsersVotedEquis,
                                          ArrayList<String> arrayUsersVotedDos)

    {
        super(context, R.layout.layout_adapter_resultados_directo_row, arrayQuiniPERC1);
        this.arrayQuiniPERC1 = arrayQuiniPERC1;
        this.arrayQuiniPERCx = arrayQuiniPERCx;
        this.arrayQuiniPERC2 = arrayQuiniPERC2;
        this.arrayQuiniHIST1 = arrayQuiniHIST1;
        this.arrayQuiniHISTx = arrayQuiniHISTx;
        this.arrayQuiniHIST2 = arrayQuiniHIST2;
        this.arrayQuini15A   = arrayQuini15A  ;
        this.arrayQuini15B   = arrayQuini15B  ;
        this.arrayUsersVotedUno     = arrayUsersVotedUno;
        this.arrayUsersVotedEquis = arrayUsersVotedEquis;
        this.arrayUsersVotedDos     = arrayUsersVotedDos;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
//        System.out.println("GetViewPosition:" + position);
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View rowView;
        if(position==0)
        {

            rowView = layoutInflater.inflate(R.layout.layout_adapter_quinielista_vs_quinicombigana_cabecera,null);
        }
        else
        {
            rowView = layoutInflater.inflate(R.layout.layout_adapter_quinielista_vs_quinicombigana,null);
        }

        if(arrayQuiniPERC1!=null)
        {
            TextView tv0 = (TextView) rowView.findViewById(R.id.tv0);
            TextView tv1 = (TextView) rowView.findViewById(R.id.tv1);
            TextView tv2 = (TextView) rowView.findViewById(R.id.tv2);
            TextView tv3 = (TextView) rowView.findViewById(R.id.tv3);
            TextView tv4 = (TextView) rowView.findViewById(R.id.tv4);
            TextView tv5 = (TextView) rowView.findViewById(R.id.tv5);
            TextView tv6 = (TextView) rowView.findViewById(R.id.tv6);
            TextView tv7 = (TextView) rowView.findViewById(R.id.tv7);
            TextView tv8 = (TextView) rowView.findViewById(R.id.tv8);
            TextView tv9 = (TextView) rowView.findViewById(R.id.tv9);
            try
            {
//                String cadena = arrayQuiniDIA.get(position) + " " + arrayQuiniHORA.get(position) + " " + arrayEquipoIzda.get(position) + " - " + arrayEquipoDcha.get(position) + " " + arrayResultadosPartidosDirecto.get(position).replace("---","");
//                String cadenaUTF8 = new String(cadena.getBytes(), "UTF-8");
//                String encodedText = Html.fromHtml(cadena).toString();
//                tv.setText( encodedText );
                tv0.setText(""+(position+1 ));
                tv1.setText(""+arrayQuiniPERC1.get(position));
                tv2.setText(""+arrayQuiniPERCx.get(position));
                tv3.setText(""+arrayQuiniPERC2.get(position));
                tv4.setText(""+arrayQuiniHIST1.get(position));
                tv5.setText(""+arrayQuiniHISTx.get(position));
                tv6.setText(""+arrayQuiniHIST2.get(position));
                tv7.setText(""+arrayUsersVotedUno  .get(position));
                tv8.setText(""+arrayUsersVotedEquis.get(position));
                tv9.setText(""+arrayUsersVotedDos  .get(position));
            }
            catch(Exception e)
            {
                // mostrar el error al usuario o en un log
                e.printStackTrace();
            }
        }
        return rowView;
    }
}
