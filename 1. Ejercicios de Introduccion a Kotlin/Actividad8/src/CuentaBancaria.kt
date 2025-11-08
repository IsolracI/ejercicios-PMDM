class CuentaBancaria {
    val propietario: String
    val numeroCuenta: Int
    var saldo: Double
    var activa: Boolean = true
    var historico: ArrayList<String>

    constructor(propietario: String, numeroCuenta: Int, saldo: Double) {
        this.propietario = propietario
        this.numeroCuenta = numeroCuenta
        this.saldo = saldo
        historico = ArrayList()

        if (saldo >= 0.0) {
            activa = true
        }
    }

    fun ingresarDinero(cantidad: Double) {
        this.saldo += cantidad

        if (saldo > 0.0 && !activa) {
            activa = true
        }

        if (activa) {
            this.historico.add("se ingresaron $cantidad€ a la cuenta $numeroCuenta")
        }
    }

    fun pagar(cantidad: Double) {
        if (activa && cantidad <= this.saldo) {
            this.saldo -= cantidad
            this.historico.add("el usuario $propietario con cuenta $numeroCuenta realizó una transacción en donde pagó $cantidad€. Saldo actual: $saldo")
            if (saldo < 0.0) {
                activa = false
            }
        }
        else {
            this.historico.add("No se pudo realizar la transacción")
        }
    }

    fun imprimirHistorico() {
        for (accion in this.historico) {
            println(accion)
        }
    }
}
