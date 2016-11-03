

package br.com.ourbudget.repo

import org.springframework.data.mongodb.core.MongoTemplate
import com.mongodb.Mongo
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Criteria._
import scala.collection.JavaConversions._
import com.mongodb.ServerAddress
import br.com.ourbudget.domain.Budget



class Repo {


  val mongoOps = new MongoTemplate(new Mongo(servers), "ourbudget")

  def save[B](b: B) = mongoOps save(b)
  def find[B](id:String, c: Class[B] ) = mongoOps findOne(new Query(where("id").is(id)), c)
  def list[B](c: Class[B]): List[B] = mongoOps.findAll(c).toList
  def listToUser(id: String) = mongoOps.find(new Query(where("users").in(id)), classOf[Budget]).toList


  def servers = List(new ServerAddress("172.17.0.2",27017))

}






object Repo{
  def apply() = new Repo()
}


