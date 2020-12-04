package android.example.shoestorend.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    //these are set up for the login LiveData
    var loginId = MutableLiveData<String>()
    var passwordId = MutableLiveData<Any>()


    init {
        Log.i("LoginView", "ViewModel created")

        //initialise the values to null and 0 for the string/int
        loginId.value = null
        passwordId.value = 0

    }

    override fun onCleared() {
        super.onCleared()

        Log.i("LoginView", "ViewModel Destroyed")
    }

}

