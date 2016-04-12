package br.com.ourbudget.domain


import com.google.gson.Gson



class Budget(val name: String, val revenues: Array[Revenue] = Array(), val expenditures: Array[Expenditure] = Array()) {



  private var id : String = null



  def +(revenue: Revenue) = new Budget(name, revenues.+:(revenue), expenditures )

  def +(expenditure: Expenditure) = new Budget(name, revenues, expenditures.+:(expenditure) )




  override def toString = new Gson().toJson(this)



}