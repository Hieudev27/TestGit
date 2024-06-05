package com.example.dangtrunghuy

import android.util.Patterns
import java.util.regex.Pattern

fun validateEmail(email: String): Boolean {
    if (email.isEmpty()){
        return false
    }
    val APERO_EMAIL_PATTERN = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}"+"\\@apero.vn")
    if (!APERO_EMAIL_PATTERN.matcher(email).matches())
            return false
    return true
}

fun validatePhoneNumber(phone:String):Boolean{
    val phoneNumber = phone.toInt()
    if (phoneNumber.toString().length != 10 || phoneNumber.toString().isEmpty() || phoneNumber.toString().length != 10){
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