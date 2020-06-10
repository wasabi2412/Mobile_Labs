package com.example.lab2_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), MainFragment.ReCallFunction {

    override fun fragmentInjection(result: String) {
        var fragment = supportFragmentManager.findFragmentById(R.id.resultFragment) as ResultFragment
        if(fragment.isInLayout){
            fragment.setText(result)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
