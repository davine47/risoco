import mill._
import mill.scalalib._

object risoco extends ScalaModule with SbtModule{
  def scalaVersion = "2.13.10"
  override def millSourcePath = os.pwd
  override def ivyDeps = Agg(
    ivy"edu.berkeley.cs::chisel3:3.6.0"
  )

}