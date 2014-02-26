package mars.jpaypal.client.impl;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import mars.jpaypal.client.JPaypalClient;
import mars.jpaypal.domain.build.BuildProps;
import mars.jpaypal.domain.model.payment.UnexpectedHttpStatusCode;
import mars.jpaypal.domain.model.payment.dto.PaymentDTO;
import mars.jpaypal.domain.model.payment.dto.PaymentExecuteDTO;
import mars.jpaypal.domain.model.payment.formbean.PaymentExecuteFB;
import mars.jpaypal.domain.model.payment.formbean.PaymentFB;

public final class JPaypalClientImpl extends ClientBaseImpl implements JPaypalClient {

  private final PaymentRequestClientImpl paymentRequestClientImpl; 

  public JPaypalClientImpl(final WebTarget webTarget) {
    super(webTarget);
    paymentRequestClientImpl = new PaymentRequestClientImpl(webTarget);
  }

  public static JPaypalClient newClient() {
    Client client = ClientBuilder.newClient();
    WebTarget webTarget = client.target(BuildProps.serviceBaseUri);
    return new JPaypalClientImpl(webTarget);
  }

  @Override
  public PaymentDTO createPayment(final PaymentFB paymentFB) throws UnexpectedHttpStatusCode {
    return paymentRequestClientImpl.createPayment(paymentFB);
  }

  @Override
  public PaymentExecuteDTO executePayment(final PaymentExecuteFB paymentExecuteFB) throws UnexpectedHttpStatusCode {
    return paymentRequestClientImpl.executePayment(paymentExecuteFB);
  }

}