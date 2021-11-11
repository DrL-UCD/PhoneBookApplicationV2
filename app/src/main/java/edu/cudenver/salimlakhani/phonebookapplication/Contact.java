package edu.cudenver.salimlakhani.phonebookapplication;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contact {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name= "id")
    private int id;

    @NonNull
    @ColumnInfo (name = "name")
    private String name;

    @ColumnInfo (name = "phone")
    private String phone;

    @ColumnInfo (name = "email")
    private String email;

    @ColumnInfo (name = "address")
    private String address;

    @ColumnInfo (name = "city")
    private String city;

    @ColumnInfo (name = "state")
    private String state;

    @ColumnInfo (name = "zip")
    private String zip;

    @ColumnInfo (name = "type")
    private String contacttype;

    public Contact(String name, String phone, String email, String address, String city, String state,String zip,String contacttype){


        this.name=name;
        this.phone=phone;
        this.email=email;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.contacttype=contacttype;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getContacttype() {
        return contacttype;
    }

    public void setContacttype(String contacttype) {
        this.contacttype = contacttype;
    }
}
