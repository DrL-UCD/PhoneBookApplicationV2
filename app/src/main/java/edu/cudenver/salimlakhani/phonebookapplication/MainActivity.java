package edu.cudenver.salimlakhani.phonebookapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import edu.cudenver.salimlakhani.phonebookapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private List<Contact> list;
    private ContactAdapter contactAdapter;
    private RecyclerView recyclerView;
    private String type;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    private ContactDatabase contactDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = getSharedPreferences("phonebook", Context.MODE_PRIVATE);
        editor = prefs.edit();


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        list = new ArrayList<Contact>();
        contactDatabase = ContactDatabase.getInstance(getApplicationContext());

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddContactDialog addContactDialog = new AddContactDialog();
                addContactDialog.show (getSupportFragmentManager(), "");
            }
        });


        recyclerView = findViewById(R.id.recyclerView);
        contactAdapter = new ContactAdapter(this, list);
        type = prefs.getString("type", "name");
        contactAdapter.setType(type);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(contactAdapter);
    }

    @Override
    public void onResume () {
        super.onResume();
        loadData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add) {
            AddContactDialog addContactDialog = new AddContactDialog();
            addContactDialog.show (getSupportFragmentManager(), "");
            return true;
        }
        else if (id == R.id.action_name) {
            type = "name";
            editor.putString("type", "name");
            editor.commit();
            contactAdapter.setType(type);
            contactAdapter.notifyDataSetChanged();
            return true;
        }
        else if (id == R.id.action_phone) {
            type = "phone";
            editor.putString("type", "phone");
            editor.commit();
            contactAdapter.setType(type);
            contactAdapter.notifyDataSetChanged();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void addContact (Contact contact) {
        Log.i ("info", "My Info Number of Contact is " + list.size());
        long id = contactDatabase.contactDao().insertContact(contact);
        Log.i ("info", "My Info Contact ID " + id);
        loadData();
    }


    public void loadData () {

        list.clear();
        Log.i ("info", "My Info Number of Contact is " + list.size());
        List<Contact> list2 = contactDatabase.contactDao().getAllContacts();
        if (list2.size() != 0) {
            list.addAll(list2);
            Log.i("info", "My Info Number of Contact is " + list.size());
            Log.i("info", "My Info " + list.get(0).getName());
            contactAdapter.notifyDataSetChanged();
        }
    }


    public void showContact (int contactToShow) {
        Log.i ("info", "Inside showContact method");
        ViewContactDialog viewContactDialog = new ViewContactDialog();
        viewContactDialog.setContact(list.get(contactToShow));
        viewContactDialog.show(getSupportFragmentManager(), "");

    }

}