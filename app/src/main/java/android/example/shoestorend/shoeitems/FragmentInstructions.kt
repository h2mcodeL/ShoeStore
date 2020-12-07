package android.example.shoestorend.shoeitems

import android.example.shoestorend.R
import android.example.shoestorend.databinding.FragmentInstructionsBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController


class FragmentInstructions : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        //link to Onboarding fragment
        val binding: FragmentInstructionsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_instructions, container, false
        )

        //set fragment onboarding title to Shoe Store
        (activity as AppCompatActivity).supportActionBar?.title = ("Shoe Store")

        //use Lambda for nav controller
        binding.button.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.shoeList)
        }

        return binding.root
    }


}