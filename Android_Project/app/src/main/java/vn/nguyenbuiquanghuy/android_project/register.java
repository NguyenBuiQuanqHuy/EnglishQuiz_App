package vn.nguyenbuiquanghuy.android_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
    }
    public void MainScreen(View v){
        Intent main=new Intent(Register.this,MainScreen.class);
        startActivity(main);
    }
    public void LoginScreen(View v){
        Intent register=new Intent(Register.this,Login.class);
        startActivity(register);
    }
}