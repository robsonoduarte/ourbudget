package br.com.ourbudget.persistence.api

import br.com.ourbudget.domain.Budget
import org.scalatra._



import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._
import br.com.ourbudget.persistence.mongo.Repository


class OurBudget extends ScalatraServlet with JacksonJsonSupport{

   protected implicit lazy val jsonFormats: Formats = DefaultFormats


   var repo = new Repository


  before(){
    contentType = formats("json")
  }






  post("/add"){
    	var budget = parsedBody.extract[Budget]
    	var x = repo save budget
    	x
  }





}



