import os.Path
import mill._
import scalalib._
import publish._
import coursier.maven.MavenRepository

object ivys {
  val sv = "2.12.13"
  val chisel3 = ivy"edu.berkeley.cs::chisel3:3.6.0"
  val chisel3Plugin = ivy"edu.berkeley.cs:::chisel3-plugin:3.6.0"
  val chiseltest = ivy"edu.berkeley.cs::chiseltest:0.5.2"
  val chiselCirct = ivy"com.sifive::chisel-circt:0.6.0"
  val scalatest = ivy"org.scalatest::scalatest:3.2.2"
  val macroParadise = ivy"org.scalamacros:::paradise:2.1.1"
}

object risoco extends ScalaModule with SbtModule {
  override def millSourcePath = os.pwd
  override def scalaVersion = ivys.sv
  override def scalacPluginIvyDeps = Agg(ivys.macroParadise, ivys.chisel3Plugin)
  override def scalacOptions = Seq("-Xsource:2.11")
  override def ivyDeps = Agg(ivys.chisel3)
}
