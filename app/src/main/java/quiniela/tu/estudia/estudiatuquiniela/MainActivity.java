package quiniela.tu.estudia.estudiatuquiniela;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;


@Deprecated
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    private ProgressDialog dialog;
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
            WebView     webView     = (WebView) findViewById(R.id.webView);
            String      url         = "https://static.dataradar.es/marcador/Marcador_QUINI_lite.html";
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.loadUrl(url);
            WebView     webView2     = (WebView) findViewById(R.id.webView2);
            String      url2         = "https://www.quinielista.es/enVivo/index.asp";
            WebSettings webSettings2 = webView2.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.loadUrl(url2);
        }
        else
        {
            Toast.makeText(this,"No hay conexión a internet",Toast.LENGTH_LONG).show();
        }

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
            // Handle the camera action
            Toast.makeText(this,"1",Toast.LENGTH_SHORT).show();
            if(true)
            {
//                String urlString = "http://quiniela.combinacionganadora.com/";
                DownloadWebPageTask downloadWebPageTask = new DownloadWebPageTask();
                downloadWebPageTask.doInBackground("");
            }
            else
            {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Fail:");
                alertDialog.setMessage("No internet connection");

                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
            }
        }
        else if (id == R.id.nav_2)
        {
            Toast.makeText(this,"2",Toast.LENGTH_SHORT).show();
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
    private class DownloadWebPageTask extends AsyncTask<String, Void, String>
    {
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();

            dialog.setMessage("Obteniendo datos de la jornada.");
        }

        @Override
        protected String doInBackground(String... urls)
        {
            String response = "";
            if(!dialog.isShowing())
            {
                dialog.show();
            }
            //arrays_variables_expertos
            boolean startExpertStats = false;
            ArrayList<String> arrayExpertsVoted = new ArrayList<String>();
            ArrayList<String> arrayExpertsExplain = new ArrayList<String>();
            //arrays_variables_expertos//
            /////////////////////////////
            //arrays_variables_usuarios
            boolean startUserStats = false;
            String totalVotos = "";
            ArrayList<String> arrayUsersVotedUno = new ArrayList<String>();
            ArrayList<String> arrayUsersVotedEquis = new ArrayList<String>();
            ArrayList<String> arrayUsersVotedDos = new ArrayList<String>();
            ArrayList<String> arrayUsersVotedHighLightType = new ArrayList<String>();
            ArrayList<String> arrayUsersVotedHighLightPercent = new ArrayList<String>();
            ArrayList<String> arrayUsersQuinceA = new ArrayList<String>();
            ArrayList<String> arrayUsersQuinceB = new ArrayList<String>();
            ArrayList<String> arrayPronosticoCombiGanadora = new ArrayList<String>();
            ArrayList<String> arrayPronosticoCombiGanadoraMotivos = new ArrayList<String>();
            int userVoted = -1;
            //arrays_variables_usuarios//
            try
            {
                int lineCounter = 0;
                String urlString = "http://quiniela.combinacionganadora.com/";
                URL url = new URL(urlString);
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                String line;
                String fistLineExplanation = "";
                boolean thereIsSecondLineSpecified = false;
                System.out.println("---- ---- ---- ---- ----");
                while ((line = in.readLine()) != null)
                {
                    lineCounter++;
                    //
                    //EXPERT STATS
                    //
                    if(lineCounter>=948)
                    {
                        System.out.println();
                    }
                    if(line.contains("Nuestro pron")&&line.contains("jornada")&&line.contains("es el siguiente"))
                    {
                        startExpertStats = true;
                    }
                    if(startExpertStats)
                    {
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
//                                startExpertStats = false;
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
                            if (line.contains("ctrlNews_tagBar") )
                            {
                                startExpertStats = false;
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
                        System.out.println("Autorizando busqueda de pronóticos personales jugados:");
                    }
                    if(startUserStats)
                    {
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

                        if(line.contains("col5")) //EN ESTA PARTE DEL CÓDIGO...
                        {
                            try
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
                                        System.out.println("Recogiendo pronósticos personales 1");
                                        arrayUsersVotedUno.add(usersVotedUno);
                                        if (line.contains("highLigh"))
                                        {
                                            if (!usersVotedUno.equals(""))
                                            {
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
                            catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                        else if(line.contains("col6"))
                        {
                            try
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
                                        System.out.println("Recogiendo pronósticos personales X");
                                        arrayUsersVotedEquis.add(usersVotedEquis);
                                        if (line.contains("highLigh"))
                                        {
                                            if (!usersVotedEquis.equals(""))
                                                arrayUsersVotedHighLightType.add("X");
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
                            catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                        else if(line.contains("col7"))
                        {
                            try
                            {
                                String help = lineEdited.replace("col7","");
                                int a = help.indexOf(">");
                                int b = help.indexOf("<");
                                a++;
                                String usersVotedDos = "";
                                if(a>=0&&b>=0&&b>a)
                                {
                                    usersVotedDos = help.substring(a, b);
                                    if(!usersVotedDos.equals("2") && !usersVotedDos.equals("") )
                                    {
                                        System.out.println("Recogiendo pronósticos personales 2");
                                        arrayUsersVotedDos.add(usersVotedDos);
                                        if(line.contains("highLigh"))
                                        {
                                            if(!usersVotedDos.equals(""))
                                                arrayUsersVotedHighLightType.add("2");
                                            if(!usersVotedDos.equals(""))
                                                arrayUsersVotedHighLightPercent.add(usersVotedDos);
                                        }
                                    }
                                }
                                else
                                {
                                    usersVotedDos = "0";
                                    arrayUsersVotedDos.add(usersVotedDos);
                                }
                            }
                            catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                        //Busqueda partido 15:
                        System.out.println("Recogiendo pronósticos personales Partido 15");
                        if(arrayUsersVotedDos.size()>13)
                        {
                            String linePartido15 = line.replace("  "," ").replace(" highLight","").replace("highLight","");
                            if( linePartido15.contains("<div class=\"\">")  &&
                                    linePartido15.contains("</div") )
                            {
                                System.out.println("Encontrados resultados partido 15:");
                                String valuePartido15 = linePartido15.replace("<div class=\"\">","").replace("</div>","".trim().replace("%",""));
                                if(arrayUsersQuinceA.size()<=3)
                                {
                                    System.out.println("Partido 15 E1: " + valuePartido15);
                                    arrayUsersQuinceA.add(valuePartido15);
                                }
                                else
                                {
                                    System.out.println("Partido 15 E2" + valuePartido15);
                                    arrayUsersQuinceB.add(valuePartido15);
                                }
                            }
                        }
                        //Fin busqueda partido 15 jugadors:
                        if(line.contains("dev_quinielaReaders_total"))
                        {
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
                    System.out.println("Linea:" + lineCounter + " |" + line);
                }
                int index = 1;
                System.out.println("ARRAYS 1x2 usersSoccerRank:");
                if(arrayUsersVotedUno.size()>0)
                {
                    for(String s: arrayUsersVotedUno)
                    {
                        System.out.print(index+" " + arrayUsersVotedUno.get(index-1));
                        System.out.print(" " + arrayUsersVotedEquis.get(index-1));
                        System.out.println(" " + arrayUsersVotedDos.get(index-1) + "");
                        index++;
                    }
                    System.out.println("15 a:" + arrayUsersQuinceA.toString());
                    System.out.println("15 b:" + arrayUsersQuinceB.toString());
                    System.out.println("-- HIGHLIGHTS:");
                    System.out.println("Type: " + arrayUsersVotedHighLightType);
                    System.out.println("Perc: " + arrayUsersVotedHighLightPercent);
                }
                System.out.println("Usuarios votaron:" + totalVotos);
                index = 1;
                System.out.println("ARRAYS 1x2 EXPERTS votes:");
                if(arrayExpertsVoted.size()>0)
                {
                    for(String s: arrayExpertsVoted)
                    {
                        System.out.println(index+" " + arrayExpertsVoted.get(index-1));
                        index++;
                    }
                }
                index = 1;
                System.out.println("ARRAYS 1x2 EXPERTS motives:");
                if(arrayExpertsExplain.size()>0)
                {
                    for(String s: arrayExpertsExplain)
                    {
                        System.out.println(index+" " + arrayExpertsExplain.get(index-1));
                        index++;
                    }
                }
                in.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                if (dialog.isShowing())
                {
                    dialog.dismiss();
                }
            }
            return response;
        }

        @Override
        protected void onPostExecute(String result)
        {

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
