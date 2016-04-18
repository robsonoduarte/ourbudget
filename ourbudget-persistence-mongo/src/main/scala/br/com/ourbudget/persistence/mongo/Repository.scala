package br.com.ourbudget.persistence.mongo

import org.springframework.data.mongodb.core.MongoTemplate
import com.mongodb.Mongo

class Repository {


  val mongoOps = new MongoTemplate(new Mongo("192.168.99.100"), "ourbudget")



  def save[B](b: B) = mongoOps.save(b)



}


