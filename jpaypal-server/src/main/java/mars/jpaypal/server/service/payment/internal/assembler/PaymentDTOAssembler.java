package mars.jpaypal.server.service.payment.internal.assembler;

import static mars.jpaypal.domain.constants.Constants.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.paypal.api.payments.Links;

import com.paypal.api.payments.Payment;

import mars.jpaypal.domain.model.payment.dto.PaymentDTO;

/**
 * Assembler class for the PaymentDTO.
 */
public class PaymentDTOAssembler {

  public PaymentDTO toDTO(final Payment payment) {
    final PaymentDTO dto = new PaymentDTO(
        payment.getId(),
        payment.getTransactions().get(0).getAmount().getDetails().getSubtotal(),
        payment.getTransactions().get(0).getAmount().getCurrency(),
        payment.getTransactions().get(0).getDescription(),
        payment.getState(),
        payment.getCreateTime(),
        payment.getUpdateTime(),
        approvalUrl(payment));
    return dto;
  }

  private String approvalUrl(Payment payment) {
    String approvalUrl = null;
    for (Links l : payment.getLinks()) {
      if (l.getRel().equalsIgnoreCase(paypalApprovalUrl)) {
        try {
          approvalUrl = URLDecoder.decode(l.getHref(), UTF_8);
        } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
        }
      }
    }
    return approvalUrl;
  }

}