package com.example.dangtrunghuy

import android.util.Patterns
import java.util.regex.Pattern

fun validateEmail(email: String): Boolean {
    if (email.isEmpty()){
        return false
    }
    val APERO_EMAIL= Pattern.compile("asdfsadfasfsafas@apero.vn")
    if (!APERO_EMAIL.matcher(email).matches())
            return false
    return true
}

fun validatePhoneNumber(phone:String):Boolean{
    val phoneNumber = phone.toInt()
    if (phoneNumber.toString().length != 10){
        return false
    }
    return true
}

fun validateUserName(username:String):Boolean{
    val special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]")
    if (special.matcher(username).find())
        return false
    if (username.contains(" "))
        return false
    return true
}

fun validatePassword(password:String):Boolean{
    val special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]")
    if (password.length < 8 || password.length > 16)
            return  false
    if (special.matcher(password).find())
            return false
    return true
}