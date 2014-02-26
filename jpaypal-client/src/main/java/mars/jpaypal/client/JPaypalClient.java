package mars.jpaypal.client;

import mars.jpaypal.domain.model.payment.UnexpectedHttpStatusCode;
import mars.jpaypal.domain.model.payment.dto.PaymentDTO;
import mars.jpaypal.domain.model.payment.dto.PaymentExecuteDTO;
import mars.jpaypal.domain.model.payment.formbean.PaymentExecuteFB;
import mars.jpaypal.domain.model.payment.formbean.PaymentFB;

public interface JPaypalClient {

  public PaymentDTO createPayment(PaymentFB paymentFB) throws UnexpectedHttpStatusCode;

  public PaymentExecuteDTO executePayment(PaymentExecuteFB paymentExecuteFB) throws UnexpectedHttpStatusCode;

}