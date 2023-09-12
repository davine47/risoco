package risoco

import chisel3.RawModule
import firrtl.options.{Dependency, PhaseManager, Shell}
import chisel3.stage.{ChiselCli, ChiselGeneratorAnnotation, ChiselStage}
import firrtl.AnnotationSeq
import firrtl.stage.FirrtlCli

trait RisocoCli { this: Shell =>
  parser.note("Risoco Cli notes")
}

class RisocoBaseStage extends ChiselStage {
  override val shell = new Shell("risoco-chip") with RisocoCli with ChiselCli with FirrtlCli
}

abstract class FirrtlCompiler
case object ScalaFC extends FirrtlCompiler

object Generator {
  def execute(args: Array[String], mod: => RawModule, fc: FirrtlCompiler, firtoolOpts: Array[String]) = {
    fc match {
      case ScalaFC =>
        (new RisocoBaseStage).execute(args, Seq(
          ChiselGeneratorAnnotation(mod _)
        ))
    }

  }
}

object TestMain extends App {
  // TODO: re-write these codes to support main paramters
  var firOpts = Array[String]("-td", "build")
  println("Begin generate hardwares.....")
  Generator.execute(firOpts, new Hello, ScalaFC, Array.empty)
}
