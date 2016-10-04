package quiniela.tu.estudia.estudiatuquiniela;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;


@Deprecated
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    int tester = 0;
    public TextView tvResultado;
    private ProgressDialog dialog;
    //arrays_variables_expertos
    boolean startExpertStats = false;
    //Quinielista:
    ArrayList<String> arrayQuiniDIA;
    ArrayList<String> arrayQuiniHORA;
    ArrayList<String> arrayQuiniPERC1;
    ArrayList<String> arrayQuiniPERCx;
    ArrayList<String> arrayQuiniPERC2;
    ArrayList<String> arrayQuiniHIST1;
    ArrayList<String> arrayQuiniHISTx;
    ArrayList<String> arrayQuiniHIST2;
    ArrayList<String> arrayQuini15A;
    ArrayList<String> arrayQuini15B;

    ArrayList<String> arrayEquipoIzda;
    ArrayList<String> arrayEquipoDcha;
    ArrayList<String> arrayExpertsVoted;
    ArrayList<String> arrayExpertsExplain;
    ArrayList<String> arrayResultMatchRealTime;
    ArrayList<String> arrayResultMatchRealTime1x2;
    ArrayList<String> arrayUsersVotedUno;
    ArrayList<String> arrayUsersVotedEquis;
    ArrayList<String> arrayUsersVotedDos;
    ArrayList<String> arrayUsersVotedHighLightType;
    ArrayList<String> arrayUsersVotedHighLightPercent;
    ArrayList<String> arrayUsersQuinceA;
    ArrayList<String> arrayUsersQuinceB;
    //arrays_variables_expertos//
    /////////////////////////////
    //arrays_variables_usuarios
    boolean startUserStats = false;
    boolean startCurrentResultSearch = false;
    String totalVotos = "";
    int userVoted = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        dialog = new ProgressDialog(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if(checkNetworkConnection())
        {
            /*
            WebView     webView     = (WebView) findViewById(R.id.webView);
            String      url         = "https://static.dataradar.es/marcador/Marcador_QUINI_lite.html";
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.loadUrl(url);
            WebView     webView2     = (WebView) findViewById(R.id.webView2);
            String      url2         = "https://www.quinielista.es/enVivo/index.asp";
            WebSettings webSettings2 = webView2.getSettings();
            webSettings.setJavaScriptEnabled(true);
            */
//            webView.loadUrl(url2);
            Toast.makeText(this,"Hay conexión a internet",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"No hay conexión a internet",Toast.LENGTH_LONG).show();
        }
        tvResultado = (TextView)  findViewById(R.id.tvResultados);
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        } else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_1)
        {
            if(true)
            {
//                String urlString = "http://quiniela.combinacionganadora.com/";


                Toast.makeText(this,"2",Toast.LENGTH_SHORT).show();
                //Quinielista
                arrayQuiniDIA   = new ArrayList<String>();
                arrayQuiniHORA  = new ArrayList<String>();
                arrayQuiniPERC1 = new ArrayList<String>();
                arrayQuiniPERCx = new ArrayList<String>();
                arrayQuiniPERC2 = new ArrayList<String>();
                arrayQuiniHIST1 = new ArrayList<String>();
                arrayQuiniHISTx = new ArrayList<String>();
                arrayQuiniHIST2 = new ArrayList<String>();
                arrayQuini15A   = new ArrayList<String>();
                arrayQuini15B   = new ArrayList<String>();
                ConsultarQuinielista ConsultarQuinielista = new ConsultarQuinielista();
                ConsultarQuinielista.doInBackground("");
                ConsultarQuinielista.onPostExecute("");



            }
            /*else
            {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Fail:");
                alertDialog.setMessage("No internet connection");

                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
            }*/
        }
        else if (id == R.id.nav_2)
        {
            arrayEquipoIzda = new ArrayList<String>();
            arrayEquipoDcha = new ArrayList<String>();
            arrayExpertsVoted = new ArrayList<String>();
            arrayExpertsExplain = new ArrayList<String>();
            arrayResultMatchRealTime = new ArrayList<String>();
            arrayResultMatchRealTime1x2 = new ArrayList<String>();
            arrayUsersVotedUno = new ArrayList<String>();
            arrayUsersVotedEquis = new ArrayList<String>();
            arrayUsersVotedDos = new ArrayList<String>();
            arrayUsersVotedHighLightType = new ArrayList<String>();
            arrayUsersVotedHighLightPercent = new ArrayList<String>();
            arrayUsersQuinceA = new ArrayList<String>();
            arrayUsersQuinceB = new ArrayList<String>();//

            ConsultarQuiniCombiGanadora consultarQuiniCombiGanadora = new ConsultarQuiniCombiGanadora();
            consultarQuiniCombiGanadora.doInBackground("");
            consultarQuiniCombiGanadora.onPostExecute("");
            if(!dialog.isShowing())
            {
                dialog.setMessage("Obteniendo datos de la jornada.");
                dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                dialog.setIndeterminate(false);
                dialog.setCancelable(false);
                dialog.setMax(100);
                dialog.setProgress(10);
                dialog.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        dialog.dismiss();
                    }
                }, 1200);
            }

        }
        else if (id == R.id.nav_3)
        {
            Toast.makeText(this,"3",Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.nav_4)
        {
            Toast.makeText(this,"4",Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private class ConsultarQuinielista extends AsyncTask<String, Integer, String>
    {
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values)
        {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(String... params)
        {
            try
            {
                int lineCounter = 0;
                String urlString = "https://www.quinielista.es/";
                URL url = new URL(urlString);
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                String line;
                boolean buscandoRes15 = false;

                while ((line = in.readLine()) != null)
                {
                    if(line.contains("tablaPorc15JugadosBoletoHome"))
                    {
                        buscandoRes15 = true;
                    }
                    if(buscandoRes15 && line.contains("<!-- %goles -->"))
                    {
                        buscandoRes15 = false;
                        break;
                    }
                    //System.out.println("Linea: " + lineCounter + " " + line);
                    lineCounter++;
                    if(line.contains("<!--")&&!buscandoRes15)
                    {
                        if(line.contains("DIA")||line.contains("HORA")||line.contains("%1")||line.contains("%X")||line.contains("%2")||line.contains("1 -->")||line.contains("X -->")||line.contains("2 -->"))
                        {
                            String lineaTrimmed = line
                            .replace("<td class=\"cell value left\">","")
                            .replace("<td class=\"cell value\">","")
                            .replace("</td>","")
                            .replace("<!-- DIA -->","")
                                    .replace("<!-- HORA -->","")
                                    .replace("<!-- %2 -->","")
                                    .replace("<!-- %1 -->","")
                                    .replace("<!-- %X -->","")
                                    .replace("<!-- 42 -->","")
                                    .replace("<!-- 1 -->","")
                                    .replace("<!--30-->","")
                                    .replace("<!--28-->","")
                                    .replace("<!-- 2 -->","")
                                    .replace("<!--","")
                                    .replace("-->","")
                                    .replace("<!--","")
                                    .trim();

                            System.out.println();
                            System.out.println("Linea: " + lineCounter + " " + lineaTrimmed);
                            if(line.contains("DIA"))
                            {
                                arrayQuiniDIA.add(lineaTrimmed);
                            }
                            else if(line.contains("HORA"))
                            {
                                arrayQuiniHORA.add(lineaTrimmed);
                            }
                            else if(line.contains("%1"))
                            {
                                arrayQuiniPERC1.add(lineaTrimmed);
                            }
                            else if(line.contains("%X"))
                            {
                                arrayQuiniPERCx.add(lineaTrimmed);
                            }
                            else if(line.contains("%2"))
                            {
                                arrayQuiniPERC2.add(lineaTrimmed);
                            }
                            //Historico
                            else if(line.contains("1 -->"))
                            {
                                arrayQuiniHIST1.add(lineaTrimmed);
                            }
                            else if(line.contains("X -->"))
                            {
                                arrayQuiniHISTx.add(lineaTrimmed);
                            }
                            else if(line.contains("2 -->"))
                            {
                                arrayQuiniHIST2.add(lineaTrimmed);
                            }
                        }

                        if(line.contains("ult"))
                        {
                            if(line.contains("1"))
                            {

                            }
                            else if(line.contains("2"))
                            {

                            }
                            else if(line.contains("X"))
                            {

                            }
                        }
                    }
                    else if(buscandoRes15)
                    {
                        if(line.contains("<td>"))
                        {
                            String trimmedLine = line.trim()
                            .replace( "<td>","")
                            .replace("</td>","");
                            if(arrayQuini15A.size()==4)
                            {
                                arrayQuini15B.add(trimmedLine);
                            }
                            else
                            {
                                arrayQuini15A.add(trimmedLine);
                            }
                        }

                    }
                }//While line
            }
            catch (Exception e)
            {e.printStackTrace();}


            return null;
        }

        @Override
        protected void onPostExecute(String paramString)
        {
            super.onPostExecute(paramString);
            StringBuilder sb = new StringBuilder();
            for(int index = 0;index<arrayQuiniDIA.size();index++)
            {
                sb.append(
                        (index+1)+": "+
                                "Dia:  "  + arrayQuiniDIA.get(index) + " "+
                                "Hora: " + arrayQuiniHORA.get(index)+ " "
                );
                sb.append("\n");
            }
            sb.append("\n");
            sb.append("\n");

            for(int index = 0;index<arrayQuiniDIA.size()-1;index++)
            {
                sb.append(
                        (index+1)+": "+
                                " %1 : " + arrayQuiniPERC1.get(index)+ " "+
                                " %x : " + arrayQuiniPERCx.get(index)+ " "+
                                " %2 : " + arrayQuiniPERC2.get(index)+ " "+
                                " H1 : " + arrayQuiniHIST1.get(index)+ " "+
                                " Hx : " + arrayQuiniHISTx.get(index)+ " "+
                                " H2 : " + arrayQuiniHIST2.get(index)
                );
                sb.append("\n");
            }
            sb.append("\n");
            sb.append("15: ");
            for(String s:arrayQuini15A)
            {
                sb.append(
                        arrayQuini15A.get(s.indexOf(s)) + " "
                );
            }
            sb.append("\n");
            sb.append("15: ");
            for(String s:arrayQuini15B)
            {
                sb.append(
                        arrayQuini15B.get(s.indexOf(s)) + " "
                );
            }
            //
            int test = 2;
            tvResultado.setText(sb.toString());
            System.out.println(test);
        }
    }
    private class ConsultarQuiniCombiGanadora extends AsyncTask<String, Integer, String>
    {
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                }
            }, 2000);
        }

        @Override
        protected void onProgressUpdate(Integer... progress)
        {
            //super.onProgressUpdate(progress[0]);
            dialog.setProgress(progress[0]);

        }

        @Override
        protected String doInBackground(String... urls)
        {
            String response = "";
            //arrays_variables_usuarios
            try
            {
                double mayorA = 0;
                double mayorB = 0;
                int iniA = 0;
                int finB = 0;
                int indexA = 0;
                int indexB = 0;

                int lineCounter = 0;
                String urlString = "http://quiniela.combinacionganadora.com/";
                URL url = new URL(urlString);
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                String line;
                String fistLineExplanation = "";
                boolean thereIsSecondLineSpecified = false;
                System.out.println("---- ---- ---- ---- ----");
                publishProgress(3);
                while ((line = in.readLine()) != null)
                {
                    lineCounter++;
                    //
                    //              EXPERT STATS
                    //
                    if(line.contains("Nuestro pron")&&line.contains("jornada")&&line.contains("es el siguiente"))
                    {
                        startExpertStats = true;
                        System.out.println("Recogiendo sugerencias de los expertos: " + lineCounter);
                    }
                    if(startExpertStats)
                    {
                        publishProgress(5);
                        if(line.contains("<p><strong")&&line.contains("</strong>"))
                        {
                            int split = 80;
                            if(split>=line.length()) split = line.length()-1;
                            String first80char = line.substring(0,split);
                            String spaceLessLine = first80char.replace(" ","");
                            String taglessLine = spaceLessLine
                                    .replace("<br/>","")
                                    .replace("<br />","")
                                    .replace("<p><strong","");
                            int b = taglessLine.indexOf("</strong");
                            String result = "";
                            if(line.contains("strong>15"))
                            {
                                for (int i = 1; i<13 ; i++)
                                {
                                    String currentResultChar = taglessLine.substring(b-i,b-(i-1));
                                    if(currentResultChar.equals("M")||currentResultChar.equals("/")||currentResultChar.equals("-")||currentResultChar.equals("0")||currentResultChar.equals("1")||currentResultChar.equals("2"))
                                    {
                                        result = currentResultChar + result;
                                    }
                                }
                            }
                            else
                            {
                                for (int i = 1; i<3 ; i++)
                                {
                                    String currentResultChar = taglessLine.substring(b-i,b-(i-1));
                                    if(currentResultChar.equals("1")||currentResultChar.equals("X")||currentResultChar.equals("2"))
                                    {
                                        result = currentResultChar + result;
                                    }
                                }
                            }
                            arrayExpertsVoted.add(result);
                            thereIsSecondLineSpecified = false;
                            fistLineExplanation="";
                        }
                        else
                        {
                            if(!line.contains("strong")&&!line.contains("uestro")&&!line.contains("Según")&&!line.contains("clear"))
                            {
                                //MotivesVotationExperts:array:
                                String trimCleanedString = line
                                        .replaceAll("&nbsp;","");
                                int a = trimCleanedString.indexOf("<br />")+"<br />".length()-2;
                                int z = trimCleanedString.indexOf("</p>");
                                if(a>-1&&z>-1)
                                {
                                    String explanation = trimCleanedString.substring(a,z-("</p>".length()-1));
                                    if( (thereIsSecondLineSpecified) && !(fistLineExplanation.equals("")) )
                                    {
                                        String objeto = arrayExpertsExplain.get(arrayExpertsExplain.size()-1);
                                        String concat = objeto + "\\n" + explanation;
                                        arrayExpertsExplain.remove(objeto);
                                        arrayExpertsExplain.add(concat);
                                    }
                                    else
                                    {
                                        arrayExpertsExplain.add(explanation);
                                    }
                                    fistLineExplanation = explanation;
                                    thereIsSecondLineSpecified = true;
                                }
                            }
                        }
                        if (line.contains("ctrlHeadedBox_header styleTitle color3 ctrlTypo3") )
                        {
                            startExpertStats = false;
                            startCurrentResultSearch = true;
                        }
                    }

                    //
                    ////////////////////////////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////////
                    // //Current results search:
                    if(line.contains("ctrlHeadedBox_header styleTitle color3 ctrlTypo"))
                    {
                        int a = arrayResultMatchRealTime1x2.size();
                        int b = arrayResultMatchRealTime.size();
                        int c = arrayExpertsExplain.size();
                        startCurrentResultSearch = true;
                    }
                    if(startCurrentResultSearch)
                    {
                        if(line.contains("ctrlIcons openButton"))
                        {
                            tester++;
                            System.out.println("Counter " + tester);
                            int a = line.indexOf("title=\"")+"title=\"".length();
                            String aux = line.substring(a);
                            aux = aux.replace("\"","")
                                     .replace("target=_blank></a>","")
                                     .trim();
                            System.out.println("Line:" + line);
                            int posHiphen = aux.indexOf("-");
                            String team1 = aux.substring(0,posHiphen);
                            String team2 = aux.substring(team1.length()+1);
                            arrayEquipoIzda.add(team1);
                            //String team2 = line.substring(a,b);
                            arrayEquipoDcha.add(team2);
                        }
                        if(!line.contains("col3a"))
                        {
                            if((line.contains("col3")||line.contains("col5"))&&line.contains("span")&&!line.contains("%")&&!line.contains("<td class=\"col5\">1</td>")&&!line.contains("<td class=\"col3\">-</td>"))
                            {
                                String trimLine = line.replace("</span></td>","").trim();
                                String result = trimLine.substring(trimLine.length()-1,trimLine.length());

                                if(line.contains("col5"))
                                {
                                    String object = arrayResultMatchRealTime.get(arrayResultMatchRealTime.size()-1);
                                    result = object+"-"+result;
                                    arrayResultMatchRealTime.remove(object);
                                }
                                if(!result.equals(">"))
                                {
                                    //System.out.println("matchLines: " + line);
                                    arrayResultMatchRealTime.add(result);
                                    if(result.length()>2)
                                    {
                                        if(!result.contains("---"))
                                        {
                                            int golesE1 = Integer.valueOf(result.substring(0,1));
                                            int golesE2 = Integer.valueOf(result.substring(2,3));

                                            if(golesE1>golesE2)
                                            {
                                                arrayResultMatchRealTime1x2.add("1");
                                            }
                                            else if(golesE2>golesE1)
                                            {
                                                arrayResultMatchRealTime1x2.add("2");
                                            }
                                            else
                                            {
                                                arrayResultMatchRealTime1x2.add("X");
                                            }
                                        }
                                        else
                                        {
                                            arrayResultMatchRealTime1x2.add("[ ]");
                                        }

                                    }

                                }
                                if(line.contains("ctrlHeadedBox_preFooter styleCenter black"))
                                {
                                    startCurrentResultSearch=false;
                                }
                            }
                        }

                    }
                    //
                    ////////////////////////////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////////
                    ////////////////////////////////////////////////////////////////////////////////////
                    //
                    //USER STATS:
                    if(line.contains("usersSoccerRank optSelectable"))
                    {
                        startUserStats = true;
                        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                        System.out.println("Busqueda de pronóticos personales jugados:");
                    }
                    if(startUserStats)
                    {
                        publishProgress(20);
                        String lineEdited = line.trim()
                                .replaceAll("highLight","")
                                .replaceAll(" highLight","")
                                .replaceAll("</td>","<")
                                .replaceAll("<td","")
                                .replaceAll(" class=","")
                                .replaceAll("%","")
                                .replaceAll("\"","")
                                .replaceAll(" ","")
                                .replaceAll("\u00A0","")
                                .replaceAll("\u0020","")
                                .replaceAll("\u2007","")
                                .replaceAll("\\\\u0020","")
                                .replaceAll("\\\\u2007","")
                                .replaceAll("\\\\u00A0","")
                                .replaceAll("\\s+","");
                        try
                        {
                            if(line.contains("col5")) //EN ESTA PARTE DEL CÓDIGO...
                            {
                                String help = lineEdited.replace("col5","");
                                int a = help.indexOf(">");
                                int b = help.indexOf("<");
                                a++;
                                String usersVotedUno = "";
                                if(a>=0&&b>=0&&b>a)
                                {
                                    usersVotedUno = help.substring(a, b);
                                    if (!usersVotedUno.equals("1") && usersVotedUno!="")
                                    {
                                        arrayUsersVotedUno.add(usersVotedUno);
                                        if (line.contains("highLigh"))
                                        {
                                            if (!usersVotedUno.equals(""))
                                            {
                                                System.out.println("Recogiendo pronósticos personales 1 : " + lineCounter);
                                                arrayUsersVotedHighLightType.add("1");
                                                arrayUsersVotedHighLightPercent.add(usersVotedUno);
                                            }
                                        }

                                    }

                                }
                                else
                                {
                                    usersVotedUno = "0";
                                    arrayUsersVotedUno.add(usersVotedUno);
                                }
                            }
                            else if(line.contains("col6"))
                            {
                                String help = lineEdited.replace("col6","");
                                int a = help.indexOf(">");
                                int b = help.indexOf("<");
                                a++;
                                String usersVotedEquis = "";
                                if(a>=0&&b>=0&&b>a)
                                {
                                    usersVotedEquis = help.substring(a, b);
                                    if (!usersVotedEquis.equals("X") && !arrayUsersVotedEquis.equals(""))
                                    {
                                        arrayUsersVotedEquis.add(usersVotedEquis);
                                        if (line.contains("highLigh"))
                                        {
                                            if (!usersVotedEquis.equals("")) {
                                                System.out.println("Recogiendo pronósticos personales X " + lineCounter);
                                                arrayUsersVotedHighLightType.add("X");
                                            }
                                            if (!usersVotedEquis.equals(""))
                                                arrayUsersVotedHighLightPercent.add(usersVotedEquis);
                                        }
                                    }
                                }
                                else
                                {
                                    usersVotedEquis = "0";
                                    arrayUsersVotedEquis.add(usersVotedEquis);
                                }
                            }
                            else if(line.contains("col7")) {
                                String help = lineEdited.replace("col7", "");
                                int a = help.indexOf(">");
                                int b = help.indexOf("<");
                                a++;
                                String usersVotedDos = "";
                                if (a >= 0 && b >= 0 && b > a)
                                {
                                    usersVotedDos = help.substring(a, b);
                                    if (!usersVotedDos.equals("2") && !usersVotedDos.equals(""))
                                    {
                                        arrayUsersVotedDos.add(usersVotedDos);
                                        if (line.contains("highLigh"))
                                        {
                                            if (!usersVotedDos.equals(""))
                                            {
                                                System.out.println("Recogiendo pronósticos personales 2 " + lineCounter);
                                                arrayUsersVotedHighLightType.add("2");
                                            }
                                            if (!usersVotedDos.equals("")) arrayUsersVotedHighLightPercent.add(usersVotedDos);
                                        }
                                    }
                                }
                                else
                                {
                                    usersVotedDos = "0";
                                    arrayUsersVotedDos.add(usersVotedDos);
                                }
                            }
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                        //Busqueda partido 15:
                        //System.out.println("Recogiendo pronósticos personales Partido 15 " + lineCounter);

                        if(arrayUsersVotedDos.size()>13)
                        {
                            publishProgress(30);
                            String linePartido15 = line.replace("  "," ").replace(" highLight","").replace("highLight","");
                            if( linePartido15.contains("div class") && linePartido15.contains("%") )
                            {
                                System.out.println("Encontrados resultados partido 15: " + lineCounter);
                                int posA = linePartido15.indexOf(">")+1;
                                int posZ = linePartido15.indexOf("%");
                                String valuePartido15 = linePartido15.substring(posA,posZ);
                                double valuePartido15Double = Double.parseDouble(linePartido15.substring(posA,posZ));
                                if(arrayUsersQuinceA.size()<=3)
                                {
                                    System.out.println("Partido 15 E1: " + valuePartido15);
                                    arrayUsersQuinceA.add(valuePartido15);
                                    if((int)valuePartido15Double>(int)mayorA)
                                    {
                                        mayorA = valuePartido15Double;
                                        iniA = indexA;
                                    }
                                    indexA++;
                                }
                                else
                                {
                                    if(arrayUsersQuinceB.size()<=3)
                                    {
                                        System.out.println("Partido 15 E2" + valuePartido15);
                                        arrayUsersQuinceB.add(valuePartido15);
                                        if((int)valuePartido15Double>(int)mayorB)
                                        {
                                            mayorB = valuePartido15Double;
                                            finB = indexB;
                                        }
                                        indexB++;
                                    }
                                }
                                if(arrayUsersQuinceA.size()==4 && arrayUsersQuinceB.size()==4)
                                {
                                    arrayUsersVotedHighLightPercent.add(arrayUsersQuinceA.get(iniA)+"-"+arrayUsersQuinceB.get(finB));

                                    String result15 = "";

                                    if(iniA==3)
                                    {
                                        result15 = "-" +"M";
                                    }
                                    else result15 = String.valueOf(iniA);

                                    if(finB==3)
                                    {
                                        result15 = result15 + "-" + "M";
                                    }
                                    else result15 = result15 + "-" + String.valueOf(finB);
                                    if(iniA>finB)
                                    {
                                        result15 = result15 + "=1";
                                    }
                                    else if(finB>iniA)
                                    {
                                        result15 = result15 + "=2";
                                    }
                                    else
                                    {
                                        result15 = result15 + "=X";
                                    }
                                    arrayUsersVotedHighLightType.add(result15);

                                }
                            }
                        }
                        //Fin busqueda partido 15 jugadors:
                        if(line.contains("dev_quinielaReaders_total"))
                        {
                            publishProgress(50);
                            int a = line.indexOf("quinielaReaders_total\">") + "quinielaReaders_total\">".length();
                            int b = line.indexOf("</span>");
                            if(a>=0&&b>=0&&b>a)
                            {
                                totalVotos = line.substring(a,b);
                            }
                            else
                            {
                                totalVotos = "0";
                            }
                            startUserStats = false;
                        }
                    }
                    //System.out.println("Linea:" + lineCounter + " |" + line);
                }
                System.out.println("Total de usuarios que votaron: " + totalVotos + "Line: " + lineCounter);

                in.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
                dialog.dismiss();
            }
            try
            {
                int index = 1;
                System.out.println("ARRAYS 1x2 usersSoccerRank: size: " +arrayUsersVotedUno.size());
                if(arrayUsersVotedUno.size()>0)
                {
                    for(String s: arrayUsersVotedUno)
                    {
                        System.out.print(index+" " + arrayUsersVotedUno.get(index-1));
                        System.out.print(" " + arrayUsersVotedEquis.get(index-1));
                        System.out.println(" " + arrayUsersVotedDos.get(index-1) + "");
                        index++;
                    }
                }
                publishProgress(60);
                System.out.println("1 arrayUsersVotedHighLightType partido 15 size: " + arrayUsersVotedHighLightType.size());
                if(arrayUsersVotedHighLightType.size()>0)
                    for (String s: arrayUsersVotedHighLightType)
                    {
                        System.out.println("1 arrayUsersVotedHighLightType partido 15: " + s);
                    }
                System.out.println("2 arrayUsersVotedHighLightPercent partido 15 size: " + arrayUsersVotedHighLightPercent.size());
                if(arrayUsersVotedHighLightPercent.size()>0)
                    for (String s: arrayUsersVotedHighLightPercent)
                    {
                        System.out.println("2 arrayUsersVotedHighLightPercent partido 15: " + s);
                    }
                publishProgress(70);
                System.out.println("3 arrayUsersQuinceA partido 15 size: " + arrayUsersQuinceA.size());
                if(arrayUsersQuinceA.size()>0)
                    for (String s: arrayUsersQuinceA)
                    {
                        System.out.println("3 arrayUsersQuinceA partido 15: " + s);
                    }
                System.out.println("4 arrayUsersQuinceB partido 15 size: " + arrayUsersQuinceB.size());
                if(arrayUsersQuinceB.size()>0)
                    for (String s: arrayUsersQuinceB)
                    {
                        System.out.println("4 arrayUsersQuinceB partido 15: " + s);
                    }
                publishProgress(80);
                System.out.println("ARRAYS 1x2 EXPERTS votes: size: " + arrayExpertsVoted.size());
                index = 1;
                if(arrayExpertsVoted.size()>0)
                {
                    for(String s: arrayExpertsVoted)
                    {
                        System.out.println(index+" " + arrayExpertsVoted.get(index-1));
                        index++;
                    }
                }
                index = 1;
                publishProgress(90);
                System.out.println("ARRAYS 1x2 EXPERTS motives: size:" + arrayExpertsExplain.size());
                if(arrayExpertsExplain.size()>0)
                {
                    for(String s: arrayExpertsExplain)
                    {
                        System.out.println(index+" " + arrayExpertsExplain.get(index-1));
                        index++;
                    }
                }
                index = 0;
                System.out.println("ARRAYS CURRENT RESULT: size: " + arrayResultMatchRealTime.size());
                if(arrayResultMatchRealTime.size()>0)
                {
                    for(String s: arrayResultMatchRealTime)
                    {
                        System.out.println(index+" " +arrayEquipoIzda.get(index)+"-"+arrayEquipoDcha.get(index)+" "+ arrayResultMatchRealTime.get(index));
                        index++;
                    }
                }
                publishProgress(100);
                if (dialog.isShowing())
                {
                    dialog.dismiss();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                dialog.dismiss();
            }
            return response;
        }

        @Override
        protected void onPostExecute(String result)
        {
            StringBuilder stringBuilder = new StringBuilder();
            //stringBuilder.append("\n");
            //stringBuilder.append("arrayResultMatchRealTime" + arrayResultMatchRealTime.toString());
            try
            {
                int index = 1;
                stringBuilder.append("ARRAYS CURRENT RESULT: size: " + arrayResultMatchRealTime.size());
                stringBuilder.append("\n");
                if(arrayResultMatchRealTime.size()>0)
                {
                    System.out.println("Size arrayEquipoIzda: " + arrayEquipoIzda.size());
                    System.out.println("Size arrayResultMatchRealTime1x2: " + arrayResultMatchRealTime1x2.size());
                    System.out.println("Size arrayResultMatchRealTime " + arrayResultMatchRealTime.size());
                    System.out.println("Size arrayEquipoDcha: " + arrayEquipoDcha.size());
                    for(String s: arrayResultMatchRealTime)
                    {

                        stringBuilder.append(index+" " +arrayEquipoIzda.get(index-1)+"-"+arrayEquipoDcha.get(index-1)+" "+ arrayResultMatchRealTime.get(index-1) + " = " + arrayResultMatchRealTime1x2.get(index-1));
                        index++;
                        stringBuilder.append("\n");
                    }
                }
                 index = 1;
                stringBuilder.append("ARRAYS 1x2 \nusersSoccerRank: \nsize: " +arrayUsersVotedUno.size());
                stringBuilder.append("\n");
                if(arrayUsersVotedUno.size()>0)
                {
                    for(String s: arrayUsersVotedUno)
                    {
                        stringBuilder.append(index+" " + arrayUsersVotedUno.get(index-1));
                        stringBuilder.append(" " + arrayUsersVotedEquis.get(index-1));
                        stringBuilder.append(" " + arrayUsersVotedDos.get(index-1) + "");
                        stringBuilder.append("\n");
                        index++;
                    }
                }
                stringBuilder.append("arrayUsersVotedHighLightType\n size: " + arrayUsersVotedHighLightType.size());
                if(arrayUsersVotedHighLightType.size()>0)
                    for (String s: arrayUsersVotedHighLightType)
                    {
                        stringBuilder.append(s);
                        stringBuilder.append("\n");
                    }
                stringBuilder.append("\n");
                stringBuilder.append("arrayUsersVotedHighLightPercent\n  size: " + arrayUsersVotedHighLightPercent.size());
                stringBuilder.append("\n");
                index = 1;
                if(arrayUsersVotedHighLightPercent.size()>0)
                    for (String s: arrayUsersVotedHighLightPercent)
                    {
                        stringBuilder.append((index ++)+s);
                        stringBuilder.append("\n");
                    }
                index = 0;
                stringBuilder.append("\n");
                stringBuilder.append("arrayUsersQuinceA\n size: " + arrayUsersQuinceA.size());
                stringBuilder.append("\n");
                if(arrayUsersQuinceA.size()>0)
                    for (String s: arrayUsersQuinceA)
                    {
                        stringBuilder.append(s);
                        stringBuilder.append("\n");
                    }
                stringBuilder.append("\n");
                stringBuilder.append("arrayUsersQuinceB \n partido : " + arrayUsersQuinceB.size());
                stringBuilder.append("\n");
                if(arrayUsersQuinceB.size()>0)
                    for (String s: arrayUsersQuinceB)
                    {
                        stringBuilder.append(s);
                        stringBuilder.append("\n");
                    }
                stringBuilder.append("\n");
                stringBuilder.append("1x2 EXPERTS votes: size: " + arrayExpertsVoted.size());
                stringBuilder.append("\n");
                index = 1;
                if(arrayExpertsVoted.size()>0)
                {
                    for(String s: arrayExpertsVoted)
                    {
                        stringBuilder.append(index+" " + arrayExpertsVoted.get(index-1));
                        index++;
                        stringBuilder.append("\n");
                    }
                }
                stringBuilder.append("\n");
                index = 1;
                /*
                stringBuilder.append("1x2 EXPERTS motives: size:" + arrayExpertsExplain.size());
                stringBuilder.append("\n");
                if(arrayExpertsExplain.size()>0)
                {
                    for(String s: arrayExpertsExplain)
                    {
                        stringBuilder.append(index+" " + arrayExpertsExplain.get(index-1));
                        index++;
                        stringBuilder.append("\n");
                    }
                }
                */
                index = 1;
                stringBuilder.append("\n");
            }
            catch (Exception e)
            {
                e.printStackTrace();
                dialog.dismiss();
            }

            tvResultado.setText(stringBuilder.toString());
            tvResultado.setMovementMethod(new ScrollingMovementMethod());
        }
    }
    public final boolean checkNetworkConnection()
    {
        ConnectivityManager connec =  (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if ( connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED )
        {
            return true;
        }
        else if (connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED || connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED  ) {
            return false;
        }
        return false;
    }
}
