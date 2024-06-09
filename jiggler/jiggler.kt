import java.awt.Robot
import kotlin.math.sin
import kotlin.math.PI

fun main() {
    val robot = Robot()
    val screenSize = java.awt.Toolkit.getDefaultToolkit().screenSize
    val width = screenSize.width
    val height = screenSize.height / 2 - 10
    var x = 0

    println("Por quantos minutos você quer que o mouse se mova?")
    val minutes = readLine()?.toIntOrNull() ?: 0
    val endTime = System.currentTimeMillis() + minutes * 60_000

    while (System.currentTimeMillis() < endTime) {
        if (x > width) {
            x = 0
        }
        for (i in 0 until width) {
            val y = (height * sin((2 * PI * i) / width) + height).toInt()
            robot.mouseMove(i, y)
            Thread.sleep(10)  // Small delay to slow down the mouse movement
        }
        x++
    }
}
