package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
/*
* Alt+\ -> View -> Tool Windows -> App Inspection ou
* Lado esquerdo botão de óculos com chapéu.
* */
public class NotaDAO {
    SQLiteDatabase db;

    public NotaDAO(Context context) {
        db = context.openOrCreateDatabase("minhasnotinhas", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT , txt TEXT)");
    }

    public void insereNota(String txt) {
        ContentValues cv = new ContentValues();
        cv.put("txt", txt);
        db.insert("notas", null, cv);
    }

    public void deleteNota(int id) {
        db.delete("notas", "id=?", new String[]{Integer.toString(id)});
    }

    public ArrayList<Nota> getNotas() {
        ArrayList<Nota> notas = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int columnid = cursor.getColumnIndex("id");
            int columnTxt = cursor.getColumnIndex("txt");
            int id = cursor.getInt(columnid);
            String txt = cursor.getString(columnTxt);
            notas.add(new Nota(id, txt));
            cursor.moveToNext();
        }
        cursor.close();
        return notas;
    }
}
