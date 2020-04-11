import data.Student
import data.studentList
import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.js.h1
import kotlinx.html.js.li
import kotlinx.html.js.ol
import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import kotlin.browser.document
import kotlin.dom.clear

var ascending = true

fun main() {
    document.getElementById("root")!!
        .append {
            h1 {
                +"Students"
                onClickFunction = onClickHeader()
            }
            ol {
                attributes += "id" to "listStudents"
                studentList.mapIndexed { index, student ->
                    li {
                        setAttributes(index, student)
                    }
                }
            }
        }
}

private fun changeVisit(student: Student, id: String): (Event) -> Unit {
    return {
        val li = document.getElementById(id)!!
        student.visit = !student.visit
        li.apply {
            className = if (student.visit) "student-visit" else "student-not_visit"
        }
    }
}

private fun onClickHeader(): (Event) -> Unit {
    return {
        val listStudents = document.getElementById("listStudents")!!
        listStudents.clear()
        listStudents.append {
            if (ascending)
                studentList.sortBy { it.firstname }
            else
                studentList.sortByDescending { it.firstname }
            ascending = !ascending
            studentList.mapIndexed { index, student ->
                li {
                    setAttributes(index, student)
                }
            }
        }
    }
}

private fun LI.setAttributes(id: Number, student: Student) {
    +"${student.firstname} ${student.surname}"
    attributes += "id" to "student-${id}"
    classes = if (student.visit) setOf("student-visit") else setOf("student-not_visit")
    onClickFunction = changeVisit(student, "student-${id}")
}
