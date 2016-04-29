

package br.com.ourbudget.api


import org.scalatra.test.scalatest._
import org.scalatest.FunSuiteLike
import br.com.ourbudget.domain.Budget
import br.com.ourbudget.domain.Revenue
import br.com.ourbudget.domain.Expenditure


class OurBudgetTests extends ScalatraSuite with FunSuiteLike {

  addServlet(classOf[OurBudget], "/*")



  val budget = new Budget("Test", Array(Revenue("Test", 10.0)), Array(Expenditure("Test", 20.0)))





   test("should add new budget"){
     post("/add", budget toString){
       status should equal(200)
       //body should contain (budget toString )
     }

  }






}