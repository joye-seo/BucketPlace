package com.example.bucketplace.config

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.bucketplace.src.login.LoginRetrofitInterface

abstract class BaseActivity<B : ViewBinding>(private val inflate: (LayoutInflater) -> B) :
    AppCompatActivity() {
    protected lateinit var binding: B
    lateinit var loginRetrofitInterface: LoginRetrofitInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)
        val retrofit = ApplicationClass.getRetrofit()
        loginRetrofitInterface = retrofit.create(LoginRetrofitInterface::class.java)
    }


    //토스트 메세지 띄우기
    fun showCustomToast(message:String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

}