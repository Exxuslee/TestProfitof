package com.exxuslee.data.remote.response

/**
 *  {"type":"text",     "payload":{ "text":"aborum" }}
 *  {"type":"webpage",  "payload":{ "url":"https://www.youtube.com/watch?v=5NV6Rdv1a3I" }}
 */

data class IDResponse(
    val type: String = "",
    val payload: Payload,
)

sealed class Payload {
    data class Text(
        val text: String,
    ) : Payload()

    data class Url(
        val url: String,
    ) : Payload()
}