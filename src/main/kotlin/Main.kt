import enigma.*

fun main() {
  val rotor1 = Rotor(scramblerA, 1, 0)
  val rotor2 = Rotor(scramblerB, 5, 1)
  val rotor3 = Rotor(scramblerC, 20, 2)
  val reflector = Reflector()
  val plugBoard = PlugBoard(mapOf('H' to 'X', 'A' to 'E', 'O' to 'J'))

  val enigma = Enigma(rotor1, rotor2, rotor3, reflector, plugBoard)

  val message = "ZUOVS MIEAR"

  val cypher = message
    .split(" ")
    .joinToString(" ") { m ->
      m.toCharArray()
        .map { encrypt(it, enigma) }
        .toCharArray()
        .concatToString()
    }

  println(cypher)
}
