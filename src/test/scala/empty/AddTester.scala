/*
 * Dummy tester to start a Chisel project.
 *
 * Author: Martin Schoeberl (martin@jopdesign.com)
 * 
 */

package empty

import chisel3._
import chisel3.iotesters.PeekPokeTester

class AddTester(dut: Add) extends PeekPokeTester(dut) {

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

  println("Testing the adder")
  iotesters.Driver.execute(Array[String](), () => new Add()) {
    c => new AddTester(c)
  }
}
