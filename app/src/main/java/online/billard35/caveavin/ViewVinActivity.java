package online.billard35.caveavin;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewVinActivity extends Activity{

    TextView txtNomVin;
    TextView txtAnneeVin;
    TextView txtCouleurVin;
    TextView txtAppellationVin;
    TextView txtPrixVin;
    TextView txtCommentaireVin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // affectation du fichier de layout
        setContentView(R.layout.activity_viewvin);

        //obtention des références sur les composants
        txtNomVin= (TextView) findViewById(R.id.nomVin);
        txtAnneeVin = (TextView) findViewById(R.id.anneeVin);
        txtCouleurVin = (TextView) findViewById(R.id.couleurVin);
        txtAppellationVin = (TextView) findViewById(R.id.appellationVin);
        txtPrixVin = (TextView) findViewById(R.id.prixVin);
        txtCommentaireVin = (TextView) findViewById(R.id.commentaireVin);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
        protected void onResume() {
        super.onResume();

        txtNomVin.setText("Château Latour-Martillac");
        txtAnneeVin.setText(String.format(getString(R.string.annee_du_vin_yyyy),2016));
        txtCouleurVin.setText("Rouge");
        txtAppellationVin.setText("Pessac-Léognan");
        txtPrixVin.setText("30 €");
        String commentaire="Excellent vin"+
                "Notes de petits fruits noirs, Zan. " +
                "Bouche nette, fruitée, élégante, tannins fins et enrobés,"+
                "joli toucher de bouche. Finale longue.";
        txtCommentaireVin.setText(commentaire);

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
