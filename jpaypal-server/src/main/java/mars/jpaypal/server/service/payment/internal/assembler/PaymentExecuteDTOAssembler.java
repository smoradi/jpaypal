package mars.jpaypal.server.service.payment.internal.assembler;

import com.paypal.api.payments.Payment;

import mars.jpaypal.domain.model.payment.dto.PaymentExecuteDTO;

/**
 * Assembler class for the PaymentExecuteDTO.
 */
public class PaymentExecuteDTOAssembler {

  public PaymentExecuteDTO toDTO(final Payment payment) {
    final PaymentExecuteDTO dto = new PaymentExecuteDTO(
       payment.getId(),
       payment.getPayer().getPayerInfo().getPayerId(),
       payment.getState(),
       payment.getTransactions().get(0).getRelatedResources().get(0).getSale().getId(),
       payment.getTransactions().get(0).getRelatedResources().get(0).getSale().getState(),
       payment.getUpdateTime());
    return dto;
  }

}