package br.com.ourbudget.repo

import org.springframework.data.mongodb.core.MongoTemplate
import com.mongodb.Mongo
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI

object MongoTemplateBuffer {

    private val MONGO_URI = "mongodb://robsonoduarte:Anamara%40123@cluster0-shard-00-00-oy673.mongodb.net:27017,cluster0-shard-00-01-oy673.mongodb.net:27017,cluster0-shard-00-02-oy673.mongodb.net:27017/admin?replicaSet=Cluster0-shard-0&ssl=true"      
    private val mongoTemplate: MongoTemplate = new MongoTemplate( new MongoClient(new MongoClientURI(MONGO_URI)), "OURBUDGET-DEV")
    
     
    def get = mongoTemplate
  
 
}