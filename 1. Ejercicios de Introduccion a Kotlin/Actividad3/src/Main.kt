//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    fun gradeVerification(semester1: Double, semester2: Double, semester3: Double) {
        val studentGrades = doubleArrayOf(semester1, semester2, semester3)

        if (studentGrades.average() >= 5.0) {
            println("Apto")
        }
        else {
            println("Suspendiste puto >:v")
        }
    }

    gradeVerification(1.0,1.0, 1.0)
    gradeVerification(10.0,1.0, 3.0)
    gradeVerification(4.0,4.0,10.0)
    gradeVerification(7.0,7.0,7.0)
}