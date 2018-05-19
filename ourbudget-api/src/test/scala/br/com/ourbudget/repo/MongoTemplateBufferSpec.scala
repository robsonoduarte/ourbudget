package br.com.ourbudget.repo

import java.util.Arrays.asList
import com.mongodb.ServerAddress
import org.scalatest.FlatSpec
import org.scalatest.Matchers

class MongoTemplateBufferSpec extends FlatSpec with Matchers{

	it should "return the MongoTemplate  same Mongo in all instances" in {
		var mongo1 = MongoTemplateBuffer.get
		var mongo2 = MongoTemplateBuffer.get
		mongo1.getDb.getMongo should equal(mongo2.getDb.getMongo)
	}	
}
