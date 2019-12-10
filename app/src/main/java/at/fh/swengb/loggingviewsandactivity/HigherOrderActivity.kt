package at.fh.swengb.loggingviewsandactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class HigherOrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_order)

        myHigherOrderFunction( {integerInput -> integerInput + 606})
        myHigherOrderFunction( fun(integerInput: Int):Int = integerInput + 606 )

        kotlinHigherOrderWithList()
    }
    private fun myHigherOrderFunction(param: (Int) -> Int) {
        if (param(6) == 612) {
            Log.e("HIGHER_ORDER", "Congrats, your first lambda works :)")
        }
    }

    private fun kotlinHigherOrderWithList() {
        val list = LessonRepository.lessonsList()


        val heldByBloder = list.filter{it.lecturers.any{ lecturer -> lecturer.name.equals("Lukas Bloder")  }}

        Log.e("HIGHER_ORDER",heldByBloder.toString())
        // filter the lesson list,
        // so that you create a list of
        // all lessons held by Lukas Bloder
        // print the list to logcat
        // notice something weird in the output?

        val topicMap = list.map { it.topic to listOf<Lesson>(it) }.toMap()
        Log.e("HIGHER_ORDER", topicMap.toString())
        // use Kotlins built-in higher order functions
        // on list in order to get a Map<String, List<Lesson>>
        // with the map Key being the lesson topic
        // print the resulting map to logcat

        val avgLecture = ( list.filter { it.type.description.equals("Lecture") }.map { it.ratings.map { it.ratingValue }.sum() }.sum() ) / ( list.map { it.ratings.count() }.sum().toDouble() )
        Log.e("HIGHER_ORDER", avgLecture.toString())
        // calculate the average rating of all LECTURES
        // print the result to logcat

    }
}
