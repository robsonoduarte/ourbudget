package br.com.ourbudget.persistence.mongo


import com.mongodb.casbah.Imports._
import br.com.ourbudget.domain.Budget
import br.com.ourbudget.domain.Revenue






object Casbah extends App {


  val mongoClient = MongoClient("192.168.99.100", 27017)

  val db = mongoClient("ourbudget")
  val coll = db("budgets")


  coll.insert(MongoDBObject("hello" -> "world"))


  /*
   *
   * Stop test with Casbah because we need ( in this moment ) one simple form of persist the objects domain
   *
   *
   */





}