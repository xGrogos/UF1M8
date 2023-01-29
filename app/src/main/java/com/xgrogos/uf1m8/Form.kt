package com.xgrogos.uf1m8

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.xgrogos.uf1m8.DB.LolDBHelper

class Form(dbH:LolDBHelper) : Fragment() {
    val dbHelper = dbH;


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View =  inflater.inflate(R.layout.fragment_form, container, false);

        // We are declaring the variables and making reference of the fragmentform.xml
        // calling the "ID" of each camp created in the xml.
        var championName = view.findViewById(R.id.name) as EditText
        var championType = view.findViewById(R.id.type) as EditText
        var championDescription = view.findViewById(R.id.description) as EditText
        var buttonSave : Button = view.findViewById(R.id.btnSave);
        var buttonDelete : Button = view.findViewById(R.id.btnDelete);

        buttonSave.setOnClickListener {
            // the values down here are the inputs for us to write in the database the following Strings.
            val name:String = championName.text.toString()
            val type:String = championType.text.toString()
            val description:String = championDescription.text.toString()
            if(name.isNotEmpty() && type.isNotEmpty() && description.isNotEmpty()) {
                // create length condition: for example: name.length <= 20
                dbHelper.insertLol(Lol(name,type,description))
                championName.setText("")
                championType.setText("")
                championDescription.setText("")
                Toast.makeText(context, "Champion Saved", Toast.LENGTH_LONG).show()
            } // Create pop up para el texto no introducido
        }
        // The delete button with the pop up functionality to confirm
        // if you would like to delete the rows created in the BBDD
        buttonDelete.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setMessage("¿Are you sure that you want to DELETE all the rows?")
                .setPositiveButton("Yes",
                    DialogInterface.OnClickListener { dialog, id ->
                        // Deletes the rows of the database.
                        dbHelper.deleteLol()
                    })
                .setNegativeButton("No",
                    DialogInterface.OnClickListener { dialog, id ->
                        // User cancelled the dialog
                    })
            // Create the AlertDialog object and return it
            builder.create().show()
        }
        return view;

    }
}