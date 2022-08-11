package me.dio.pipoquinha.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

    @Parcelize
    data class Movie (
        val id: Int,
        val title: String,
        val image: String?,
        val description: String?,
        @SerializedName("release_date")
        val releasedate: String?
            ) : Parcelable
