import java.io.FileNotFoundException
import kotlin.random.Random

/**
 * Generates compliments from a file.
 * In the file, each compliment is written in a separate line.
 * @param pathToFileWithCompliments is relative to the 'src/main/resources' folder
 * */
class ComplimentGenerator(pathToFileWithCompliments: String) {
    private var availableCompliments: List<String>

    init {
        val fileWithCompliments = javaClass.getResource(pathToFileWithCompliments)
            ?: throw FileNotFoundException("File \"${pathToFileWithCompliments}\" not found")
        availableCompliments = fileWithCompliments.readText().split('\n')
    }

    fun getCompliment(): String {
        val randomIndex = Random.nextInt(availableCompliments.size)
        return availableCompliments[randomIndex]
    }
}
