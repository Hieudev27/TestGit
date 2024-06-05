package com.example.dangtrunghuy

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dangtrunghuy.databinding.ActivityRegisterBinding

private const val TAG = "RegisterActivity"
class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnRegister.setOnClickListener {
            if (validateRegister()){
                val user = User(binding.edtUserName.text.toString(),
                    binding.edtUserEmail.text.toString(),
                    binding.edtPhone.text.toString(),
                    binding.edtPassword.text.toString(),
                    binding.edtCountry.text.toString())
                UserLogin.email = user.email
                UserLogin.password = user.password
                Toast.makeText(this,"Dang ky thanh cong",Toast.LENGTH_SHORT).show()
                Toast.makeText(this,user.toString(),Toast.LENGTH_SHORT).show()
                var intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }


    fun validateRegister():Boolean{
        binding.apply {
            if (validateUserName(edtUserName.text.toString()))
                Log.e(TAG, "onCreate: Username must not contain special characters or spaces")
            else if (!validateEmail(edtUserEmail.text.toString()))
                Log.e(TAG, "onCreate: Email extension is @apero.vn")
            else if (!validatePhoneNumber(edtPhone.text.toString()))
                Log.e(TAG,"onCreate: Phone number only includes numbers, the number of characters is 10-11",)
            else if (!validatePassword(edtPassword.text.toString()))
                Log.e(TAG, "onCreate: Password must not contain special characters")
            else if (edtPassword.text.toString() != edtConfirmPW.text.toString())
                Log.e(TAG, "onCreate: Password dissimilarity")
            else
                return true
            return false
        }
    }
}