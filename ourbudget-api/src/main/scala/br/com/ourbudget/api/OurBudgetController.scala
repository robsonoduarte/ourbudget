
package br.com.ourbudget.api

import br.com.ourbudget.domain.Budget
import org.scalatra._

import org.json4s.{ DefaultFormats, Formats }
import org.scalatra.json._
import br.com.ourbudget.domain.Revenue
import br.com.ourbudget.domain.Expenditure
import br.com.ourbudget.repo.Repo
import br.com.ourbudget.service.Notificator



class OurBudgetController extends ScalatraServlet with JacksonJsonSupport {

  protected implicit lazy val jsonFormats: Formats = DefaultFormats
  
   private val repo = Repo()
   private val notificator = Notificator()

  before() {
    contentType = formats("json")
  }

  options("/*"){
   response.setHeader(
      "Access-Control-Allow-Headers", 
      request.getHeader("Access-Control-Request-Headers")
     );
  }


  post("/budgets") {
    val budget = parsedBody.extract[Budget].copy(null) // clean id because it is generate by DB ( Mongo )
    save(budget)
   // notificator notify(s"""{"name":"${budget.name}"}""")
    budget
  }

  get("/budgets"){
	  repo list(classOf[Budget])
  }
  
  get("/budgets/:id"){
	  findBudget
  }

  
  post("/budgets/:id/revenues") {
    val revenue = parsedBody.extract[Revenue];
    val budget = findBudget :+ revenue
    save(budget)
  //  notificator notify(s"""{"name":"${budget.name}", "revenue": "${revenue.name}"}""")
    budget
  }
  
  
  delete("/budgets/:id/revenues/:index") {	  
    val budget = findBudget :- params("index").toInt
    save(budget)
    //  notificator notify(s"""{"name":"${budget.name}", "revenue": "${revenue.name}"}""")
    budget
  }

  
  
  
  
  
  post("/budgets/:id/expenditures") {
    val expenditure = parsedBody.extract[Expenditure]
    val budget = findBudget + expenditure
 //   notificator notify(s"""{"name":"${budget.name}", "expenditure": "${expenditure.name}"}""")
    save(budget)
    budget
  }



 
  private def save[B](b: B) = repo save (b)
  private def findBudget = repo find (params("id"), classOf[Budget])

}



