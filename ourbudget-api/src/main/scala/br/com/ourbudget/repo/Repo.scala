

package br.com.ourbudget.repo

import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Criteria._
import scala.collection.JavaConversions._
import br.com.ourbudget.domain.Budget


class Repo {


  private val mongo = MongoTemplateBuffer.get

  def save[B](b: B) = mongo save(b)
  def find[B](id:String, c: Class[B] ) = mongo findOne(new Query(where("id").is(id)), c)
  def list[B](c: Class[B]): List[B] = mongo.findAll(c).toList
  def listToUser(id: String) = mongo.find(new Query(where("users").in(id)), classOf[Budget]).toList

}






object Repo{
  def apply() = new Repo()
}


