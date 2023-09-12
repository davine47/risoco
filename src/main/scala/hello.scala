package risoco

import chisel3.{Module, _}

class Hello extends Module {
  val io = IO(new Bundle {
    val out = Output(UInt(10.W))
  })
  println(io.out.getWidth)
  //BundleMap()
  io.out := 42.U
}