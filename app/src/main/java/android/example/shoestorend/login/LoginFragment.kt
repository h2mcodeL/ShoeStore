package android.example.shoestorend.login

import android.app.Activity
import android.content.Context
import android.example.shoestorend.R
import android.example.shoestorend.databinding.LoginMainBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController

class LoginFragment : Fragment() {

    //we set up the viewModel variable here
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        //we use dataBinding to get access to all view items, initialise here
        val binding: LoginMainBinding = DataBindingUtil.inflate(
            inflater, R.layout.login_main, container, false)

        //set activity title to Login
        (activity as AppCompatActivity).supportActionBar?.title = ("Login")

        //we get a reference to the ViewModel and initiate it here
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.loginbtn.setOnClickListener { view: View ->
            //we simply allow login as at this stage app is not focussed on user login control
            view.findNavController().navigate(R.id.action_login_destination_to_loginSuccess)
        }

        binding.signupbtn.setOnClickListener { view: View ->

            //sign up button navigates to the welcome fragment
            view.findNavController().navigate(R.id.action_login_destination_to_loginSuccess)

            hideKeyboard()
        }
        return binding.root
    }

    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}