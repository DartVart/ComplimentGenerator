import java.io.File
import java.io.FileNotFoundException
import kotlin.random.Random

/**
 * Generates compliments from a file.
 * In the file, each compliment is written in a separate line.
 * */
class ComplimentGenerator(pathToFileWithCompliments: String) {
    private var availableCompliments: List<String>

    init {
        val fileWithCompliments = File(pathToFileWithCompliments)
        if (!fileWithCompliments.exists()) {
            throw FileNotFoundException("File \"${fileWithCompliments.path}\" not found")
        }
        availableCompliments = fileWithCompliments.readLines()
    }

    fun getCompliment(): String {
        val randomIndex = Random.nextInt(availableCompliments.size)
        return availableCompliments[randomIndex]
    }
}
