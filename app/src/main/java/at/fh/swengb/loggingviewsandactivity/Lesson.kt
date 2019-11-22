package at.fh.swengb.loggingviewsandactivity

class Lesson(val id: String,
             val name:String,
             var date:String,
             val topic:String,
             val type:LessonType,
             val lecturers: List<Lecturer>,
             val ratings: MutableList<LessonRating>) {
    fun ratingAverage(): Double {

        var average = ratings.map { it.ratingValue }.average()
       // val average2 = ratings.sumByDouble { it.ratingValue } / ratings.count()
        if (average.isNaN()) {
            average = 0.0
        }

        return average
    }
}