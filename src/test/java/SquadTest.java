import org.junit.*;
import static org.junit.Assert.*;
import java.util.Map;
import java.util.HashMap;

public class SquadTest {

  private Squad testSquad1;

  @Before
  public void setUp(){
    testSquad1 = new Squad("Kwekwe", "Wale wabaya");
  }

  @Test
  public void squad_instantiatesCorrectly(){
    assertTrue(testSquad1 instanceof Squad);
  }

  @Test
  public void getName_returnsNameCorrectly_kwekwe(){
    assertEquals("Kwekwe", testSquad1.getName());
  }

  @Test
  public void getMax_returnsMaxSizeCorrectly_8(){
    assertEquals(8, testSquad1.getMax());
  }

  @Test
  public void getCause_returnsCauseCorrectly_String(){
    assertEquals("Wale wabaya", testSquad1.getCause());
  }

  @Test
  public void clear_resetsInstances_0(){
    Squad testSquad2 = new Squad("flying", "wale wamasaa");
    assertEquals(2, Squad.all().size());
    Squad.clear();
    assertEquals(0, Squad.all().size());
    
  }

  @Test
  public void getCobras_returnsHashOfCobrass_true(){
    Cobra newCobra1 = new Cobra("Sindano", 41, "resourcefulness", 4, 5);
    testSquad1.addCobra(newCobra1);
    Cobra newCobra2 = new Cobra("Sindano", 41, "resourcefulness", 4, 5);
    testSquad1.addCobra(newCobra2);
    assertTrue(testSquad1.getCobras() instanceof HashMap);
  }

  @Test
  public void addCobra_addsCobraToCobraHash_true(){
    Cobra newCobra = new Cobra("Sindano", 41, "resourcefulness", 4, 5);
    testSquad1.addCobra(newCobra);
    assertTrue(testSquad1.getCobrass().containsKey("Sindano"));
  }
  @After
  public void tearDown(){
    Squad.clear();
  }
}
