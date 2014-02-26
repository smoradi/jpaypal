package mars.jpaypal.domain.constants;

public abstract class Paths {

  public final static String _payment = "/payment";
  public final static String _create = "/create";
  public final static String _execute = "/create";
  public final static String _payment_create = _payment + _create;
  public final static String _payment_execute = _payment + _execute;

}