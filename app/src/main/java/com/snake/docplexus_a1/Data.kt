package com.snake.docplexus_a1

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.json.JSONObject

class Data {
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("featuredAttachmentUrl")
    @Expose
    var image: String? = null
    @SerializedName("creationDate")
    @Expose
    var createdAt: String? = null
    @SerializedName("answerCount")
    @Expose
    var comment: Int = 0
    @SerializedName("voteCount")
    @Expose
    var vote: Int = 0
    @SerializedName("viewCount")
    @Expose
    var view: Int = 0
    @SerializedName("user")
    @Expose
    var user: User? = null
    @SerializedName("shortBodyText")
    @Expose
    var body: String? = null
    @SerializedName("viewed")
    @Expose
    var viewed: Boolean = false
    @SerializedName("voted")
    @Expose
    var voted: Boolean = false

    constructor(
        title: String?,
        image: String?,
        createdAt: String?,
        comment: Int,
        vote: Int,
        view: Int,
        user: User,
        body: String?,
        viewed: Boolean,
        voted: Boolean
    ) {
        this.title = title
        this.image = image
        this.createdAt = createdAt
        this.comment = comment
        this.vote = vote
        this.view = view
        this.user = user
        this.body = body
        this.viewed = viewed
        this.voted = voted
    }
}