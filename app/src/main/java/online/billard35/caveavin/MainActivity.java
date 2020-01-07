package online.billard35.caveavin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list= (RecyclerView) findViewById(R.id.main_List);
 /*
        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int
                    position, long id) {
                startViewVinActivity(id);
            }
        });
*/

        SharedPreferences sharedPreferences =
                getSharedPreferences("online.billard35.caveavin.locVin.prefs",Context.MODE_PRIVATE);
        if(!sharedPreferences.getBoolean("embeddedDataInserted", false))
            readEmbeddedData();
    }

    @Override
    public void onResume() {
        super.onResume();
        ArrayList<Vin> vinList = Vin.getVinList(this);
        VinAdapter vinAdapter = new VinAdapter(vinList);
        list.setAdapter(vinAdapter);
    }

    private void startViewDVDActivity(long dvdId) {
        Intent intent = new Intent(this, ViewVinActivity.class);
        intent.putExtra("vinId",dvdId);
        startActivity(intent);
    }


    private void readEmbeddedData() {
        InputStreamReader reader = null;
        InputStream file = null;
        BufferedReader bufferedReader = null;
        try{
            file = getAssets().open("data.txt");
            reader = new InputStreamReader(file);
            bufferedReader = new BufferedReader(reader);
            String line=null;
            while ((line=bufferedReader.readLine())!=null) {
                String [] data = line.split("\\|");
                Vin vin = new Vin();
                vin.nom = data[0];
                vin.annee = Integer.decode(data[1]);
                vin.couleur = data[2];
                vin.appellation = data[3];
                vin.prix = Float.valueOf(data[4]);
                vin.commentaire = data[5];
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(bufferedReader!=null) {
                try {
                    bufferedReader.close();
                    reader.close();
                    SharedPreferences sharedPreferences =
                            getSharedPreferences("online.billard35.caveavin.prefs",
                                    Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor =
                            sharedPreferences.edit();
                    editor.putBoolean("embeddedDataInserted", true);
                    editor.commit();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
