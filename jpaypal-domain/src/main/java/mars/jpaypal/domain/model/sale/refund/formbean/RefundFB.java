package mars.jpaypal.domain.model.sale.refund.formbean;

import javax.ws.rs.FormParam;

import mars.jpaypal.domain.constants.Constants;

public class RefundFB {

  @FormParam(Constants.saleId)
  private String saleId;

  @FormParam(Constants.amount)
  private String amount;

  public RefundFB() {
    // Needed by Jersey
  }

  public RefundFB(final String saleId,
                  final String amount) {
    this.saleId = saleId;
    this.amount = amount;
  }

  public String getSaleId() {
    return saleId;
  }

  public void setSaleId(String saleId) {
    this.saleId = saleId;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

}