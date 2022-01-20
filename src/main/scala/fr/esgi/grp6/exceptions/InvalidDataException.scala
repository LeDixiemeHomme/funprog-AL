package fr.esgi.grp6.exceptions

final case class InvalidDataException(private val message: String)
  extends Exception(message)