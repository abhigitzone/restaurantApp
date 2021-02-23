package com.example.restaurantapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.restaurantapp.Data.OrderData;

import java.util.ArrayList;

public class DatabaseOrders extends SQLiteOpenHelper {

    private static final int dbv = 1;  //database version
    private static final String dbname = "mydb";
    Context ct;

    public DatabaseOrders(@Nullable Context c) {
        super(c, dbname, null, dbv);
        ct = c;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String s = "create table orders(orderName text,quantity integer,price integer)";
        sqLiteDatabase.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertValues(String name, int quantity, int price) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();  //creating objects
        cv.put("orderName", name); //inserting order name..
        cv.put("quantity", quantity); //inserting number of items.
        cv.put("price", price);   //inserting total price..
        db.insert("orders", null, cv);

        Toast.makeText(ct, "Order Successfully placed", Toast.LENGTH_LONG).show();
    }


    public ArrayList<OrderData> getAllData() {
        ArrayList<OrderData> arrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String s = "select * from orders";
        Cursor cr = db.rawQuery(s, null);

        while (cr.moveToNext()) {
            String orderName = cr.getString(0);
            int item = cr.getInt(1);
            int price = cr.getInt(2);
            OrderData orderData = new OrderData(orderName, item, price);
            arrayList.add(orderData);
        }
        return arrayList;
    }
}
