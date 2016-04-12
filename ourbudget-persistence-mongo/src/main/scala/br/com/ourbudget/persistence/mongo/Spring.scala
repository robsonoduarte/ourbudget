package br.com.ourbudget.persistence.mongo


import com.mongodb.Mongo

import org.springframework.data.mongodb.core.query.Criteria._

import br.com.ourbudget.domain.Budget
import br.com.ourbudget.domain.Revenue
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import br.com.ourbudget.domain.Expenditure

object Spring extends App {


  /*
   * Spring Data Mongodb for the basic tests is the best option ( maybe for this moment, Its is new for me )
   *
   * because It's simple to use..
   *
   */



  val mongoOps = new MongoTemplate(new Mongo("192.168.99.100"), "ourbudget")


 // mongoOps save(budget, "budgets")


  val b1 =  mongoOps.findOne(new Query(where("name").is("Travel")), classOf[Budget], "budgets")


  val b2 = b1 + Revenue("Salary", 400.00)
  val b3 = b2 + Expenditure("Hotel", 400.00)



  mongoOps.save(b3, "budgets")








  def budget = new Budget("Travel", Array(Revenue("Investment", 100.00),Revenue("Dolar", 300.00)), Array(Expenditure("Air Plane", 100.00)))

}