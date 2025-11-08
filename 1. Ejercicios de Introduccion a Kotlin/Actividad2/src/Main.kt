import java.lang.reflect.Array
import java.util.ArrayList

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    fun sumAndAvgValues() {
        var valuesEntered = ArrayList<Int>()

        for (i in 1..4) {
            print("Introduce un valor:\n")
            valuesEntered.add(readln().toInt())
        }

        println("Suma de los valores dados: ${valuesEntered.sum()}\n" +
                "Promedio de los valores dados: ${valuesEntered.average()}")
    }

    sumAndAvgValues()
}