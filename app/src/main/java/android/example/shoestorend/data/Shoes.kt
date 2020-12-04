package android.example.shoestorend.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoes (
    var shoeName: String, var companyName: String, var shoeSize: Double,
    var descriptionInfo: String) : Parcelable
