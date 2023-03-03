package com.example.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuTypeModel(
    var idType: Long,
    var type: String
):Parcelable
