import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/features",
    glue = "steps"
)

/* 
 * 
 * Para que funcionen los tests, hay que crear una cuenta en https://juice-shop.herokuapp.com/#/register
	con usuario: paco@gmail.com y contraseña: paco1234
 	ya que la página elimina todos los usuarios inactivos cada ciertas horas
 *
 *
 */

public class RunLoginTest extends AbstractTestNGCucumberTests {

}