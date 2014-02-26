package mars.jpaypal.domain.model.payment;

public class UnexpectedHttpStatusCode extends Exception {

  private final Integer statuscode;

  public UnexpectedHttpStatusCode(final Integer statusCode) {
    this.statuscode = statusCode;
  }

  @Override
  public String getMessage() {
    return "Unexpected status code " + statuscode + " received.";
  }

  public Integer getStatuscode() {
    return statuscode;
  }

}