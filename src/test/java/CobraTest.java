import org.junit.*;
import static org.junit.Assert.*;

public class CobraTest {

  @Test
  public void cobra_instantiatesCorrectly() {
    Cobra testCobra = new Cobra("malimau", 30, "sharp shooter", 10, 7);
    assertEquals(true, testCobra instanceof Cobra);
  }

@Test
  public void getName_returnsNameCorrectly_malimau() {
    Cobra testCobra = new Cobra("malimau", 30, "sharp shooter", 10, 7);
    assertEquals("malimau", testCobra.getName());
  }
  @Test
    public void getAge_returnsAgeCorrectly_malimau() {
      Cobra testCobra = new Cobra("malimau", 30, "sharp shooter", 10, 7);
      assertEquals(30, testCobra.getAge());
    }
  @Test
    public void getPower_returnsPowerCorrectly_malimau(){
      Cobra testCobra = new Cobra("malimau", 30,"sharp shooter", 10, 7);
      assertEquals("sharp shooter", testCobra.getPower());
    }

    @Test
      public void getAttack_returnsAttackCorrectly_malimau(){
        Cobra testCobra = new Cobra("malimau", 30,"sharp shooter", 10, 7);
        assertEquals(10, testCobra.getAttack());
      }

      @Test
        public void getDefense_returnsDefenseCorrectly_malimau(){
          Cobra testCobra = new Cobra("malimau", 30,"sharp shooter", 10, 7);
          assertEquals(7, testCobra.getDefense());
        }
}
