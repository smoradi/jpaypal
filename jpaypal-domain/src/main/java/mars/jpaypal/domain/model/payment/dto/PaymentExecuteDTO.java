package mars.jpaypal.domain.model.payment.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PaymentExecuteDTO {

  private String paymentId;
  private String payerId;
  private String state;
  private String saleId;
  private String saleState;
  private String updateTime;

  PaymentExecuteDTO() {
    // Needed by Jersey
  }

  public PaymentExecuteDTO(final String paymentId,
                           final String payerId,
                           final String state,
                           final String saleId,
                           final String saleState,
                           final String updateTime) {
    this.paymentId = paymentId;
    this.payerId = payerId;
    this.state = state;
    this.saleId = saleId;
    this.saleState = saleState;
    this.updateTime = updateTime;
  }

  public String getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(String paymentId) {
    this.paymentId = paymentId;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getSaleId() {
    return saleId;
  }

  public void setSaleId(String saleId) {
    this.saleId = saleId;
  }

  public String getSaleState() {
    return saleState;
  }

  public void setSaleState(String saleState) {
    this.saleState = saleState;
  }

  public String getPayerId() {
    return payerId;
  }

  public void setPayerId(String payerId) {
    this.payerId = payerId;
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

}