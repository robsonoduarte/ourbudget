package br.com.ourbudget.domain

import com.mongodb.casbah.MongoClient
import com.mongodb.casbah.commons.MongoDBObject
import com.typesafe.config.ConfigFactory


/**
 * Created by Thiago Pereira on 7/24/15.
 */
object Mongo extends App {

  val config = ConfigFactory.load()

  val mongoClient = MongoClient(config.getString("mongo.client"))
  val db =  mongoClient(config.getString("mongo.db"))
  var coll = db(config.getString("mongo.coll"))

  val a = MongoDBObject("1" -> new Budget("budget 1", BigDecimal(10)))
  val b = new Budget("teste", 2.0)

  coll.insert(a)

  db.collectionNames() foreach print
}