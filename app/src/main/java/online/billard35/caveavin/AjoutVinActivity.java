package online.billard35.caveavin;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AjoutVinActivity extends Activity {

    EditText editNomVin;
    EditText editAnneeVin;
    EditText editCouleurVin;
    EditText editAppellationVin;
    EditText editPrixVin;
    EditText editCommentaireVin;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // affectation du fichier de layout
        setContentView(R.layout.activity_ajoutvin);

        //obtention des références sur les composants
        editNomVin= (EditText) findViewById(R.id.ajoutvin_nom);
        editAnneeVin = (EditText) findViewById(R.id.ajoutvin_annee);
        editCouleurVin = (EditText) findViewById(R.id.ajoutvin_couleur);
        editAppellationVin = (EditText) findViewById(R.id.ajoutvin_appellation);
        editPrixVin = (EditText) findViewById(R.id.ajoutvin_prix);
        editCommentaireVin = (EditText) findViewById(R.id.ajoutvin_commentaire);
        btnOk = (Button) findViewById(R.id.ajoutvin_ok);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
