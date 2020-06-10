package com.example.lab2_kotlin

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : androidx.fragment.app.Fragment() {

    private var listener: ReCallFunction? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonOkListener()
        var mIsShowPass = false
        ivShowHidePass.setOnClickListener{
            mIsShowPass =!mIsShowPass
            showPassword(mIsShowPass)
        }
        showPassword(mIsShowPass)

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

    private fun buttonOkListener()
    {
        button1.setOnClickListener{

            listener?.fragmentInjection("Your password: ${etPass.text.toString()}")

        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ReCallFunction) {
            listener = context
        } else {
            throw RuntimeException("$context must implement ReCallFunction")
        }
    }


    interface ReCallFunction {
        fun fragmentInjection(result: String)
    }

}
