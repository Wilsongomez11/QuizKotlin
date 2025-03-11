class Producto(val codigo: String, val nombre: String, var precio: Double, var capacidad: Int) {

    fun vender(cantidad: Int) {
        if (cantidad > 0 && cantidad <= capacidad) {
            capacidad -= cantidad
            println("Venta realizada. Stock actual: $capacidad")
        } else {
            println("No hay suficiente stock disponible")
        }
    }

    fun reponerCantidad(cantidad: Int) {
        if (cantidad > 0) {
            capacidad += cantidad
            println("cantidad renovada\n Nuevo stock: $capacidad")
        }
    }

    fun aplicarDescuento() {
        precio -= precio * 0.02
        println("Nuevo precio con descuento: $precio")
    }

    fun aumentarPrecio() {
        precio += precio * 0.06
        println("Nuevo precio aumentado: $precio")
    }

    fun mostrarInformacion() {
        println("Código: $codigo")
        println("Nombre: $nombre")
        println("Precio: $precio")
        println("Stock: $capacidad")
    }

    fun calcularValorInventario(): Double {
        return capacidad * precio
    }
}