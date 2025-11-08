//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    fun buyingItem() {
        println("Precio del articulo: ")
        val itemPrice = readln().toDouble()
        println("Cuanto dinero tiene el cliente: ")
        var clientMoney = readln().toDouble()

        if (itemPrice <= clientMoney) {
            clientMoney -= itemPrice
            println("Esto es lo que debes pagar: $itemPrice\n" +
                    "Esto es lo que te queda: $clientMoney\n")
        }
        else {
            println("No tienes dinero suficiente para comprar este item\n")
        }
    }

    fun buyingItem2(cliente: Cliente, articulo: Articulo) {
        if (articulo.precio <= cliente.dinero) {
            cliente.dinero -= articulo.precio
            println("Esto es lo que debes pagar: ${articulo.precio}\n" +
                    "Esto es lo que te queda: ${cliente.dinero}\n")
        }
        else {
            println("\n${cliente.nombre} no tiene dinero suficiente para la compra de este item\n")
        }
    }

    val fresas = Articulo("fresas", 5.5)
    val cliente1 = Cliente("Juan", 50.0)

    val lamborghini = Articulo("lamborghini", 4999.9)
    val cliente2 = Cliente("Pedro", 500.0)

    buyingItem()
    buyingItem()

    buyingItem2(cliente1, fresas)
    cliente1.comprarArticulo(fresas)

    buyingItem2(cliente2, lamborghini)
    cliente2.comprarArticulo(lamborghini)
}