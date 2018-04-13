package br.com.ourbudget.domain

import scala.collection.mutable.ArrayBuffer
import scala.reflect.api.Exprs

case class Revenue(name: String, value: Double, received: Boolean = false, index: Int = 0)
case class Expenditure(name: String, value: Double, category: String, liquidated: Boolean = false, index: Int = 0)

// TODO: Study some way to allow create the Budget only with name...
case class Budget(id : String = "", name: String, balance: Double = 0.0,  closed: Boolean = false, revenues: Array[Revenue] = Array(), expenditures: Array[Expenditure] = Array(), users : Array[String] = Array()){
  
	def addExp(exp: Expenditure) = copy(
	    balance = balance - exp.value,  
	    expenditures = expenditures :+ exp.copy(name = exp.name, value = exp.value, category = exp.category, index = expenditures.length) 
	  )
	
  def addRev(rev: Revenue) = copy(
      balance = balance + rev.value, 
      revenues = revenues :+ rev.copy(name = rev.name, value = rev.value, index = revenues.length)
    )
  
  
  def removeExp(index: Int) = copy(
		  balance =  {
				  try {          
					  balance + expenditures(index).value
				  } catch {
				    case t: IndexOutOfBoundsException => balance
				  }        
		  },                
      expenditures = {       
          val exps = expenditures.filter(_.index != index)
	        exps.map(exp => exp.copy(index = (exps.indexOf(exp)))).toArray      
        }
		)
    
		
  def removeRev(index: Int) = copy( 
      balance =  {
        try {          
        	balance - revenues(index).value
        } catch {
          case t: IndexOutOfBoundsException => balance
        }        
      },                
      revenues = {
          val revs = revenues.filter(_.index != index)          
          revs.map(rev => rev.copy(index = (revs.indexOf(rev)))).toArray
      }
   )
  
   
   def updateExp(exp: Expenditure) ={
	    copy()
	 }
   
  def updateRev(rev: Revenue) = {
		copy( 
		     balance = { 
		       try{
		    	   balance - revenues(rev.index).value + rev.value 		         
		       }catch{
		         case t: IndexOutOfBoundsException => balance		         
		       }
		     }, 
		    revenues = {
		         try{
		        	 revenues.updated(rev.index, rev) 		          
		         }catch{
  		         case t: IndexOutOfBoundsException => revenues		         		           
		         }
		       }
		   )  
	}
   
	
  def +(user: User) = copy(users = users :+ user.id)

 
}

case class User(id: String = "", name: String = "", budgets: Array[String] = Array()){
  def +(budget: Budget) = copy(budgets = budgets :+ budget.id)
}