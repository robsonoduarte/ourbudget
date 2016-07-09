package br.com.ourbudget.domain


case class Revenue(val name: String, val value: Double)
case class Expenditure(val name: String, val value: Double)
case class Budget(val id : String = "", val name: String = "",  val revenues: Array[Revenue] = Array(), val expenditures: Array[Expenditure] = Array()){
  def +(revenue: Revenue) = copy(id, name, revenues.+:(revenue), expenditures)
  def +(expenditure: Expenditure) = copy(id, name, revenues, expenditures.+:(expenditure))
}



