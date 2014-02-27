package mars.jpaypal.server.service.sale;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Refund;
import com.paypal.api.payments.Sale;
import com.paypal.core.rest.PayPalRESTException;

import mars.jpaypal.domain.model.sale.refund.dto.RefundDTO;
import mars.jpaypal.domain.model.sale.refund.formbean.RefundFB;
import mars.jpaypal.server.service.AccessTokenGenerator;
import mars.jpaypal.server.service.sale.internal.assembler.RefundDTOAssembler;

public final class SaleService {

  public RefundDTO refundSale(RefundFB refundFB) throws PayPalRESTException {
    String accessToken = AccessTokenGenerator.getAccessToken();
    Sale sale = Sale.get(accessToken, refundFB.getSaleId());

    Amount amount = new Amount();
    amount.setTotal(refundFB.getAmount());
    amount.setCurrency(sale.getAmount().getCurrency());

    Refund refund = new Refund();
    refund.setAmount(amount);

    Refund refunded = sale.refund(accessToken, refund);
    return new RefundDTOAssembler().toDTO(refunded);
  }

}