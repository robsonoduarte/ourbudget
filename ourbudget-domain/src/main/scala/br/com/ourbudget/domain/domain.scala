package br.com.ourbudget.domain


case class Revenue(name: String, value: Double)
case class Expenditure(name: String, value: Double)
case class Budget(id : String = "", name: String = "",  revenues: Array[Revenue] = Array(), expenditures: Array[Expenditure] = Array()){
  def +(revenue: Revenue) = copy(id, name, revenues.+:(revenue), expenditures)
  def +(expenditure: Expenditure) = copy(id, name, revenues, expenditures.+:(expenditure))
}


