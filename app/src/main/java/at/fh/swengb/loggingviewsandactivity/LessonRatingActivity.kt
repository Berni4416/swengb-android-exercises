package at.fh.swengb.loggingviewsandactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_lesson_rating.*

class LessonRatingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_rating)

        val lessonId = intent.getStringExtra(LessonListActivity.EXTRA_LESSON_ID)

        if (lessonId == null) {
            finish()
        } else {
            LessonRepository.lessonById(id = lessonId, success = {lesson_rating_header.text = it.name}, error = { Log.e("ERROR", it) })

            rate_lesson.setOnClickListener{
                val myRating = lesson_rating_bar.rating.toDouble()
                val myFeedback = lesson_feedback.text.toString()
                val lessonRating = LessonRating(myRating, myFeedback)

                LessonRepository.rateLesson(lessonId, lessonRating)

                setResult(Activity.RESULT_OK)
                finish()

            }
        }


    }
}
