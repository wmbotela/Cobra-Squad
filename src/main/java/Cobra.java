import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Cobra {
  private String mName;
  private int mAge;
  private String mPower;
  private int mAttack;
  private int mDefense;
  private boolean mInSquad;
  private static Map<String, Cobra> instances = new HashMap<String, Cobra>();

  public Cobra(String name, int age, String power, int attack, int defense) {
    mName = name;
    mAge = age;
    mPower = power;
    mAttack = attack;
    mDefense = defense;
    mInSquad = false;
    instances.put(name, this);
  }

  public String getName() {
    return mName;
  }

  public int getAge() {
    return mAge;
  }

  public String getPower() {
    return mPower;
  }

  public int getAttack() {
    return mAttack;
  }

  public int getDefense() {
    return mDefense;
  }
  public void recruit() {
    mInSquad = true;
  }

  public static Map<String, Cobra> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public static Cobra getCobra(String name) {
    return instances.get(name);
  }

  public static List<Cobra> getAvailableCobra() {
    List<Cobra> availableCobra = new ArrayList<Cobra>();

    for (String key : instances.keySet()) {
      if (!instances.get(key).mInSquad) {
        availableCobra.add(instances.get(key));
      }
    }
    return availableCobra;
  }



  }
