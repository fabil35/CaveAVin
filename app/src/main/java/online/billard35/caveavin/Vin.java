package online.billard35.caveavin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class Vin {

    long id;
    String nom;
    int annee;
    String couleur;
    String appellation;
    Float prix;
    String commentaire;

    private Vin (Cursor cursor) {
        id = cursor.getLong(cursor.getColumnIndex("id"));
        nom = cursor.getString(cursor.getColumnIndex("nom"));
        annee = cursor.getInt(cursor.getColumnIndex("annee"));
        couleur = cursor.getString(cursor.getColumnIndex("couleur"));
        appellation = cursor.getString(cursor.getColumnIndex("appellation"));
        prix = cursor.getFloat(cursor.getColumnIndex("prix"));
        commentaire = cursor.getString(cursor.getColumnIndex("commentaire"));
    }

    public Vin() {
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getAnnee() {
        return annee;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getAppellation() {
        return appellation;
    }

    public Float getPrix() {
        return prix;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public static ArrayList<Vin> getVinList(Context context) {
        ArrayList<Vin> listVin =new ArrayList<>();
        LocalSQLiteOpenHelper helper = new
                LocalSQLiteOpenHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(true, "Vin",
                new String[] {"id", "nom", "annee", "couleur", "appellation",
                        "prix", "commentaire"}, null, null,
                null, null,"id", null);

        while (cursor.moveToNext()) {
            listVin.add (new Vin(cursor));
        }
        cursor.close();
        db.close();

        return listVin;
    }
    public static Vin getVin(Context context, long id) {
        Vin vin =null;
        LocalSQLiteOpenHelper helper = new
                LocalSQLiteOpenHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String where ="id = "+ String.valueOf(id);
        Cursor cursor = db.query(true, "online.billard35.caveavin.Vin",
                new String[] {"id", "nom", "annee", "couleur", "appellation",
                        "prix", "commentaire"}, where, null,
                null, null,"titre", null);

        if (cursor.moveToFirst()) {
            vin = new Vin(cursor);
        }
        cursor.close();
        db.close();
        return vin;
    }
    public void insert (Context context) {
        ContentValues values = new ContentValues();
        values.put ("nom", this.nom);
        values.put("annee", this.annee);
        values.put ("couleur", this.couleur);
        values.put("appellation", this.appellation);
        values.put ("prix", this.prix);
        values.put("commentaire", this.commentaire);
        LocalSQLiteOpenHelper helper = new
                LocalSQLiteOpenHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        this.id=db.insert("online.billard35.caveavin.Vin",null,values);
        db.close();
    }
    public void update (Context context) {
        ContentValues values = new ContentValues();
        values.put ("nom", this.nom);
        values.put("annee", this.annee);
        values.put ("couleur", this.couleur);
        values.put("appellation", this.appellation);
        values.put ("prix", this.prix);
        values.put("commentaire", this.commentaire);
        String whereClause = "id=" + String.valueOf(this.id);
        LocalSQLiteOpenHelper helper = new
                LocalSQLiteOpenHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        this.id=db.update("online.billard35.caveavin.Vin", values, whereClause,null);
        db.close();
    }
    public void delete (Context context) {
        String whereClause = "id = ?";
        String[] whereArgs = new String[1];
        LocalSQLiteOpenHelper helper = new
                LocalSQLiteOpenHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete("online.billard35.caveavin.Vin", whereClause, whereArgs);
        db.close();
    }


}
