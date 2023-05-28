package com.pratyushvkp.crud.adapter;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pratyushvkp.crud.R;
import com.pratyushvkp.crud.model.Contact;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Contact> contactList;

    public RecyclerViewAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    // onCreateViewHolder works defines where to get the single card as viewHolder Object
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
     return new ViewHolder(view);
    }

    // onBindViewHolder defines what will happen after we create the viewHolder object
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
      Contact contact = contactList.get(position);
      holder.contactName.setText(contact.getName());
      holder.phoneNumber.setText(contact.getPhoneNumber());

    }

    // How many items
    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView contactName;
        public TextView phoneNumber;
        public ImageView iconButton;

         public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            contactName = itemView.findViewById(R.id.name);
            phoneNumber = itemView.findViewById(R.id.phoneNumber);
            iconButton = itemView.findViewById(R.id.iconButton);

            iconButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            Log.d("ClickFromViewHolder", "Clicked");
            int position = this.getAbsoluteAdapterPosition();
            Contact contact = contactList.get(position);
            String Name = contact.getName();
            String phone = contact.getPhoneNumber();

            Toast.makeText(context,"The position you clicked is: " + String.valueOf(position) + ". Name: " + Name + ", Phone: " + phone,Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context,DisplayContactActivity.class);
            intent.putExtra("RName",Name);
            intent.putExtra("Rphone",phone);
            context.startActivity(intent);
        }
    }
}
