

package br.com.ourbudget.api


import org.scalatra.test.scalatest._
import org.scalatest.FunSuiteLike
import br.com.ourbudget.domain.Budget
import br.com.ourbudget.domain.Revenue
import br.com.ourbudget.domain.Expenditure


class OurBudgetTests extends ScalatraSuite with FunSuiteLike {

  addServlet(classOf[OurBudget], "/*")



  val budget = new Budget("Test")



   test("should add new budget and return json with the id"){
     post("/new", budget toString){
       status should equal(200)
       body should startWith ("{\"name\":\"Test\",\"revenues\":[],\"expenditures\":[],\"id\":")
     }
  }





}