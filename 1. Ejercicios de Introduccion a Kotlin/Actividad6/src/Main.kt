import java.util.ArrayList

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    fun ejercicio6() {
        var valuesEntered = ArrayList<Int>()
        var conditionFullfilled = false

        for (i in 1..4) {
            print("Introduce un valor ($i/4):\n")
            valuesEntered.add(readln().toInt())
        }

        for (value in valuesEntered) {
            if (value < 10) {
                conditionFullfilled = true
            }
        }

        if (conditionFullfilled) {
            println("Alguno de los números es menor a diez")
        }
    }

    ejercicio6()
}