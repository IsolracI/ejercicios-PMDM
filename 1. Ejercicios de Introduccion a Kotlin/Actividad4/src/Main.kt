//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    fun totalAmountOfDigits() {
        println("Escribe un número entre 1 y 99.")
        val numberEntered = readln().toInt()
        var numberOfDigits = 0

        if (numberEntered in 1..<100) {
            for (digit in numberEntered.toString()) {
                numberOfDigits++
            }
            println(numberOfDigits)
        }
        else {
            println("número invalido")
            totalAmountOfDigits()
        }
    }

    totalAmountOfDigits()
}