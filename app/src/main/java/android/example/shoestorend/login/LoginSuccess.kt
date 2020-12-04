package android.example.shoestorend.login

import android.example.shoestorend.R
import android.example.shoestorend.databinding.FragmentLoginSuccessBinding
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI

class LoginSuccess : Fragment() {


    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding: FragmentLoginSuccessBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login_success, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = ("Welcome")

        binding.loginBtn.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_loginSuccess_to_fragmentInstructions)

        }
        //set up the options menu
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            requireView().findNavController()) ||
                super.onOptionsItemSelected(item)
    }
}