import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.application.call
import io.ktor.http.content.static
import io.ktor.http.content.resources
import io.ktor.response.respond
import io.ktor.routing.routing
import io.ktor.routing.get
import io.ktor.server.netty.EngineMain
import io.ktor.freemarker.FreeMarker
import io.ktor.freemarker.FreeMarkerContent
import freemarker.cache.ClassTemplateLoader

fun Application.main() {
    val complimentGenerator = ComplimentGenerator("./src/main/resources/compliments.txt")

    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }

    routing {
        get("/") {
            call.respond(FreeMarkerContent("index.ftl", mapOf("compliment" to complimentGenerator.getCompliment())))
        }
        static("/static") {
            resources("static")
        }
    }
}

fun main(args: Array<String>) = EngineMain.main(args)
