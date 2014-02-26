package mars.jpaypal.domain.model.payment.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class PaymentDTO implements Serializable {

  private String token;
  private String amount;
  private String currency;
  private String description;
  private String state;
  private String createTime;
  private String updateTime;
  private String approvalUrl;

  public PaymentDTO() {
    // Needed by Jersey
  }

  public PaymentDTO(String token,
                    String amount,
                    String currency,
                    String description,
                    String state,
                    String createTime,
                    String updateTime,
                    String approvalUrl) {
    this.token = token;
    this.amount = amount;
    this.currency = currency;
    this.description = description;
    this.state = state;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.approvalUrl = approvalUrl;
  }

  public String getToken() {
    return token;
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

  public String getState() {
    return state;
  }

  public String getCreateTime() {
    return createTime;
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public String getApprovalUrl() {
    return approvalUrl;
  }

  @Override
  public String toString() {
    return String.format(
        "Token: %s%n Amount: %s%n Currency: %s%n Description: %s%n" +
        "State: %s%n CreateTime: %s%n UpdateTime: %s%n"
        , token, amount, currency, description, state, createTime, updateTime);
  }

  public void setToken(String token) {
    this.token = token;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setState(String state) {
    this.state = state;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

  public void setApprovalUrl(String approvalUrl) {
    this.approvalUrl = approvalUrl;
  }

}