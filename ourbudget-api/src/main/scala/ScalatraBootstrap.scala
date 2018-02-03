import org.scalatra.LifeCycle
import javax.servlet.ServletContext
import br.com.ourbudget.api.OurBudgetController
import br.com.ourbudget.api.OurBudgetController



class ScalatraBootstrap extends LifeCycle {



  override def init(context: ServletContext){
    context mount(new OurBudgetController, "/ourbudget/*", "ourbudget")
  }


}


