package br.com.ourbudget.persistence.api

import br.com.ourbudget.domain.Budget
import org.scalatra._



import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._


class OurBudget extends ScalatraServlet with JacksonJsonSupport{

   protected implicit lazy val jsonFormats: Formats = DefaultFormats


  before(){
    contentType = formats("json")
  }






  post("/add"){
    	var budget = parsedBody.extract[Budget]
    	print(budget)
  }





}



