import java.util.Scanner

fun main() {
    val productos = mutableListOf<Producto>()
    val scanner = Scanner(System.`in`)

    while (true) {
        println("\nMenú de opciones:")
        println("1. Agregar producto")
        println("2. Vender producto")
        println("3. Reponer cantidad")
        println("4. Aplicar descuento")
        println("5. Aumentar precio")
        println("6. Mostrar productos")
        println("7. Calcular valor total del inventario")
        println("8. Eliminar producto")

        print("Seleccione una opción: ")

        when (scanner.nextInt()) {
            1 -> {
                print("Ingrese código: ")
                val codigo = scanner.next()
                print("Ingrese nombre: ")
                val nombre = scanner.next()
                print("Ingrese precio: ")
                val precio = scanner.nextDouble()
                print("Ingrese cantidad: ")
                val stock = scanner.nextInt()
                productos.add(Producto(codigo, nombre, precio, stock))
                println("Producto agregado")
            }

            2 -> {
                print("Ingrese código del producto: ")
                val codigo = scanner.next()
                productos.find { it.codigo == codigo }?.let {
                    print("Ingrese cantidad a vender: ")
                    it.vender(scanner.nextInt())
                } ?: println("Producto no encontrado")
            }

            3 -> {
                print("Ingrese código del producto: ")
                val codigo = scanner.next()
                productos.find { it.codigo == codigo }?.let {
                    print("Ingrese cantidad a reponer: ")
                    it.reponerCantidad(scanner.nextInt())
                } ?: println("Producto no encontrado")
            }

            4 -> {
                print("Ingrese código del producto: ")
                val codigo = scanner.next()
                productos.find { it.codigo == codigo }?.aplicarDescuento() ?: println("Producto no encontrado")
            }

            5 -> {
                print("Ingrese código del producto: ")
                val codigo = scanner.next()
                productos.find { it.codigo == codigo }?.aumentarPrecio() ?: println("Producto no encontrado")
            }

            6 -> {
                if (productos.isEmpty()) println("No hay productos en la lista")
                productos.forEach { it.mostrarInformacion(); println("\n") }
            }

            7 -> {
                val totalInventario = productos.sumOf { it.calcularValorInventario() }
                println("Valor total del inventario: $totalInventario")
            }

            8 -> {
                print("Ingrese código del producto a eliminar: ")
                val codigo = scanner.next()
                if (productos.removeIf { it.codigo == codigo }) {
                    println("Producto eliminado")
                } else {
                    println("Producto no encontrado")
                }
            }
        }
    }
}
