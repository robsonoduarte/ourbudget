

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

  implicit val formats = DefaultFormats


  addServlet(classOf[OurBudget], "/*")



  val budget = "{\"name\": \"Travel\"}"

   test("should create new Budget and return json with the id"){
     post("/new", budget ){

       status should equal(200)

       val json = parse(body)

       (json \ "id").extract[String] should not be empty
       (json \ "name").extract[String] should  be("Travel")


       // validate the format of json
       json.extract[Budget]

     }

  }











  val revenue = "{ \"name\": \"Salary\", \"value\": 400 }"


  test("should add the Revenue in the Budget searching by id"){
     put("/revenue/572414f77e78ea6998893167", revenue ){
       status should equal(200)


       val json = parse(body)


       (json \ "revenues").extract[Array[Revenue]]

       /*body should startWith ("{\"name\":\"Travel\",\"revenues\":[{\"name\":\"Salary\",\"value\":400.0}")*/

     }



  }



























  val expenditure = "{ \"name\": \"Salary\", \"value\": 400 }"


  test("should add the Expenditure in the Budget searching by id"){
     put("/expenditure/572414f77e78ea6998893167", expenditure ){
       status should equal(200)
       body should equal("572414f77e78ea6998893167")
     }
  }























}