import java.io.FileNotFoundException
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}
import scala.io.Source

case class Person(name: String)

@main
def matchingExamples(): Unit = {

  def speak(person: Person) = person match {
    case Person(name) if name == "Fred" => println(s"$name says, Yubba dubba doo")
    case Person(name) if name == "Bam Bam" => println(s"$name says Bam Bam!")
    case _ => println("Watch the Flintstones")
  }

  speak(Person("Fred"))
  speak(Person("Bam Bam"))
  speak(Person("Elmar"))

}
