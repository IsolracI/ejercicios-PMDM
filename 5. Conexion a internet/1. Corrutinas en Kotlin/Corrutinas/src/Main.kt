import kotlinx.coroutines.*
import java.lang.IllegalArgumentException
import kotlin.system.*

fun main() {
    runBlocking {
        println("Weather forecast")
        println(getWeatherReport())
        println("Have a good day!")
    }
}

suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}

suspend fun getTemperature(): String {
    delay(1000)
    throw AssertionError("Temperature is invalid")
    return "30\u00b0C"
}

suspend fun getWeatherReport() = coroutineScope {
    val forecast: Deferred<String> = async { getForecast() }
    val temperature: Deferred<String> = async { getTemperature()  }

    delay(200)
    temperature.cancel()

    forecast.await()
}
