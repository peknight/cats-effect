package com.peknight.cats.effect.syntax

import cats.MonadError
import cats.data.IorT
import cats.effect.ExitCode
import cats.syntax.functor.*
import cats.syntax.monadError.*

trait IorTSyntax:
  extension [F[_], E <: Throwable] (iorT: IorT[F, E, Boolean])
    def asExitCode(using MonadError[F, Throwable]): F[ExitCode] = 
      iorT.value.map(_.toEither).rethrow.map(success => if success then ExitCode.Success else ExitCode.Error)
  end extension
end IorTSyntax
object IorTSyntax extends IorTSyntax
