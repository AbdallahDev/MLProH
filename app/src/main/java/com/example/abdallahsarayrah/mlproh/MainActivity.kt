package com.example.abdallahsarayrah.mlproh

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //this toast to get the api version of the running smartphone
        Toast.makeText(this, Build.VERSION.SDK_INT.toString(), Toast.LENGTH_SHORT).show()

        var sharedPref = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        var editor = sharedPref.edit()

        when {
            sharedPref.getString("lang", "0") == "1" -> radioButton_en.isChecked = true
            sharedPref.getString("lang", "0") == "2" -> radioButton_ar.isChecked = true
            sharedPref.getString("lang", "0") == "3" -> radioButton_de.isChecked = true
        }

        radioButton_en.setOnClickListener {
            val locale = Locale("en")
            Locale.setDefault(locale)

            val config = Configuration()
            config.locale = locale
            baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

            editor.putString("lang", "1")
            editor.commit()

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        radioButton_ar.setOnClickListener {
            val locale = Locale("ar")
            Locale.setDefault(locale)

            val config = Configuration()
            config.locale = locale
            baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

            editor.putString("lang", "2")
            editor.commit()

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        radioButton_de.setOnClickListener {
            val locale = Locale("de")
            Locale.setDefault(locale)

            val config = Configuration()
            config.locale = locale
            baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

            editor.putString("lang", "3")
            editor.commit()

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
