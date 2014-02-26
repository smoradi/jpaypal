package mars.jpaypal.domain.model.payment.formbean;

import javax.ws.rs.FormParam;

import mars.jpaypal.domain.constants.Constants;

public class PaymentExecuteFB {

  @FormParam(Constants.paymentId)
  private String paymentId;

  @FormParam(Constants.payerId)
  private String payerId;

  public PaymentExecuteFB() {
    // Needed by Jersey
  }

  public PaymentExecuteFB(final String paymentId,
                          final String payerId) {
    this.paymentId = paymentId;
    this.payerId = payerId;
  }

  public String getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(String paymentId) {
    this.paymentId = paymentId;
  }

  public String getPayerId() {
    return payerId;
  }

  public void setPayerId(String payerId) {
    this.payerId = payerId;
  }

}