

package br.com.ourbudget.api


import org.scalatra.test.scalatest._
import org.scalatest.FunSuiteLike
import br.com.ourbudget.domain.Budget
import br.com.ourbudget.domain.Revenue
import br.com.ourbudget.domain.Expenditure
import org.json4s._
import org.json4s.jackson.JsonMethods._
import java.sql.Date

class OurBudgetTests extends ScalatraSuite with FunSuiteLike {

  var id : String = null

  implicit val formats = DefaultFormats


  addServlet(classOf[OurBudget], "/*")




  val budget = """{"name": "Travel", "users":  ["123"]}""""

   test("should create new Budget and return json with the id"){
     post("/", budget ){
       val json = parse(body)
       id = (json \ "id").extract[String]
       id should not be empty
     }
  }


   test("should create new Budget"){
     post("/", budget ){
       val budget = parse(body).extract[Budget]
       budget.name should be("Travel")
       budget.users contains("123")
     }
  }



  val revenue = """{ "name": "Salary", "value": 400 }"""

  test("should add the Revenue in the Budget searching by id"){
     put(s"/revenue/$id", revenue ){
        val budget = parse(body).extract[Budget]
        budget.revenues should contain (Revenue("Salary", 400))
     }
  }



  val expenditure = """{ "name": "Hotel", "value": 200 , "tags" : ["creditcard","money"], "liquidated" : true}"""

  test("should add the Expenditure in the Budget searching by id"){
     put(s"/expenditure/$id", expenditure ){
        val ex = parse(body).extract[Budget].expenditures(0)
        ex.name should be ("Hotel")
        ex.value should be (200.0)
        ex.liquidated should be (true)
        ex.tags(0) should be ("creditcard")
        ex.tags(1) should be ("money")
     }
  }


  test("should get Budgets by id"){
	  get(s"/$id"){
		  val budget =  parse(body).extract[Budget]
		  budget.id should be equals(id)
	  }
  }



  test("should get all Budgets in base"){ // FIXME: the simple get method to test the first integration with App mobile
     get("/all"){
       val budgets =  parse(body).extract[List[Budget]]
       /*budgets should have size 2*/  // FIXME: we need make one solution to data base integration tests........
     }
  }



  test("should get all Budgets of the user"){
     get("/budgets/user/57a51db034e53360137542aa"){
       val budgets =  parse(body).extract[List[Budget]]
       /*budgets should have size 2*/  // FIXME: we need make one solution to data base integration tests........
     }
  }










}