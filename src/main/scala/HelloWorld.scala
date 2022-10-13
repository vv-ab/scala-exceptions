import java.io.FileNotFoundException
import scala.io.Source
import java.nio.file.{Files, Paths}
import java.nio.charset.StandardCharsets

@main
def main(): Unit = {

  val result: Either[String, Unit] = copyFile("example.txt")

  result match {
    case Left(message) =>
      println(s"Failed to copy file: $message")
    case Right(value) =>
      println("Successfully copied file")
  }

  copyFile("blub.txt") match
    case Left(value) =>
      println("failed to copy blub.txt")
    case Right(value) =>
      println("Successfully copied file")
}

def copyFile(sourceFile: String): Either[String, Unit] = {

  try {
    val source = Source.fromFile(sourceFile)
    val lines = source.mkString
    source.close()
    Files.write(Paths.get("file.text"), lines.getBytes(StandardCharsets.UTF_8))
    Right(())
  }
  catch {
    case _: FileNotFoundException => Left("didn't find anything")
  }
}

