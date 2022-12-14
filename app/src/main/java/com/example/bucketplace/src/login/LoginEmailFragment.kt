package com.example.bucketplace.src.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import com.example.bucketplace.R
import com.example.bucketplace.config.BaseFragment
import com.example.bucketplace.databinding.FragmentLoginEmailBinding
import com.example.bucketplace.src.login.signin.models.SignInResponse
import com.example.bucketplace.src.main.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginEmailFragment :
    BaseFragment<FragmentLoginEmailBinding>(FragmentLoginEmailBinding::bind, R.layout.fragment_login_email) {

    var emailCheck = false
    var pwCheck = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

    }

    private fun initView() {
        binding.edtEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.edtEmail.length() > 0) {
                    emailCheck = true
                    if (pwCheck) {
                        binding.btnLogin.isEnabled = true
                        binding.btnLogin.setBackgroundResource(R.color.colorMainBlue)
                    } else {
                        binding.btnLogin.isEnabled = false
                    }
                } else {
                    binding.btnLogin.isEnabled = false
                }
            }
        })
        binding.edtPw.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.edtPw.length() > 0) {
                    pwCheck = true
                    if (emailCheck) {
                        binding.btnLogin.isEnabled = true
                        binding.btnLogin.setBackgroundResource(R.color.colorMainBlue)
                    } else {
                        binding.btnLogin.isEnabled = false
                    }
                } else {
                    binding.btnLogin.isEnabled = false
                }
            }
        })

        //????????? ?????? ????????? ???
        binding.btnLogin.setOnClickListener {

            val inputEmail = binding.edtEmail.text.toString().trim()
            val inputPw = binding.edtPw.text.toString().trim()

            loginRetrofitInterface.postSignIn(inputEmail, inputPw).enqueue(object : Callback<SignInResponse> {
                override fun onResponse(call: Call<SignInResponse>, response: Response<SignInResponse>) {

                    val br = response.toString()
                    // ???????????? ?????? ????????? ?????? ?????? ????????? ???????????? ???

                    Log.d("????????????", br)

                    val intent = Intent(context, MainActivity::class.java)
                    startActivity(intent)

                }

                override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                    // ???????????? ?????? ??????
                    Log.d("????????????", "dd")
                }
            })

        }

        binding.btnBack.setOnClickListener {

        }
    }

}

