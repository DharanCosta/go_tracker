package go.tracker.api

import io.github.cdimascio.dotenv.dotenv
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GoTrackerApplication

fun main(args: Array<String>) {
	val dotenv = dotenv()
	dotenv.entries().forEach { (key, value) -> System.setProperty(key, value).also { println(value) } }

	runApplication<GoTrackerApplication>(*args)


}

