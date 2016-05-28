

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




  val budget = "{\"name\": \"Travel\"}"

   test("should create new Budget and return json with the id"){

     post("/new", budget ){

       val json = parse(body)

       // the id is the private attr in budget
       id = (json \ "id").extract[String]
       id should not be empty
     }


  }





   test("should create new Budget"){

     post("/new", budget ){
       val budget = parse(body).extract[Budget]
       budget.name should be("Travel")
     }


  }








  val revenue = "{ \"name\": \"Salary\", \"value\": 400 }"


  test("should add the Revenue in the Budget searching by id"){
     put(s"/revenue/$id", revenue ){

        val budget = parse(body).extract[Budget]

        budget.revenues should contain (Revenue("Salary", 400))
     }

  }











  val expenditure = "{ \"name\": \"Hotel\", \"value\": 200 }"


  test("should add the Expenditure in the Budget searching by id"){
     put(s"/expenditure/$id", expenditure ){

        val budget = parse(body).extract[Budget]

        budget.expenditures should contain (Expenditure("Hotel", 200))
     }
  }






  test("should get Budgets by id"){ // the simple get method to test the first integration with App mobile
	  get(s"/budget/$id"){
		  val budget =  parse(body).extract[Budget]

		  budget.id should be equals(id)
	  }
  }





  test("should get all Budgets in base"){ // the simple get method to test the first integration with App mobile
     get("/all"){
       val budgets =  parse(body).extract[List[Budget]]
       /*budgets should have size 2*/  // FIXME: we need make one solution to data base integration tests........
     }
  }






















}