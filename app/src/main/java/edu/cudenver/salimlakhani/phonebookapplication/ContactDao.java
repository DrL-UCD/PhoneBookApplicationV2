package edu.cudenver.salimlakhani.phonebookapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactDao {

    @Query("SELECT * FROM Contact order by name")
    public List<Contact> getAllContacts();


    @Insert
    public long insertContact (Contact contact);

    @Update
    public void update (Contact contact);

    @Delete
    public void delete (Contact contact);
}
