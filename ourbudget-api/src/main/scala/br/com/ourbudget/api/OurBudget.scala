package br.com.ourbudget.api

import br.com.ourbudget.domain.Budget
import org.scalatra._

import org.json4s.{ DefaultFormats, Formats }
import org.scalatra.json._
import br.com.ourbudget.domain.Revenue
import br.com.ourbudget.domain.Expenditure
import br.com.ourbudget.repo.Repo
import scalaj.http.Http

class OurBudget extends ScalatraServlet with JacksonJsonSupport {

  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  var repo = new Repo

  before() {
    contentType = formats("json")
  }







  post("/") {
    val budget = parsedBody.extract[Budget].copy(null) // clean id because it is generate by DB ( Mongo )
    save(budget)

    notification

    budget
  }

  get("/:id"){
	  findBudget
  }

  get("/budgets/user/:id"){
	  repo listToUser params("id")
  }

  get("/all"){
	  repo list(classOf[Budget])
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








  def notification = {

  val app_id = ""
  val api_key = ""

  val json = s"""{"app_id": "$app_id","included_segments": ["All"], "data": {"foo": "bar"}, "contents": {"en": "English Message"}}"""

    val rsp =  Http("https://onesignal.com/api/v1/notifications")
    .postData(json)
    .header("content-type", "application/json; charset=UTF-8")
    .header("Authorization", s"Basic $api_key")
    .asString

    println(rsp)
  }










  private def save[B](b: B) = repo save (b)
  private def findBudget = repo find (params("id"), classOf[Budget])

}



