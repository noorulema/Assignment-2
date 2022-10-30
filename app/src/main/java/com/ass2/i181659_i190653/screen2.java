package com.ass2.i181659_i190653;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class screen2 extends AppCompatActivity {

    EditText text1,text2,text3;
    ImageView male,female,pns;
    ImageButton cb;
    FirebaseAuth mAuth;
    TextView signup,signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        text3=findViewById(R.id.text3);
        cb=findViewById(R.id.cb);
        signup=findViewById(R.id.signup);
        mAuth=FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("mauthrespnce","clicked");
                mAuth.createUserWithEmailAndPassword(text2.getText().toString(),text3.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(screen2.this,"Signup",Toast.LENGTH_LONG).show();
                                startActivity(new Intent(screen2.this,screen5.class));
                                Log.d("mauthrespnce","success");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(screen2.this,"Signup Failed",Toast.LENGTH_LONG).show();
                                Log.d("mauthrespnce",e.toString());
                            }
                        });
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(screen2.this,screen3.class);
                startActivity(intent);
            }
        });

    }
}