package com.example.bucketplace.src.login.signup

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.bucketplace.R
import com.example.bucketplace.config.BaseActivity
import com.example.bucketplace.databinding.ActivitySignUpBinding
import com.example.bucketplace.src.login.LoginActivity
import com.example.bucketplace.src.login.signup.models.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(ActivitySignUpBinding::inflate) {

    var emailCheck = false
    var pwCheck = false
    var pwRepeatCheck = false
    var nicknameCheck = false
    var agreeCheck = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.cbAll.setOnClickListener {
            if(binding.cbAll.isChecked){
                binding.cbAge.isChecked = true
                binding.cbAgree.isChecked = true
                binding.cbEvent.isChecked = true
                binding.cbService.isChecked = true
                binding.tvAgreeError.visibility = View.GONE
                binding.bdAgree.setBackgroundResource(R.drawable.white_edit_text)
                agreeCheck = true
                if(emailCheck and pwCheck and pwRepeatCheck and nicknameCheck and agreeCheck) {
                    binding.btnSignUp.isEnabled = true
                    binding.btnSignUp.setBackgroundResource(R.color.colorMainBlue)
                }
                else{
                    binding.btnSignUp.isEnabled = false
                }
            }
            else{
                binding.cbAge.isChecked = false
                binding.cbAgree.isChecked = false
                binding.cbEvent.isChecked = false
                binding.cbService.isChecked = false
                binding.tvAgreeError.visibility = View.VISIBLE
                binding.bdAgree.setBackgroundResource(R.drawable.red_edit_text)
                agreeCheck = false
                binding.btnSignUp.isEnabled = false
            }
        }

        binding.cbAge.setOnClickListener {
            if(binding.cbAge.isChecked and binding.cbAgree.isChecked and binding.cbService.isChecked){
                binding.tvAgreeError.visibility = View.GONE
                binding.bdAgree.setBackgroundResource(R.drawable.white_edit_text)
                agreeCheck = true
                if(emailCheck and pwCheck and pwRepeatCheck and nicknameCheck and agreeCheck) {
                    binding.btnSignUp.isEnabled = true
                    binding.btnSignUp.setBackgroundResource(R.color.colorMainBlue)
                }
                else{
                    binding.btnSignUp.isEnabled = false
                }
            }
            else{
                binding.tvAgreeError.visibility = View.VISIBLE
                binding.bdAgree.setBackgroundResource(R.drawable.red_edit_text)
                agreeCheck = false
                binding.btnSignUp.isEnabled = false
            }
        }
        binding.cbAgree.setOnClickListener {
            if(binding.cbAge.isChecked and binding.cbAgree.isChecked and binding.cbService.isChecked){
                binding.tvAgreeError.visibility = View.GONE
                binding.bdAgree.setBackgroundResource(R.drawable.white_edit_text)
                agreeCheck = true
                if(emailCheck and pwCheck and pwRepeatCheck and nicknameCheck and agreeCheck) {
                    binding.btnSignUp.isEnabled = true
                    binding.btnSignUp.setBackgroundResource(R.color.colorMainBlue)
                }
                else{
                    binding.btnSignUp.isEnabled = false
                }
            }
            else{
                binding.tvAgreeError.visibility = View.VISIBLE
                binding.bdAgree.setBackgroundResource(R.drawable.red_edit_text)
                agreeCheck = false
                binding.btnSignUp.isEnabled = false
            }
        }
        binding.cbService.setOnClickListener {
            if(binding.cbAge.isChecked and binding.cbAgree.isChecked and binding.cbService.isChecked){
                binding.tvAgreeError.visibility = View.GONE
                binding.bdAgree.setBackgroundResource(R.drawable.white_edit_text)
                agreeCheck = true
                if(emailCheck and pwCheck and pwRepeatCheck and nicknameCheck and agreeCheck) {
                    binding.btnSignUp.isEnabled = true
                    binding.btnSignUp.setBackgroundResource(R.color.colorMainBlue)
                }
                else{
                    binding.btnSignUp.isEnabled = false
                }
            }
            else{
                binding.tvAgreeError.visibility = View.VISIBLE
                binding.bdAgree.setBackgroundResource(R.drawable.red_edit_text)
                agreeCheck = false
                binding.btnSignUp.isEnabled = false
            }
        }

        binding.edtEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                val ps: Pattern = Pattern.compile("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$")

                if (!ps.matcher(binding.edtEmail.text.toString()).matches()) {
                    if (binding.edtEmail.text.toString().isEmpty()) {
                        binding.tvEmailError.visibility = View.VISIBLE
                        binding.bgEmail.setBackgroundResource(R.drawable.red_edit_text)
                        emailCheck = false
                        binding.btnSignUp.isEnabled = false
                    }
                    else {
                        binding.tvEmailError.visibility = View.VISIBLE
                        binding.bgEmail.setBackgroundResource(R.drawable.red_edit_text)
                        emailCheck = false
                        binding.btnSignUp.isEnabled = false
                    }
                }
                else{
                    binding.tvEmailError.visibility = View.GONE
                    binding.bgEmail.setBackgroundResource(R.drawable.white_edit_text)
                    emailCheck = true
                    if(emailCheck and pwCheck and pwRepeatCheck and nicknameCheck and agreeCheck) {
                        binding.btnSignUp.isEnabled = true
                        binding.btnSignUp.setBackgroundResource(R.color.colorMainBlue)
                    }
                    else{
                        binding.btnSignUp.isEnabled = false
                    }
                }
            }
        })

        binding.edtPw.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.edtPw.length() < 8) {
                    binding.tvPwError.visibility = View.VISIBLE
                    binding.bgPw.setBackgroundResource(R.drawable.red_edit_text)
                    pwCheck = false
                    binding.btnSignUp.isEnabled = false
                }
                else{
                    binding.tvPwError.visibility = View.GONE
                    binding.bgPw.setBackgroundResource(R.drawable.white_edit_text)
                    pwCheck = true
                    if(emailCheck and pwCheck and pwRepeatCheck and nicknameCheck and agreeCheck) {
                        binding.btnSignUp.isEnabled = true
                        binding.btnSignUp.setBackgroundResource(R.color.colorMainBlue)
                    }
                    else{
                        binding.btnSignUp.isEnabled = false
                    }
                }
            }
        })
        binding.edtPwRepeat.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.edtPwRepeat.text.toString().isEmpty()) {
                    binding.tvPwRepeatError.visibility = View.VISIBLE
                    binding.bgPwRepeat.setBackgroundResource(R.drawable.red_edit_text)
                    pwRepeatCheck = false
                    binding.btnSignUp.isEnabled = false
                }
                else if (binding.edtPw.text.toString() != binding.edtPwRepeat.text.toString()) {
                    binding.tvPwRepeatError.visibility = View.VISIBLE
                    binding.bgPwRepeat.setBackgroundResource(R.drawable.red_edit_text)
                    pwRepeatCheck = false
                    binding.btnSignUp.isEnabled = false
                }
                else{
                    binding.tvPwRepeatError.visibility = View.GONE
                    binding.bgPwRepeat.setBackgroundResource(R.drawable.white_edit_text)
                    pwRepeatCheck = true
                    if(emailCheck and pwCheck and pwRepeatCheck and nicknameCheck and agreeCheck) {
                        binding.btnSignUp.isEnabled = true
                        binding.btnSignUp.setBackgroundResource(R.color.colorMainBlue)
                    }
                    else{
                        binding.btnSignUp.isEnabled = false
                    }
                }
            }
        })
        binding.edtNickname.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if ((binding.edtNickname.length() < 2) or (binding.edtNickname.length() > 15)) {
                    binding.tvNicknameError.visibility = View.VISIBLE
                    binding.bgNickname.setBackgroundResource(R.drawable.red_edit_text)
                    binding.btnSignUp.isEnabled = false
                    nicknameCheck = false
                }
                else{
                    binding.tvNicknameError.visibility = View.GONE
                    binding.bgNickname.setBackgroundResource(R.drawable.white_edit_text)
                    nicknameCheck = true
                    if(emailCheck and pwCheck and pwRepeatCheck and nicknameCheck and agreeCheck) {
                        binding.btnSignUp.isEnabled = true
                        binding.btnSignUp.setBackgroundResource(R.color.colorMainBlue)
                    }
                    else{
                        binding.btnSignUp.isEnabled = false
                    }
                }
            }
        })

        binding.btnSignUp.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPw.text.toString()
            val passwordCheck = binding.edtPwRepeat.text.toString()
            val nickname = binding.edtNickname.text.toString()

            loginRetrofitInterface.postSignUp(email, password,passwordCheck,nickname).enqueue(object : Callback<SignUpResponse>{
                override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
                    startActivity(Intent(this@SignUpActivity,LoginActivity::class.java))
                    finish()
                }

                override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

}