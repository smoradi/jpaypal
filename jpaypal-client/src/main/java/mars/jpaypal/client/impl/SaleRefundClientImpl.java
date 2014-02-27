package mars.jpaypal.client.impl;

import static mars.jpaypal.domain.constants.Constants.*;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import mars.jpaypal.domain.constants.Paths;
import mars.jpaypal.domain.model.payment.UnexpectedHttpStatusCode;
import mars.jpaypal.domain.model.sale.refund.dto.RefundDTO;
import mars.jpaypal.domain.model.sale.refund.formbean.RefundFB;

public class SaleRefundClientImpl extends ClientBaseImpl {

  public SaleRefundClientImpl(WebTarget webTarget) {
    super(webTarget);
  }

  public RefundDTO refundSale(RefundFB refundFB) throws UnexpectedHttpStatusCode {
    Form form = new Form(saleId, refundFB.getSaleId()).
                   param(amount, refundFB.getAmount());
    Entity<Form> entity = Entity.form(form);
    Response response = this.webTarget.
        path(Paths._sale_refund).
        request(MediaType.APPLICATION_FORM_URLENCODED).
        accept(MediaType.APPLICATION_XML).
        post(entity);

    if (response.getStatus() == Status.CREATED.getStatusCode()) {
      return response.readEntity(new GenericType<RefundDTO>(){});
    }
    throw new UnexpectedHttpStatusCode(response.getStatus());
  }

}