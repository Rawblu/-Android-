import kotlin.math.PI
import kotlin.math.round
open class Shape3D {
    // Вычисления объема
    open fun volume(): Double {
        return 0.0
    }

    // Вычисления площади основания
    open fun baseArea(): Double {
        return 0.0
    }
}

    // Сферы
class Sphere(private val radius: Double) : Shape3D() {
    override fun volume(): Double {
        return round((4 / 3.0) * PI * radius * radius * radius * 100) / 100
    }

    override fun baseArea(): Double {
        return round(PI * radius * radius * 100) / 100
    }
}

    // Цилиндра
class Cylinder(private val radius: Double, private val height: Double) : Shape3D() {
    override fun volume(): Double {
        return round(PI * radius * radius * height * 100) / 100
    }

    override fun baseArea(): Double {
        return round(PI * radius * radius * 100) / 100
    }
}

    // Параллелепипеда
class Cuboid(private val length: Double, private val width: Double, private val height: Double) : Shape3D() {
    override fun volume(): Double {
        return round(length * width * height * 100) / 100
    }

    override fun baseArea(): Double {
        return round(length * width * 100) / 100
    }
}

fun main() {
    val sphere = Sphere(5.0)
    println("Объем сферы: ${sphere.volume()}")
    println("Площадь основания сферы: ${sphere.baseArea()}")

    val cylinder = Cylinder(3.0, 5.0)
    println("Объем цилиндра: ${cylinder.volume()}")
    println("Площадь основания цилиндра: ${cylinder.baseArea()}")

    val cuboid = Cuboid(4.0, 5.0, 6.0)
    println("Объем прямоугольного параллелепипеда: ${cuboid.volume()}")
    println("Площадь основания прямоугольного параллелепипеда: ${cuboid.baseArea()}")
}
