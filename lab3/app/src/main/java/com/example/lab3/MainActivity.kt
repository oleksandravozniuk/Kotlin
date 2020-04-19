package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get radio group selected status and text using button click event
        button.setOnClickListener{
            // Get the checked radio button id from radio group
            var id: Int = radio_group.checkedRadioButtonId
            var id2: Int = radio_group2.checkedRadioButtonId
            val editText = findViewById<EditText>(R.id.editText)


            if (id!=-1 && id2!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id

                val radio2: RadioButton = findViewById(id2)
                val radio: RadioButton = findViewById(id)

                Toast.makeText(applicationContext,"On button click :" +
                        " ${radio.text}" + " and " + "${radio2.text}\n" + "text: " + "${editText.text}\n",
                    Toast.LENGTH_SHORT).show()
            }else
                if(id!=-1 && id2==-1 ){
                    val radio: RadioButton = findViewById(id)

                    Toast.makeText(applicationContext,"On button click :" +
                            " ${radio.text}" + " and " + "nothing selected in price\n" + "text: " + "${editText.text}\n",
                        Toast.LENGTH_SHORT).show()
                }
                else
                    if(id==-1 && id2!=-1)
                    {
                        val radio2: RadioButton = findViewById(id2)

                        Toast.makeText(applicationContext,"On button click :" +
                                " ${radio2.text}" + " and " + "nothing selected in colours\n" + "text: " + "${editText.text}\n",
                            Toast.LENGTH_SHORT).show()
                    }
                    else{
                        // If no radio button checked in this radio group
                        Toast.makeText(applicationContext,"On button click :" +
                                " nothing selected\n" + "text: " + "${editText.text}\n" + "progress: ",
                            Toast.LENGTH_SHORT).show()
                    }
        }



    }
    // Get the selected radio button text using radio button on click listener
    fun radio_button_click(view: View){
        // Get the clicked radio button instance
        val radio: RadioButton = findViewById(radio_group.checkedRadioButtonId)
        Toast.makeText(applicationContext,"On click : ${radio.text}",
            Toast.LENGTH_SHORT).show()
    }

    fun radio_button_click2(view: View){
        // Get the clicked radio button instance
        val radio: RadioButton = findViewById(radio_group2.checkedRadioButtonId)
        Toast.makeText(applicationContext,"On click : ${radio.text}",
            Toast.LENGTH_SHORT).show()
    }

    fun clear(view: View){
        radio_group.clearCheck()
        radio_group2.clearCheck()
        editText.text.clear()
    }
}
