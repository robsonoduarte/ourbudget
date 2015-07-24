package br.com.ourbudget.domain

import com.mongodb.casbah.MongoClient
import com.mongodb.casbah.commons.MongoDBObject



object Mongo extends App {

  val mongoClient = MongoClient("52.24.192.174");


  val db =  mongoClient("ourbudget");


  var coll = db("ourbudget")




  val b = new Bugdet("teste", 2.0)





  val a = MongoDBObject("1" -> new Teste)


  coll.insert(a)


  db.collectionNames().foreach {print(_)}



}