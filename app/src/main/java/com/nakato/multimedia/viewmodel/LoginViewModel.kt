package com.nakato.multimedia.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nakato.multimedia.model.LoginRequest
import com.nakato.multimedia.model.LoginResponse
import com.nakato.multimedia.repository.LoginRepository
import kotlinx.coroutines.launch


class LoginViewModel : ViewModel() {
    val loginLiveData = MutableLiveData<LoginResponse>()
    val errorLiveData = MutableLiveData<String>()
    val loginRepo = LoginRepository()

    fun login (loginRequest: LoginRequest){
        viewModelScope.launch {
            val response = loginRepo.login(loginRequest)
            if (response.isSuccessful){
                loginLiveData.postValue(response.body())
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}