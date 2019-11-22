package at.fh.swengb.loggingviewsandactivity

enum class LessonType(val description: String) {
    LECTURE("Lecture"),
    PRACTICAL("Practical")
}

class LessonRating(var ratingValue: Int? = null, var feedback: String? = null)

class Lesson(val id: String,
             val name:String,
             var date:String,
             val topic:String,
             val type:LessonType,
             val lecturers: List<Lecturer>,
             val ratings: List<LessonRating>) {
    fun ratingAverage(): Double {
        return 0.0
    }
}

class Lecturer(val name:String)