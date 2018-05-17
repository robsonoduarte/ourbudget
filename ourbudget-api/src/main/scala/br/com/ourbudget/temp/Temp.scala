package br.com.ourbudget.temp

import br.com.ourbudget.repo.MongoTemplateBuffer
import br.com.ourbudget.repo.Repo
import br.com.ourbudget.domain.Budget

object Temp extends App {
  
  var repo = new Repo
  
  var budgets = repo.list(classOf[Budget])

  
  var total = 
     budgets.filter(_.name == "Abril 2018")
        .flatMap(_.expenditures)
        .filter(_.category == "Trampo")
        .map(_.value)
        .sum
  
        
  print(total)      
  
}