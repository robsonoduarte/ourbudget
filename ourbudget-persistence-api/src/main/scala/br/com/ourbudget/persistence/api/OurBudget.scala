package br.com.ourbudget.persistence.api

import br.com.ourbudget.domain.Budget
import org.scalatra._


class OurBudget extends ScalatraServlet{



  post("/add"){
    print( request.body )
  }





}