package com.example.apiapp

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataResponse(

	@field:SerializedName("DataResponse")
	val dataResponse: List<DataResponseItem>? = null
) : Parcelable

@Parcelize
data class DataResponseItem(

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
) : Parcelable
