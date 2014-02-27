package mars.jpaypal.domain.model.sale.refund.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class RefundDTO implements Serializable {

  private String id;
  private String state;

  public RefundDTO() {
    // Needed by Jersey
  }

  public RefundDTO(String id,
                   String state) {
    this.id = id;
    this.state = state;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return String.format(
        "Id: %s%n State: %s%n"
        , id, state);
  }

}