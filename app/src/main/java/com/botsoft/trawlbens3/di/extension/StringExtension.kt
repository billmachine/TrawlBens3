package com.botsoft.trawlbens3.di.extension

import java.text.SimpleDateFormat

class StringExtension {
    fun defaultDateFormat(
        input: String
    ): String {
        val parser = SimpleDateFormat("yyyy-MM-dd")
        val formatter = SimpleDateFormat("dd MMM yyyy")
        val output = formatter.format(parser.parse(input))
        return output
    }
}