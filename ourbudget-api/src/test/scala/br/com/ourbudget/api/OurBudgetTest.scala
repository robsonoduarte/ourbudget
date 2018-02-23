

package br.com.ourbudget.api


import org.scalatra.test.scalatest._
import org.scalatest.FunSuiteLike
import br.com.ourbudget.domain.Budget
import br.com.ourbudget.domain.Revenue
import br.com.ourbudget.domain.Expenditure
import org.json4s._
import org.json4s.jackson.JsonMethods._
import java.sql.Date

class OurBudgetControlleTests extends ScalatraSuite with FunSuiteLike {

  var id : String = null

  implicit val formats = DefaultFormats


  addServlet(classOf[OurBudgetController], "/*")



  val budget = """{"name": "API TEST", "users":  ["123"]}""""

   test("should create new Budget and return json with the id"){
     post("/budgets", budget ){
       val json = parse(body)
       id = (json \ "id").extract[String]
       id should not be empty
     }
  }


   test("should create new Budget"){
     post("/budgets", budget ){
       val budget = parse(body).extract[Budget]
       budget.name should be("API TEST")
       budget.users contains("123")
     }
  }

  
  test("should get Budgets by id"){
	  get(s"/budgets/$id"){
		  val budget =  parse(body).extract[Budget]
		  budget.id should be equals(id)
	  }
  } 
  
  
  test("should get all Budgets in base"){ // FIXME: the simple get method to test the first integration with App mobile
     get("/budgets"){
       val budgets =  parse(body).extract[List[Budget]]
       budgets.size should be > 1  // FIXME: we need make one solution to data base integration tests........ 
     }
  }
  


  var revenue = """{ "name": "Salary", "value": 400 }"""
  test("should add the Revenue in the Budget searching by id"){
     post(s"/budgets/$id/revenues", revenue ){       
        val budget = parse(body).extract[Budget]
        budget.revenues should contain (Revenue("Salary", 400))
     }
  }
  
  
  test("should delete the Revenue in the Budget searching by id and index"){
	  delete(s"/budgets/$id/revenues/0"){       
		  val budget = parse(body).extract[Budget]
			budget.revenues.length should be(0)
	  }
  }
  
  
  	
	

  val expenditure = """{ "name": "Hotel", "value": 200 , "category" : "travel" , "liquidated" : true}"""

  test("should add the Expenditure in the Budget searching by id"){
     post(s"/budgets/$id/expenditures", expenditure ){
        val ex = parse(body).extract[Budget].expenditures(0)
        ex.name should be ("Hotel")
        ex.value should be (200.0)
        ex.liquidated should be (true)
        ex.category should be ("travel")
     }
  }

  
   
}