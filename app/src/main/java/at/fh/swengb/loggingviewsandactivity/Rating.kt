package at.fh.swengb.loggingviewsandactivity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Rating(val lesson: String, var rating: Double? = null, var feedback: String? = null)

// second approach
class Rating2(val lesson: String) {
              var rating: Double? = null
              var feedback: String? = null
}