package mars.jpaypal.client;

import mars.jpaypal.domain.model.payment.UnexpectedHttpStatusCode;
import mars.jpaypal.domain.model.payment.dto.PaymentDTO;
import mars.jpaypal.domain.model.payment.dto.PaymentExecuteDTO;
import mars.jpaypal.domain.model.payment.formbean.PaymentExecuteFB;
import mars.jpaypal.domain.model.payment.formbean.PaymentFB;
import mars.jpaypal.domain.model.sale.refund.dto.RefundDTO;
import mars.jpaypal.domain.model.sale.refund.formbean.RefundFB;

public interface JPaypalClient {

  public PaymentDTO createPayment(PaymentFB paymentFB) throws UnexpectedHttpStatusCode;

  public PaymentExecuteDTO executePayment(PaymentExecuteFB paymentExecuteFB) throws UnexpectedHttpStatusCode;

  public RefundDTO refundSale(RefundFB refundFB) throws UnexpectedHttpStatusCode;
}