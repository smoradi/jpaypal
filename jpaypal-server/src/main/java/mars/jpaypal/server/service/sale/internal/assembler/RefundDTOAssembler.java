package mars.jpaypal.server.service.sale.internal.assembler;

import com.paypal.api.payments.Refund;

import mars.jpaypal.domain.model.sale.refund.dto.RefundDTO;

/**
 * Assembler class for the RefundDTO.
 */
public class RefundDTOAssembler {

  public RefundDTO toDTO(final Refund refund) {
    final RefundDTO dto = new RefundDTO(
      refund.getId(), refund.getState()
    );
    return dto;
  }

}