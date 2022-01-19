package fr.esgi.grp6.exceptions

final case class InvalidDataException(private val message: String, private val cause: Throwable)
  extends Exception(message, cause)