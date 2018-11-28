package com.viktor.phonebook;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class People implements Serializable {

    private List<Person> persons = new ArrayList();

    public People(SQLiteDatabase db, Zipcode zipcode)
    {
        try {
            String[] params = new String[]{zipcode.getCode()};
            Cursor cursor = db.rawQuery("select * from addresses where code = ?", params);
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                int id = cursor.getInt(DbHelper.ACOLUMN_ID);
                String fname = cursor.getString(DbHelper.ACOLUMN_FIRSTNAME);
                String lname = cursor.getString(DbHelper.ACOLUMN_LASTNAME);
                String addr = cursor.getString(DbHelper.ACOLUMN_ADDRESS);
                String phone = cursor.getString(DbHelper.ACOLUMN_PHONE);
                String mail = cursor.getString(DbHelper.ACOLUMN_MAIL);
                String date = cursor.getString(DbHelper.ACOLUMN_DATE);
                String title = cursor.getString(DbHelper.ACOLUMN_TITLE);
                persons.add(new Person(id, fname, lname, addr, zipcode, phone, mail, date, title));
            }
            cursor.close();
        }
        catch (Exception ex)
        {
            persons.clear();
        }
    }

    public People(SQLiteDatabase db, String firstname, String lastname, String address, String persontitle)
    {
        try {
            Cursor cursor = db.query(DbHelper.ATABLE_NAME, DbHelper.ATABLE_COLUMNS,
                    "firstname like ? and lastname like ? and address like ? and title like ?", new String[]
                            { firstname + "%", lastname + "%", "%" + address + "%", "%" + persontitle + "%" },
                    null, null, null);
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext())
            {
                int id = cursor.getInt(DbHelper.ACOLUMN_ID);
                String fname = cursor.getString(DbHelper.ACOLUMN_FIRSTNAME);
                String lname = cursor.getString(DbHelper.ACOLUMN_LASTNAME);
                String addr = cursor.getString(DbHelper.ACOLUMN_ADDRESS);
                String code = cursor.getString(DbHelper.ACOLUMN_CODE);
                String phone = cursor.getString(DbHelper.ACOLUMN_PHONE);
                String mail = cursor.getString(DbHelper.ACOLUMN_MAIL);
                String date = cursor.getString(DbHelper.ACOLUMN_DATE);
                String title = cursor.getString(DbHelper.ACOLUMN_TITLE);
                persons.add(new Person(id, fname, lname, addr, getZipcode(db, code), phone, mail, date, title));
            }
            cursor.close();
        }
        catch (Exception ex)
        {
            persons.clear();
        }
    }

    public List<Person> getPeople()
    {
        return persons;
    }

    private Zipcode getZipcode(SQLiteDatabase db, String code)
    {
        Cursor cursor = db.query(DbHelper.ZTABLE_NAME, DbHelper.ZTABLE_COLUMNS, "code = ?", new String[] { code },
                null, null, null);
        cursor.moveToFirst();
        return new Zipcode(cursor.getString(DbHelper.ZCOLUMN_CODE), cursor.getString(DbHelper.ZCOLUMN_CITY));
    }
}