package com.disney.sophia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private EditText input;
    private EditText input2;
    private TextView mText;
    private TextView mText2;
    private Button mButton;
    //private DatabaseReference mDatabase;
    private FirebaseDatabase database;
    private DatabaseReference myRef2;
    private DatabaseReference myRef;
    //private String value;
    private List<SophiaC> mFav;
    private SophiaC mFav2;
    private SophiaC mFav3;


    private SophiaC mTemp;
    private SophiaC mTemp2;
    GenericTypeIndicator<List<SophiaC>> t = new GenericTypeIndicator<List<SophiaC>>() {};

    private List<SophiaC> esha;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        esha= new ArrayList<SophiaC>();
        mFav= new ArrayList<SophiaC>();
        input2 = (EditText) findViewById(R.id.input2);

        input = (EditText) findViewById(R.id.input);
        mButton=(Button) findViewById(R.id.button) ;
        mText = (TextView)findViewById(R.id.text);


        //mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
        database = FirebaseDatabase.getInstance();

        myRef = database.getReference("List");
        //myRef2 = database.getReference("2");

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTemp=new SophiaC(input.getText()+"");
                mTemp2=new SophiaC(input2.getText()+"");
                esha.add(mTemp);
                esha.add(mTemp2);
                //Log.v("hi",mTemp2.getLastName());
                myRef.setValue(esha);
              //  myRef2.setValue(mTemp2);

//                mDatabase.child("Person1").setValue(mTemp);
//                mDatabase.child("Person2").setValue(mTemp2);

                //myRef.setValue(mTemp);
                //myRef2.setValue(mTemp2);
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                mFav = dataSnapshot.getValue(t);
                if(mFav!=null) {
                    mFav2=mFav.get(0);
                    mFav3=mFav.get(1);

                    mText.setText("first: "+mFav2.getLastName()+"  second: "+mFav3.getLastName());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

//        myRef2.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                mFav2 = dataSnapshot.getValue(SophiaC.class);
//                if(mFav2!=null)
//                    input2.setText(mFav2.getLastName());
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });
//        mDatabase.child("Person1").addListenerForSingleValueEvent(
//                new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        // Get user value
//                         mFav = dataSnapshot.getValue(SophiaC.class);
//                        if(mFav!=null) {
//                            Log.v("hello", mFav.getLastName());
//                            mText.setText("Found: " + mFav.getLastName());
//                        }
//                }
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//            });

//        mDatabase.child("2").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                mFav2 = dataSnapshot.getValue(SophiaC.class);
//                if(mFav!=null)
//
//                    mText2.setText("Found: "+mFav.mLastName);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
    }
}
