package android.example.shoestorend.shoeitems

import android.app.Activity
import android.content.Context
import android.example.shoestorend.R
import android.example.shoestorend.databinding.FragmentShoeDetailBinding
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

class ShoeDetail : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val listViewModel: ListViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        //set up link to viewmodel and observer
        binding.listviewmodel = listViewModel
        binding.lifecycleOwner = this

        setUpInputs()

        binding.cancelitem.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_shoeDetail_to_shoeList)
            listViewModel.resetNav()
        }

        //This clickListener is now handled within the xml view via databinding
//        binding.saveitem.setOnClickListener {
//            listViewModel.add()
//        }

        listViewModel.navigate.observe(viewLifecycleOwner, Observer { saved ->
            if (saved) {
                findNavController().navigate(R.id.action_shoeDetail_to_shoeList)
                listViewModel.resetNav()
            }
            hideKeyboard()
        })
        return binding.root
    }

    //function for entering shoes
    private fun setUpInputs() {
        binding.editshoename.addTextChangedListener(textWatcher)
        binding.editcompanyname.addTextChangedListener(textWatcher)
        binding.editshoesize.addTextChangedListener(textWatcher)
        binding.editdesc.addTextChangedListener(textWatcher)
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            binding.saveitem.isEnabled =
                binding.editshoename.text.isNotEmpty() &&
                        binding.editcompanyname.text.isNotEmpty() &&
                        binding.editshoesize.text.isNotEmpty() &&
                        binding.editdesc.text.isNotEmpty()
        }
    }


    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}



