
import scala.io.StdIn._
object demo {

  def encryptCaesar(plaintext: String, shift: Int): String = {
    plaintext.map { char =>
      if (char.isLetter) {
        val shiftBase = if (char.isUpper) 'A' else 'a'
        ((char - shiftBase + shift) % 26 + shiftBase).toChar
      } else {
        char
      }
    }
  }

  def decryptCaesar(ciphertext: String, shift: Int): String = {
    ciphertext.map { char =>
      if (char.isLetter) {
        val shiftBase = if (char.isUpper) 'A' else 'a'     //Ascii values: A=65  ,a=97
        ((char - shiftBase - shift + 26) % 26 + shiftBase).toChar
      } else {
        char
      }
    }
  }


    def cipher(text: String, shift: Int, func: (String, Int) => String): String = {
      func(text, shift)
    }

    def main(args: Array[String]): Unit = {

      val shift = 3
      println("Enter your text:");
      val plaintext = readLine()

      val ciphertext = cipher(plaintext, shift, encryptCaesar)
      println(s"Encrypted Text: $ciphertext")
      
      val decryptedText = cipher(ciphertext, shift, decryptCaesar)
      println(s"Decrypted Text: $decryptedText")
    }


}
