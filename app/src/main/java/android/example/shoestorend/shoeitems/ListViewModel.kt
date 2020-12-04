package android.example.shoestorend.shoeitems

import android.example.shoestorend.data.Shoes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {

    private val _shoesList = MutableLiveData<Shoes>()
    val shoeList: LiveData<Shoes> get() = _shoesList

    private var _newShoe = MutableLiveData<MutableList<Shoes>>()
    val newShoe: LiveData<MutableList<Shoes>> get() = _newShoe

    private val _navigate = MutableLiveData<Boolean>()
    val navigate: LiveData<Boolean>
        get() = _navigate

    //initialise the shoelist for display in fragment
    init {
        _shoesList.value = Shoes("", "", 0.0, "")
        _newShoe.value = shoesList()
        _navigate.value = false
    }

    fun add() {
        _newShoe.value?.add(_shoesList.value!!)
        _navigate.value = true
        _shoesList.value = Shoes("", "", 0.0, "")
    }


    private fun <T> MutableLiveData<MutableList<T>>.addNewItem(item: T) {
        val oldValue = this.value ?: mutableListOf()
        oldValue.add(item)
        this.value = oldValue
    }

    fun resetNav() {
        _navigate.value = false
    }

}

//temporary list of shoes for display
private fun shoesList(): MutableList<Shoes> {
    return mutableListOf(
        (Shoes("Perrys", "Perrys-Shoes", 4.5, "Fashionable shoes for street cred")),
        (Shoes("Bolt-Go", "Nike", 5.5, "Sprint running shoes. Likened to the runner Bolt")),
        (Shoes("New Buck", "Adidas", 6.0, "Rugged outdoor shoe")),
        (Shoes("Air Force 1", "Jordans", 3.5, "Shoe with a full length, cushion bubble sole")))
}
