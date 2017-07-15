package resource.indirection;

/**
 * Created by hotjoyit on 2017-07-15.
 */
public class Heavy {
  public Heavy() {
    System.out.println("Heavy created");
  }

  @Override
  public String toString() {
    return "Quite heavy";
  }
}
