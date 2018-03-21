package com.example.sjy.javaclasstest2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editTextUsername=(EditText)findViewById(R.id.username);
        final EditText editTextPassword=(EditText)findViewById(R.id.password);
        Button login=(Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    List<Users> users= DataSupport.findAll(Users.class);
                    for(Users user:users){
                        if(user.getUsername().equals(editTextUsername.getText().toString())&&user.getPassword().equals(editTextPassword.getText().toString())){
                            Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(MainActivity.this,Test.class);
                            startActivity(intent);
                            finish();
                            break;
                        }
                    }
                    Toast.makeText(MainActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        Button createdb=(Button)findViewById(R.id.create_database);
        createdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db =LitePal.getDatabase();
            }
        });
        Button addUser=(Button)findViewById(R.id.adduser_database);
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Users user=new Users();
                user.setUsername("123");
                user.setPassword("123");
                user.save();
            }
        });
    }
}
