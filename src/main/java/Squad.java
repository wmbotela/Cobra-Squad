import java.util.Map;
import java.util.HashMap;

public class Squad {
  private String mName;
  private int mMaxSize;
  private String mCause;
  private static Map<String, Squad> instances = new HashMap<String, Squad>();
  private Map<String, Cobra> mCobra;

  public Squad(String name, String cause){
    mName = name;
    mMaxSize = 8;
    mCause = cause;
    mCobra = new HashMap<String, Cobra>();
    instances.put(name, this);
  }

  public int getMax(){
    return mMaxSize;
  }

  public String getCause(){
    return mCause;
  }

  public String getName(){
    return mName;
  }

  public static Map<String, Squad> all(){
    return instances;
  }

  public static void clear(){
    instances.clear();
  }

  public void addCobra(Cobra newCobra){
    mCobra.put(newCobra.getName(), newCobra);
    newCobra.recruit();
  }

  public Map<String, Cobra> getCobras(){
    return mCobra;
  }

}
