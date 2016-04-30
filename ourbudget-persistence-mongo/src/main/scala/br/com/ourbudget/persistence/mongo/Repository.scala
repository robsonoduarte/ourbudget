package br.com.ourbudget.persistence.mongo

import org.springframework.data.mongodb.core.MongoTemplate
import com.mongodb.Mongo
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Criteria._

class Repository {


  val mongoOps = new MongoTemplate(new Mongo("192.168.99.100"), "ourbudget")



  def save[B](b: B) = mongoOps save(b)


  def find[B](id:String, c: Class[B] ): B = mongoOps findOne(new Query(where("id").is(id)), c)


}


