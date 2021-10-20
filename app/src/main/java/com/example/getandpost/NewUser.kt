package com.example.getandpost

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewUser : AppCompatActivity() {
    lateinit var name : EditText
    lateinit var ID : EditText
    lateinit var savebtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user)

        name = findViewById(R.id.editText)
        ID = findViewById(R.id.editTextID)
        savebtn = findViewById(R.id.button)

        savebtn.setOnClickListener {
            addSingleuser()
        }
    }

    private fun addSingleuser() {

        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        val progressDialog = ProgressDialog(this@NewUser)
        progressDialog.setMessage("Please wait")
        progressDialog.show()

       val nameIN = name.text.toString()
       val idIN = ID.text.toString().toInt()
        if (apiInterface != null) {
            apiInterface.addUser(People.PeopleItem(nameIN , idIN)).enqueue(object : Callback<People.PeopleItem> {
                override fun onResponse(
                    call: Call<People.PeopleItem>,
                    response: Response<People.PeopleItem>
                ) {
                    Toast.makeText(applicationContext, "Save Success!", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss()
                }

                override fun onFailure(call: Call<People.PeopleItem>, t: Throwable) {
                    Toast.makeText(applicationContext, "Error!", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss()

                }
            })
        }

    }
    fun addnew(view: android.view.View) {
        intent = Intent(applicationContext, NewUser::class.java)
        startActivity(intent)
    }

    fun viewusers(view: android.view.View) {
        intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }
}