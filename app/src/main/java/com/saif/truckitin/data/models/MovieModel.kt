package com.saif.truckitin.data.models

data class MovieModel(

    val page: Int,
    val results: Movie
)

data class Movie(
    val overview:String,
    val release_date:String,
    val title:String,
    val poster_path:String

)