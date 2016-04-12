package br.com.ourbudget.persistence.mongo


import com.mongodb.Mongo

import org.springframework.data.mongodb.core.query.Criteria._

import br.com.ourbudget.domain.Budget
import br.com.ourbudget.domain.Revenue
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

object Spring extends App {


  /*
   * Spring Data Mongodb for the basic tests is the best option ( maybe for this moment, Its is new for me )
   *
   * because It's simple to use..
   *
   */



  val mongoOps = new MongoTemplate(new Mongo("192.168.99.100"), "ourbudget")


  mongoOps insert budget


  var b1 =  mongoOps.findOne(new Query(where("name").is("Travel")), classOf[Budget])


  var b2 = b1.addRevenue(new Revenue("Salary", 400.00))



  mongoOps.save(b2)













  def budget = new Budget("Travel", Array(new Revenue("Hotel", 100.00),new Revenue("AirPlane", 300.00)))

}