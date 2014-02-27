package mars.jpaypal.domain.constants;

public abstract class Paths {

  public final static String _payment = "/payment";
  public final static String _create = "/create";
  public final static String _payment_create = _payment + _create;

  public final static String _sale = "/sale";
  public final static String _refund = "/refund";
  public final static String _sale_refund = _sale + _create;

}