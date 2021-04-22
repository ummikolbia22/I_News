package com.ummi.newsay.model


import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class Source(
    @SerializedName("id")
    val id: String?, // null
    @SerializedName("name")
    val name: String? // Tirto.id
) : Parcelable