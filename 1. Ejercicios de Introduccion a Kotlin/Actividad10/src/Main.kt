//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    fun numericalValue(): Int {
        return readln().toInt()
    }

    fun sumOfValues(value1: Int, value2: Int): Int {
        return value1 + value2
    }

    fun ejercicio10() {
        println("necesitamos dos valores numéricos.\n" +
                "Por favor, ingrese el primero:")
        val number1: Int = numericalValue()
        println("Ahora ingrese el segundo:")
        val number2: Int = numericalValue()

        println("Este es el resultado de la suma: ${sumOfValues(number1, number2)}\n" +
                "Ahora, bye bye")
    }

    ejercicio10()
}