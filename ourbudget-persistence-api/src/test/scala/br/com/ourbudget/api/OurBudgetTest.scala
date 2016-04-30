

package br.com.ourbudget.api


import org.scalatra.test.scalatest._
import org.scalatest.FunSuiteLike
import br.com.ourbudget.domain.Budget
import br.com.ourbudget.domain.Revenue
import br.com.ourbudget.domain.Expenditure


class OurBudgetTests extends ScalatraSuite with FunSuiteLike {

  addServlet(classOf[OurBudget], "/*")



  val budget = "{\"name\": \"Travel\"}"


   test("should create new Budget and return json with the id"){
     post("/new", budget ){
       status should equal(200)
       body should startWith ("{\"name\":\"Travel\",\"revenues\":[],\"expenditures\":[],\"id\":")
     }
  }





  val revenue = "{ \"name\": \"Salary\", \"value\": 400 }"


  test("should add the Revenue in the Budget searchingpa by id"){
     put("/revenue/572405504c7439ab86008716", revenue ){
       status should equal(200)
       body should startWith ("{\"name\":\"Travel\",\"revenues\":[{\"name\":\"Salary\",\"value\":400.0}")
     }
  }






















}