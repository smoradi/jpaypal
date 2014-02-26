package mars.jpaypal.client.impl;

import javax.ws.rs.client.WebTarget;

public abstract class ClientBaseImpl {

  protected final WebTarget webTarget;

  public ClientBaseImpl(WebTarget webTarget) {
    this.webTarget = webTarget;
  }

}