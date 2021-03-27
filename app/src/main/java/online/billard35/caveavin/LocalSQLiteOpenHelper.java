package online.billard35.caveavin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LocalSQLiteOpenHelper extends SQLiteOpenHelper {
    static String DB_NAME = "CaveAvin.db";
    static int DB_VERSION = 1;
    public LocalSQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
     @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlFilTable = "CREATE TABLE Vin(id INTEGER PRIMARY KEY, " +
                "nom TEXT, annee TEXT, couleur TEXT, appellation TEXT, prix TEXT, commentaire TEXT);";
        db.execSQL(sqlFilTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for(int i=oldVersion; i<newVersion; i++) {
            int versionToUpdate= i+1;
            if (versionToUpdate==2) {
                // Code pour mettre la base de données en version 2
            } else if (versionToUpdate==3)  {
                // Code pour mettre la base de données en version 3
            }
            // [...]
        }

    }
 }
