package br.com.ourbudget.domain

import org.mongodb.morphia.annotations.Entity
import com.google.gson.Gson
import org.mongodb.morphia.annotations.Id
import org.bson.types.ObjectId





class Budget(val name: String, val revenues: Array[Revenue] = Array()) {

  private var id : String = null


  def addRevenue(revenue: Revenue) = {
    val copy = new Budget(name, revenues.+:(revenue) )
    copy.id = id
    copy
  }



  override def toString = new Gson().toJson(this)

}