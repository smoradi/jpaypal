package mars.jpaypal.domain.model.payment.formbean;


import javax.ws.rs.FormParam;

import mars.jpaypal.domain.constants.Constants;

public class PaymentFB {

  @FormParam(Constants.amount)
  private String amount;

  @FormParam(Constants.currency)
  private String currency;

  @FormParam(Constants.description)
  private String description;

  @FormParam(Constants.returnUrl)
  private String returnUrl;

  @FormParam(Constants.cancelUrl)
  private String cancelUrl;

  public PaymentFB() {
    // Needed by Jersey
  }

  public PaymentFB(final String amount,
                   final String currency,
                   final String description,
                   final String returnUrl,
                   final String cancelUrl) {
    this.amount = amount;
    this.currency = currency;
    this.description = description;
    this.returnUrl = returnUrl;
    this.cancelUrl = cancelUrl;
  }

  public String getAmount() {
    return amount;
  }

  public String getCurrency() {
    return currency;
  }

  public String getDescription() {
    return description;
  }

  public String getReturnUrl() {
    return returnUrl;
  }

  public String getCancelUrl() {
    return cancelUrl;
  }

}