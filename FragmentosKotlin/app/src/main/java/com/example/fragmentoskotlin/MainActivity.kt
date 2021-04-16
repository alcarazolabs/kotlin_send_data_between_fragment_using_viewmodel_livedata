package com.example.fragmentoskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    //navigation components..
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //inflar fragmento
        /*
        supportFragmentManager.commit {
            setReorderingAllowed(true) //para que las transiciones se ejecuten bien
            add(R.id.fragmentContainerView, PrimerFragment())
        }
        */

    }
}