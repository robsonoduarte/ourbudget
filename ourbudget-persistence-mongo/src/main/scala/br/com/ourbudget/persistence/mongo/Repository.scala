package br.com.ourbudget.persistence.mongo

import org.springframework.data.mongodb.core.MongoTemplate
import com.mongodb.Mongo
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Criteria._
import scala.collection.JavaConversions._
import com.mongodb.ServerAddress
import br.com.ourbudget.domain.Budget


//TODO: we move this to ourbudget service module
class Repository {


  val mongoOps = new MongoTemplate(new Mongo(servers), "ourbudget")

  def save[B](b: B) = mongoOps save(b)
  def find[B](id:String, c: Class[B] ): B = mongoOps findOne(new Query(where("id").is(id)), c)
  def list[B](c: Class[B]): List[B] = mongoOps.findAll(c).toList
  def listToUser(id: String) = mongoOps.find(new Query(where("users").in(id)), classOf[Budget]).toList


  def servers = List(new ServerAddress("192.168.99.100",27017))

}


