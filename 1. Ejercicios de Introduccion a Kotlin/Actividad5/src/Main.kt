//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    fun digitsCounter(numberGiven: Int) {
        var numberOfDigits = 0
        var validNumber = false

        if (numberGiven <= 0) {
            validNumber = false
        }
        else {
            for (digit in numberGiven.toString()) {
                numberOfDigits++
                validNumber = true
            }
        }

        if (numberOfDigits < 3 && validNumber) {
            println("El número $numberGiven es valido, muchas gracias")
        }
        else {
            println("El número $numberGiven es invalido, por favor, verifica de nuevo")
        }
    }
    digitsCounter(3)
    digitsCounter(-1)
    digitsCounter(1000)
    digitsCounter(10)
    digitsCounter(0)
}