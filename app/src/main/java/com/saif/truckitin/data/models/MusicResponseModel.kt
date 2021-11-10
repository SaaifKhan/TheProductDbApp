package com.saif.truckitin.data.models

data class MusicResponseModel(
    val resultCount: Int,
    val results: List<MusicModel>?,
)