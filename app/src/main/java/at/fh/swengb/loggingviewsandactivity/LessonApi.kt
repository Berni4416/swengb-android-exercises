package at.fh.swengb.loggingviewsandactivity

import com.squareup.moshi.Moshi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

object LessonApi {
    const val accessToken = "29437807-8579-4d09-87c2-c311875e938f"
    val retrofit: Retrofit
    val retrofitService: LessonApiService
    init {
        val moshi = Moshi.Builder().build()
        retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://www.facebook.com")
            .build()
        retrofitService = retrofit.create(LessonApiService::class.java)
    }
}
interface LessonApiService {
    @GET("/${LessonApi.accessToken}/lessons")
    fun lessons(): Call<List<Lesson>>

    @GET("/${LessonApi.accessToken}/lessons/{id}")
    fun lessonById(@Path("id") lessonId: String) :Call<Lesson>

    @POST("/${LessonApi.accessToken}/lessons/{id}/rate")
    fun rateLesson(@Path("id") lessonId: String, rating: LessonRating)
}