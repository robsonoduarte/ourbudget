package br.com.ourbudget.api

import br.com.ourbudget.domain.Budget
import org.scalatra._

import org.json4s.{ DefaultFormats, Formats }
import org.scalatra.json._
import br.com.ourbudget.persistence.mongo.Repository
import br.com.ourbudget.domain.Revenue
import br.com.ourbudget.domain.Expenditure

class OurBudget extends ScalatraServlet with JacksonJsonSupport {

  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  var repo = new Repository

  before() {
    contentType = formats("json")
  }












  post("/new") {
    var budget = parsedBody.extract[Budget]
    save(budget)
    budget
  }

  put("/revenue/:id") {
    val budget = findBudget + parsedBody.extract[Revenue]
    save(budget)
    budget
  }

  put("/expenditure/:id") {
    val budget = findBudget + parsedBody.extract[Expenditure]
    save(budget)
    budget
  }



















  private def save[B](b: B) = repo save (b)
  private def findBudget = repo find (params("id"), classOf[Budget])

}



