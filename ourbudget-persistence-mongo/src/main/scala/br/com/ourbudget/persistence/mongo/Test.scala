package br.com.ourbudget.persistence.mongo

import br.com.ourbudget.domain.User
import br.com.ourbudget.domain.Budget

object Test extends App {

  val repo = new Repository


  //repo save User( id = null, name = "Robson")

  val user =  repo find("57a51db034e53360137542aa", classOf[User])

  val budget = repo find("57a53feb9893450e3ee499c7", classOf[Budget])


  repo save user + budget
  repo save budget + user

 // print(user)



}