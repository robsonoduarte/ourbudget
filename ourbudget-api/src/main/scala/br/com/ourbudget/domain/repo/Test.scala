package br.com.ourbudget.repo

import br.com.ourbudget.domain.User
import br.com.ourbudget.domain.Budget

object Test extends App {

  val repo = new Repo


  //repo save User( id = null, name = "Robson")

 /* val user =  repo find("57a51db034e53360137542aa", classOf[User])

  val budget = repo find("57ae876cb8bff5893390fdc0", classOf[Budget])


  repo save user + budget
  repo save budget + user
*/

  val budgets = repo listToUser "57a51db034e53360137542aa"

  print(budgets)


  /*print(user)*/



}