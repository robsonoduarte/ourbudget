package br.com.ourbudget.notification

import scalaj.http.Http




class Notificator {

	private val app_id = "8f88f81f-8e2f-4433-b85a-27e387bec18d"
	private val api_key = "YWUwMTBmMDktNzQwZC00MTMyLTg0YTMtZjE0YjlmNWQ1OTMx"



// TODO: get object message
  def notify(msg: String) = {

    val rsp =  Http("https://onesignal.com/api/v1/notifications")
      .postData(json(msg))
      .header("content-type", "application/json; charset=UTF-8")
      .header("Authorization", s"Basic $api_key")
      .asString


      rsp.body

  }



	 private def json(msg:String) = {
	   val s =  s"""{"app_id": "$app_id","included_segments": ["All"], "data": $msg, "contents": {"en": "New Budget"}}"""
	   print(s)
	   s
	 }

}


object Notificator {
  def apply() = new Notificator()
}