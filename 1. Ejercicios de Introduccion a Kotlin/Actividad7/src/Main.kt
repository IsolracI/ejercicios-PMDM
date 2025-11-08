//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    fun ejercicio7() {
        val limit = 500
        var result = 0
        var timesMultiplied = 0
        var allResults = ArrayList<Int>()

        while (result < limit) {
            result = 8 * timesMultiplied++
            allResults.add(result)
        }

        println(allResults)
    }
    ejercicio7()
}