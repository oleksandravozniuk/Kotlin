package com.example.lab3

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.android.synthetic.main.order.*

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        button.setOnClickListener{

            var dbManager = OrderDbManager(this)

             //Get the checked radio button id from radio group
            var id: Int = radio_group.checkedRadioButtonId
            var id2: Int = radio_group2.checkedRadioButtonId
            var editText = findViewById<EditText>(R.id.editText)


            if (id!=-1 && id2!=-1 && editText.toString().isNotEmpty()){ // If all radio groups are chosen and the text field is not empty


                val radio2: RadioButton = findViewById(id2)
                val radio: RadioButton = findViewById(id)

                var values = ContentValues()

                values.put("Text", editText.text.toString())
                values.put("Color", radio.text.toString())
                values.put("Price", radio2.text.toString())

                dbManager.insert(values)

                Toast.makeText(applicationContext,"Information is saved successfully!",Toast.LENGTH_SHORT).show()
            }else
            {
                Toast.makeText(applicationContext,"Please, choose all items!", Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun clear(view: View){
        radio_group.clearCheck()
        radio_group2.clearCheck()
        editText.text.clear()
    }

    fun showAllOrders(view: View)
    {
        val intent = Intent(this, MainActivity::class.java)
        // start your next activity
        startActivity(intent)
    }
}
