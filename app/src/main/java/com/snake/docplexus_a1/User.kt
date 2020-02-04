package com.snake.docplexus_a1

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {
    @SerializedName("thumbnailUrl")
    @Expose
    var userImage: String? = null
    @SerializedName("authorName")
    @Expose
    var userName: String? = null

    constructor(userImage: String?, userName: String?) {
        this.userImage = userImage
        this.userName = userName
    }
}