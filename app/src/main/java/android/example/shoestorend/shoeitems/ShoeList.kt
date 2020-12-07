package android.example.shoestorend.shoeitems

import android.example.shoestorend.R
import android.example.shoestorend.databinding.FragmentShoeListBinding
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.shoe_layout.view.*

class ShoeList : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel by activityViewModels<ListViewModel>()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        binding.shoesviewmodel = viewModel
        binding.lifecycleOwner = this

        binding.fab.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_shoeList_to_shoeDetail)
        }

        viewModel.newShoe.observe(viewLifecycleOwner, androidx.lifecycle.Observer { shoeList ->

            shoeList.forEach { shoeList ->

                val view: View = layoutInflater.inflate(R.layout.shoe_layout, null, false)

                view.shoe_name.text = shoeList.shoeName
                view.company_name.text = shoeList.companyName
                view.size_name.text = shoeList.shoeSize.toString()
                view.shoe_description.text = shoeList.descriptionInfo

                binding.layout1.addView(view)
            }
        })

        //set up the options menu
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.logout, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) ||
                super.onOptionsItemSelected(item)
    }

}
