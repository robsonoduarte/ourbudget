package br.com.ourbudget.domain


import com.google.gson.Gson



class Budget(val name: String, val revenues: Array[Revenue] = Array(), val expenditures: Array[Expenditure] = Array()) {



  private var id : String = null




  def +(revenue: Revenue) = {
    val copy = new Budget(name, revenues.+:(revenue), expenditures )
    copy id = id
    copy
  }


  def +(expenditure: Expenditure) = {
    val copy = new Budget(name, revenues, expenditures.+:(expenditure) )
		copy id = id
		copy
  }




  override def toString = new Gson().toJson(this)



}