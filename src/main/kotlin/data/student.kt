package data

data class Student (
    val surname: String,
    val firstname: String,
    var visit: Boolean
)

val studentList =
    arrayListOf(
        Student("Жестовский", "Ян", false),
        Student("Дёмина", "Анастасия", false),
        Student("Бейсембаев", "Имир", false),
        Student("Жараспаева", "Джанна", false),
        Student("Буйволова", "Екатерина", false),
        Student("Воробьёв", "Данила", false),
        Student("Купряков", "Даниил", false),
        Student("Султанов", "Алмат", false),
        Student("Сексембаев", "Тимур", false)
    )