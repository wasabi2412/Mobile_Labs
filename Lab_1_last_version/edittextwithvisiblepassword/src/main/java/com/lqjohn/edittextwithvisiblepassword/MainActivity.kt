package com.lqjohn.edittextwithvisiblepassword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import androidx.core.content.withStyledAttributes


class MainActivity : AppCompatActivity() {
    private var mIsShowPass = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivShowHidePass.setOnClickListener{
            mIsShowPass =!mIsShowPass
            showPassword(mIsShowPass)
        }
        showPassword(mIsShowPass)
        button1.setOnClickListener {
            whenClicked()
        }
    }

    private fun whenClicked(){
        Toast.makeText(this,  etPass.text.toString(), Toast.LENGTH_LONG).show()
    }

    private fun showPassword(isShow: Boolean){
        if(isShow){
            etPass.transformationMethod = HideReturnsTransformationMethod.getInstance()
            ivShowHidePass.setImageResource(R.drawable.ic_hide_password_24dp)
        }else{
            etPass.transformationMethod = PasswordTransformationMethod.getInstance()
            ivShowHidePass.setImageResource(R.drawable.ic_show_password_24dp)
        }
        etPass.setSelection(etPass.text.toString().length)
    }


}
