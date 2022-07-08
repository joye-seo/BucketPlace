package com.example.bucketplace.src.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.bucketplace.R
import com.example.bucketplace.config.BaseFragment
import com.example.bucketplace.databinding.FragmentLoginMainBinding
import com.example.bucketplace.src.login.signup.SignUpActivity

class LoginMainFragment :
    BaseFragment<FragmentLoginMainBinding>(FragmentLoginMainBinding::bind, R.layout.fragment_login_main) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView()= with(binding){

        btnKakaoSignUp.setOnClickListener {
// 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
//            LoginClient.instance.run {
//                if (isKakaoTalkLoginAvailable(this@LoginActivity)) {
//                    loginWithKakaoAccount(this@LoginActivity, callback = callback)
//                } else loginWithKakaoAccount(this@LoginActivity, callback = callback)
//            }
//            updateKakaoLoginUi()
        }
        btnEmailLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginMainFragment_to_loginEmailFragment)
        }
        btnSignUp.setOnClickListener {
            startActivity(Intent(context, SignUpActivity::class.java))

        }
        btnContact.setOnClickListener {

        }
    }
}