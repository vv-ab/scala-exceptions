import java.io.FileNotFoundException
import scala.io.Source
import java.nio.file.{Files, Paths}
import java.nio.charset.StandardCharsets


def main(): Unit = {

  val result: Either[String, Unit] = copyFile()

  result match {
    case Left(message) =>
      println(s"Failed to copy file: $message")
    case Right(value) =>
      println("Successfully copied file")
  }
}

def copyFile(): Either[String, Unit] = {

  try {
    val source = Source.fromFile("exampleasd.txt")
    val lines = source.mkString
    source.close()
    println(lines)
    Files.write(Paths.get("file.text"), lines.getBytes(StandardCharsets.UTF_8))
    Right(())
  }
  catch {
    case _: FileNotFoundException => Left("didn't find anything")
  }
}
