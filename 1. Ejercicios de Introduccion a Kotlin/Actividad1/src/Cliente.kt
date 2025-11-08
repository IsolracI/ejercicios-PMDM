class Cliente {
    var nombre: String = ""
    var dinero: Double = 0.0

    constructor(nom: String, dinero: Double) {
        this.nombre = nom
        this.dinero = dinero
    }

    fun comprarArticulo(articulo: Articulo) {
        if (this.dinero >= articulo.precio) {
            this.dinero -= articulo.precio
            println("El articulo ${articulo.nombre} cuesta: ${articulo.precio}\n" +
                    "Esto es lo que te queda: ${this.dinero}")
        }
        else {
            println("${this.nombre}... no tienes dinero suficiente para la compra del articulo")
        }
    }
}