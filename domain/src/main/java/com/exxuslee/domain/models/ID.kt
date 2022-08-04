package com.exxuslee.domain.models

/**
 *  {"type":"text",     "payload":{ "text":"aborum" }}
 *  {"type":"webpage",  "payload":{ "url":"https://www.youtube.com/watch?v=5NV6Rdv1a3I" }}
 */

data class ID(
    val type: String,
    val payload: String,
)