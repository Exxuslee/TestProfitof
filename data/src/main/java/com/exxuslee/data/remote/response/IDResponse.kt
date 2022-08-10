package com.exxuslee.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Generated


/**
 *  {"type":"text",     "payload":{ "text":"aborum" }}
 *  {"type":"webpage",  "payload":{ "url":"https://www.youtube.com/watch?v=5NV6Rdv1a3I" }}
 */

@Generated("jsonschema2pojo")
class IDResponse {
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("payload")
    @Expose
    var payload: Payload? = null
}

@Generated("jsonschema2pojo")
class Payload {
    @SerializedName("text")
    @Expose
    val text: String = ""
    @SerializedName("url")
    @Expose
    val url: String = ""
}