/*
 * Dummy tester to start a Chisel project.
 *
 * Author: Martin Schoeberl (martin@jopdesign.com)
 * 
 */

package empty

import Chisel._

class AddTester(dut: Add) extends Tester(dut) {

  for (a <- 0 to 2) {
    for (b <- 0 to 3) {
      val result = a + b
      poke(dut.io.a, a)
      poke(dut.io.b, b)
      step(1)
      expect(dut.io.c, result)
    }
  }
}

object AddTester extends App {

  println("Testing the ALU")
  chiselMainTest(Array("--genHarness", "--test",
    "--compile", "--targetDir", "generated"),
    () => Module(new Add())) {
      f => new AddTester(f)
    }
}
