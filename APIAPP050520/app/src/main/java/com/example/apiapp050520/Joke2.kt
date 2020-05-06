package com.example.apiapp050520

import com.google.gson.annotations.SerializedName

class Joke2 (
    @SerializedName("id")
    var id : String,
    @SerializedName("joke")
    var joke : String,
    @SerializedName("status")
    var status : Int
)