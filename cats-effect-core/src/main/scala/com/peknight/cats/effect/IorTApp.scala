package com.peknight.cats.effect

import cats.data.IorT
import cats.effect.{ExitCode, IO, IOApp}
import com.peknight.cats.effect.syntax.iorT.asExitCode

trait IorTApp extends IOApp:
  def iorT(args: List[String]): IorT[IO, ? <: Throwable, Boolean]
  final def run(args: List[String]): IO[ExitCode] = iorT(args).asExitCode
end IorTApp
object IorTApp:
  trait Simple extends IorTApp:
    def iorT: IorT[IO, ? <: Throwable, Boolean]
    final def iorT(args: List[String]): IorT[IO, ? <: Throwable, Boolean] = iorT
  end Simple
end IorTApp
