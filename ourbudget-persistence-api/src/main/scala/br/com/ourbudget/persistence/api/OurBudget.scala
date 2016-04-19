package br.com.ourbudget.persistence.api

import br.com.ourbudget.domain.Budget
import javax.ws.rs.Path
import javax.ws.rs.POST


@Path("/ourbudget")
class OurBudget {


  @POST
  def add(budget: String) = {
    print("add")
  }




}