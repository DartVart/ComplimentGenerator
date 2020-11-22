import java.io.FileNotFoundException

/**
 * Generates compliments from a file.
 * In the file, each compliment is written in a separate line.
 * @param pathToFileWithCompliments is relative to the 'src/main/resources' folder
 * */
class ComplimentGenerator(pathToFileWithCompliments: String) {
    private var availableCompliments: List<Compliment>

    init {
        val fileWithCompliments = javaClass.getResource(pathToFileWithCompliments)
            ?: throw FileNotFoundException("File \"${pathToFileWithCompliments}\" not found")
        availableCompliments = fileWithCompliments.readText().split('\n').map { Compliment(it) }
    }

    fun getCompliment() = availableCompliments.random()
}
