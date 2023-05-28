package com.pratyushvkp.crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.pratyushvkp.crud.adapter.RecyclerViewAdapter;
import com.pratyushvkp.crud.data.MyDbHandler;
import com.pratyushvkp.crud.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
        private RecyclerView recyclerView;
        private RecyclerViewAdapter recyclerViewAdapter;
        private ArrayList<Contact> contactArrayList;
        private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RecyclerView Initialization
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyDbHandler db = new MyDbHandler(MainActivity.this);

        //Adding contact to database
        Contact pratyush = new Contact();
        pratyush.setName("Pratyush Sharma");
        pratyush.setPhoneNumber("9999999999");

        db.addContact(pratyush);

        //Adding contact to database
        Contact Shivansh = new Contact();
        Shivansh.setName("Shivansh Sharma");
        Shivansh.setPhoneNumber("9998899999");
        db.addContact(Shivansh);

        //Adding contact to database
        Contact Adarsh = new Contact();
        Adarsh.setName("Adarsh Sharma");
        Adarsh.setPhoneNumber("9998844599");
        db.addContact(Adarsh);

        Log.d("dbPratyush" ,"Successfully Ids inserted");

        //Updating the contact
       Adarsh.setId(9);  // Whatever Id issued by database in Last run Logcat
        Adarsh.setName("New Adarsh");
        Adarsh.setPhoneNumber("9944556774");
        int affectedRows = db.updateContact(Adarsh);
        Log.d("dbPratyush","No. of affected rows are: " + affectedRows);

        //deleting contacts
//        db.deleteContactById(1);
//        db.deleteContactById(7);
        //Get all contacts

        contactArrayList = new ArrayList<>();



        List<Contact> contactList = db.getAllContacts();
        for(Contact contact : contactList){
            Log.d("dbPratyush","\nId: " + contact.getId() + "\n" +
                                "Name: " + contact.getName() + "\n" +
                                 "PhoneNumber: " + contact.getPhoneNumber() + "\n" );
            contactArrayList.add(contact);
        }


        //Use RecyclerView
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,contactArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);


        Log.d("dbPratyush" , "You have "+ db.getCount() +" contacts in your data list");
    }
}