import org.scalatra.LifeCycle
import javax.servlet.ServletContext
import br.com.ourbudget.persistence.api.OurBudget


class ScalatraBootstrap extends LifeCycle {

  override def init(context: ServletContext){
    context mount(new OurBudget, "/ourbudget/*")
  }


}


