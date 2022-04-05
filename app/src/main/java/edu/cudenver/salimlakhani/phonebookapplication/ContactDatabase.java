package edu.cudenver.salimlakhani.phonebookapplication;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Database;

@Database(entities = {Contact.class}, version= 1)
public abstract class ContactDatabase extends RoomDatabase{

    private static final String DATABASE_NAME = "contact.db";

    private static ContactDatabase contactDatabase;

    public static ContactDatabase getInstance(Context context) {
        if (contactDatabase == null) {
            contactDatabase = Room.databaseBuilder(context, ContactDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return contactDatabase;
    }

    public abstract ContactDao contactDao();
}
