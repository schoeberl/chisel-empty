/*
 * Dummy file to start a Chisel project.
 *
 * Author: Martin Schoeberl (martin@jopdesign.com)
 * 
 */

package empty

import Chisel._

class Add extends Module {
  val io = new Bundle {
    val a = Input(UInt(width = 8))
    val b = Input(UInt(width = 8))
    val c = Output(UInt(width = 8))
  }

  val reg = Reg(init = UInt(0, 8))
  reg := io.a + io.b

  io.c := reg
}

object AddMain extends App {
  println("Generating the ALU hardware")
  chiselMain(Array("--backend", "v", "--targetDir", "generated"),
    () => Module(new Add()))
}