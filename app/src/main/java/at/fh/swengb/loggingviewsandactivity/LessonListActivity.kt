package at.fh.swengb.loggingviewsandactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.activity_lesson_list.*
import kotlinx.android.synthetic.main.activity_rating.*


class LessonListActivity : AppCompatActivity() {
    companion object {
        val EXTRA_LESSON_ID = "LESSON_ID_EXTRA"
        val ADD_OR_EDIT_RATING_REQUEST = 1
    }
    val lessonAdapter = LessonAdapter() {
        Toast.makeText(this,"Lesson with name ${it.name} clicked", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, LessonRatingActivity::class.java)
        intent.putExtra(EXTRA_LESSON_ID, it.id)

        startActivityForResult(intent, ADD_OR_EDIT_RATING_REQUEST)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_list)

        LessonRepository.lessonsList(
            success = {
                // handle success
                lessonAdapter.updateList(it)
            },
            error = {
                // handle error
                Log.e("API_CALL", it)
            }
        )
        lesson_recycler_view.layoutManager = LinearLayoutManager(this)
        lesson_recycler_view.adapter = lessonAdapter

        parseJson()
        //Thread.sleep(5000)
        SleepyAsyncTask().execute()
        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == ADD_OR_EDIT_RATING_REQUEST && resultCode == Activity.RESULT_OK) {
            //lessonAdapter.updateList(LessonRepository.lessonsList())
        }
    }

    fun parseJson() {
        val moshi = Moshi.Builder().build()
        val jsonAdapter = moshi.adapter<Lesson>(Lesson::class.java)
        val json = ("""
            {
            "id": "1",
            "name": "Lecture 0",
            "date": "09.10.2019",
            "topic": "Introduction",
            "type": "LECTURE",
            "lecturers": [
            {
                "name": "Lukas Bloder"
            },
            {
                "name": "Sanja Illes"
            }
            ],
            "ratings": []
            }
            """)

        val result = jsonAdapter.fromJson(json)
        Log.e("json", result.toString())

    }




}
