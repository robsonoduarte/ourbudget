package br.com.ourbudget.service

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import br.com.ourbudget.domain.Budget

class BudgetServiceSpec extends FlatSpec with Matchers {

  val service = BudgetService()



  it should "save the budget" in {
    val budget = service.save(new Budget())
    budget should not equal(null)
  }







}