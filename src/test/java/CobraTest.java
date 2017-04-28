import org.junit.*;
import static org.junit.Assert.*;

public class CobraTest {

  @Test
  public void cobra_instantiatesCorrectly() {
    Cobra testCobra = new Cobra("Malimau", 30, "sharp shooter", 10, 7);
    assertEquals(true, testCobra instanceof Cobra);
  }
