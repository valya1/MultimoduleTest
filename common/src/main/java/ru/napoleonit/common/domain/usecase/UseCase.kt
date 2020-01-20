package ru.napoleonit.common.domain.usecase

abstract class UseCase {

    abstract suspend operator fun invoke()
}