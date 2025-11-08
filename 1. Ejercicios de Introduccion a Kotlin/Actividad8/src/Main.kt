//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val cuentaBancaria1 = CuentaBancaria("Juan", 3446, 100.0)

    cuentaBancaria1.pagar(10.0)
    cuentaBancaria1.pagar(10.0)
    cuentaBancaria1.pagar(10.0)
    cuentaBancaria1.pagar(40.0)
    cuentaBancaria1.pagar(30.0)
    cuentaBancaria1.pagar(10.0)
    cuentaBancaria1.pagar(10.0)
    cuentaBancaria1.ingresarDinero(40.0)

    cuentaBancaria1.imprimirHistorico()
}