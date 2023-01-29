package com.xgrogos.uf1m8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtUsername = findViewById(R.id.txtUsername) as EditText
        var txtPassword = findViewById(R.id.txtPassword) as EditText
        var txtForgotPassword = findViewById(R.id.txtForgotPassword) as TextView
        var buttonLogin = findViewById(R.id.buttonLogin) as Button

        buttonLogin.setOnClickListener {
            // clearing user_name and password edit text views on reset button click
            txtUsername.setText("")
            txtPassword.setText("")
        }
        // set on-click listener
        buttonLogin.setOnClickListener {
            val user_name = txtUsername.getText().toString();
            val password = txtPassword.getText().toString();
            Toast.makeText(this@MainActivity, user_name, Toast.LENGTH_LONG).show()
            // Creamos unas credenciales temporales para poder acceder al main_menu.
            if(user_name == "" && password==""){
                // una vez las credenciales se han validado, nos mostrara el main_menu.
                var intentBottomNavigation : Intent = Intent(this, BottomNavigation::class.java)
                startActivity(intentBottomNavigation);
            }
            // your code to validate the user_name and password combination
            // and verify the same
        }
    }
}