package br.com.ourbudget.domain


case class Revenue(name: String, value: Double)
case class Expenditure(name: String, value: Double)
case class Budget(id : String = "", name: String = "",  revenues: Array[Revenue] = Array(), expenditures: Array[Expenditure] = Array(), users : Array[String] = Array()){
  def +(revenue: Revenue) = copy(id, name, revenues :+ revenue, expenditures)
  def +(expenditure: Expenditure) = copy(id, name, revenues, expenditures :+ expenditure )
  def +(user: User) = copy(id, name, revenues, expenditures, users :+ user.id)   
}
case class User(id: String = "", name: String = "", budgets: Array[String] = Array()){
  def +(budget: Budget) = copy(id, name, budgets :+ budget.id)    
}


