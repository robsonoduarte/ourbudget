package br.com.ourbudget.domain

import scala.collection.mutable.ArrayBuffer
import br.com.ourbudget.repo.Repo
import java.util.List
import java.util.Arrays.asList
import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer

object Temp extends App {

  val repo = Repo()


  //save


  val temp = repo.find("5932d765f4ea63cf8c17c546", classOf[Temp])

//  val z = temp + new Revenue("Vale Ana", 2.0)
  //repo.save( z)
  //repo.save( z + new Revenue("Vale Ana", 2.0) )

  //val x = temp - new Revenue("Salario Robson", 8.0)
 // val x = temp update new Revenue(name= "Emprestimo Rosana",  value = 10.0, true, 5)
  val x = temp - Revenue(name= "Resgate LCA",  value = 10.0, true, 4)


  repo.save(x)


  def save {
    val x = Array(Revenue("Salario Robson",8.0),Revenue("Salario Ana",8.0))
    repo.save(Temp("5932d765f4ea63cf8c17c546",x))
  }

}


//case class Temp(id: String, revenues: Array[Revenue])
case class Temp(id: String, revenues: Array[Revenue]){
  def +(rev: Revenue) = copy(revenues = revenues :+ rev.copy(rev.name, rev.value,rev.received, revenues.size))
  def -(rev: Revenue) = copy(revenues = temp(rev) )
  def update(rev: Revenue)= copy( revenues = revenues.updated(rev.index, rev.copy(rev.name, rev.value, rev.received)))

  private def temp(rev: Revenue) = {
    val x = revenues.filter(! _.equals(rev))
    x.map(y => y.copy(index = (x.indexOf(y)))).toArray
  }

}