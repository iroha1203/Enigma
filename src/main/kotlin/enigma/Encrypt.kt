package enigma

fun encrypt(char: Char, enigma: Enigma): Char = enigma.run {
  char
    .shift(plugBoard.getShifts())
    .shift(rotor1.getForwardShifts())
    .shift(rotor2.getForwardShifts())
    .shift(rotor3.getForwardShifts())
    .shift(reflector.getShifts())
    .shift(rotor3.getReflectShifts())
    .shift(rotor2.getReflectShifts())
    .shift(rotor1.getReflectShifts())
    .shift(plugBoard.getShifts())
    .also {
      rotor1.rotate()
      rotor2.rotate()
      rotor3.rotate()
    }
}

fun Char.shift(shifts: List<Int>): Char = let {
  val position = it.uppercaseChar().code - 65
  ((position + shifts[position]) % 26 + 65).toChar()
}
