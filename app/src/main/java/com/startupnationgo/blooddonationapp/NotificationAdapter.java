package com.startupnationgo.blooddonationapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.startupnationgo.blooddonationapp.models.Model;

import java.util.ArrayList;
import java.util.List;


public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {
    String setname ,setmobile, setbloodgroup, sethospitaladress,setlandmark;

    private List<String> values;
    private ArrayList<Model> a;
    private Context context;
    private Button details;
    private DatabaseReference mUserDatabase;
    private FirebaseUser mCurrentUser;

    public NotificationAdapter(Context context,List<String> values,ArrayList<Model> a) {

            this.context=context;
            this.values=values;
            this.a=a;

    }

    public NotificationAdapter(Context context, ArrayList<Model> a) {
        this.context=context;
        this.a=a;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_cards,parent,false);
       NotificationViewHolder notificationViewHolder=new NotificationViewHolder(itemView);
            return notificationViewHolder;

       // }


    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, final int position) {


        holder.name.setText("Requested By "+a.get(position).getName());
        holder.bloodgroup.setText("Blood Group "+a.get(position).getBloodGroup());
        holder.mobileno.setText("Mobile No. "+a.get(position).getMobile());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(view.getContext(),RequestProfile.class);
                i.putExtra("Name",a.get(position).getName());
                i.putExtra("Bloodgroup",a.get(position).getBloodGroup());
                i.putExtra("mobile",a.get(position).getMobile());
                i.putExtra("HospitalAddress",a.get(position).getHospitalAdress());
                i.putExtra("Landmark",a.get(position).getLandMark());
                view.getContext().startActivity(i);
            }
        });


    }
//    public int getCount() {
//        return values.size();
//    }

    @Override
    public int getItemCount() {
        return a.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder {
        TextView name,bloodgroup,mobileno;
        Button button;
        CardView cardView;
        public NotificationViewHolder(View itemView) {
            super(itemView);
//            mUserDatabase= FirebaseDatabase.getInstance().getReference().child("Notification").child(a.get(i));
//            mUserDatabase.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    setname=dataSnapshot.child("name").getValue().toString();
//                    setmobile =dataSnapshot.child("mobile").getValue().toString();
//                    setbloodgroup=dataSnapshot.child("bloodgroup").getValue().toString();
//                    sethospitaladress=dataSnapshot.child("hospital").getValue().toString();
//                    setlandmark=dataSnapshot.child("landmark").getValue().toString();
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//                }
//            });

            cardView=(CardView)itemView.findViewById(R.id.Notification_card);
            name=(TextView)itemView.findViewById(R.id.name);
            bloodgroup=(TextView)itemView.findViewById(R.id.bloodgroup);
            mobileno=(TextView)itemView.findViewById(R.id.mobile);
            button=(Button)itemView.findViewById(R.id.details);
           // i++;
        }
    }
}