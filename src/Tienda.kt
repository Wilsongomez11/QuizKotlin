class Tienda {
    private val productos = mutableListOf<Producto>()

    fun agregarProducto(producto: Producto) {
        productos.add(producto)
    }

    fun eliminarProducto(codigo: String) {
        val iterator = productos.iterator()
        while (iterator.hasNext()) {
            if (iterator.next().codigo == codigo) {
                iterator.remove()
                println("Producto eliminado.")
                return
            }
        }
        println("Producto no encontrado.")
    }

    fun mostrarInventario() {
        var totalInventario = 0.0
        for (producto in productos) {
            producto.mostrarInformacion()
            totalInventario += producto.calcularValorInventario()
            println("--------------------")
        }
        println("Valor total del inventario: $totalInventario")
    }
}