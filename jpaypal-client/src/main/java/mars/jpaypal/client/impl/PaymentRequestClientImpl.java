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
import mars.jpaypal.domain.model.payment.dto.PaymentDTO;
import mars.jpaypal.domain.model.payment.dto.PaymentExecuteDTO;
import mars.jpaypal.domain.model.payment.formbean.PaymentExecuteFB;
import mars.jpaypal.domain.model.payment.formbean.PaymentFB;

public final class PaymentRequestClientImpl extends ClientBaseImpl {

  public PaymentRequestClientImpl(WebTarget webTarget) {
    super(webTarget);
  }

  public PaymentDTO createPayment(PaymentFB paymentFB) throws UnexpectedHttpStatusCode {
    Form form = new Form(amount, paymentFB.getAmount()).
                   param(currency, paymentFB.getCurrency()).
                   param(description, paymentFB.getDescription()).
                   param(returnUrl, paymentFB.getReturnUrl()).
                   param(cancelUrl, paymentFB.getCancelUrl());
    Entity<Form> entity = Entity.form(form);
    Response response = this.webTarget.
        path(Paths._payment_create).
        request(MediaType.APPLICATION_FORM_URLENCODED).
        accept(MediaType.APPLICATION_XML).
        post(entity);
    if (response.getStatus() == Status.CREATED.getStatusCode()) {
      return response.readEntity(new GenericType<PaymentDTO>(){});
    }
    throw new UnexpectedHttpStatusCode(response.getStatus());
  }

  public PaymentExecuteDTO executePayment(PaymentExecuteFB paymentExecuteFB) throws UnexpectedHttpStatusCode {
    Form form = new Form(paymentId, paymentExecuteFB.getPaymentId()).
                   param(payerId, paymentExecuteFB.getPayerId());
    Entity<Form> entity = Entity.form(form);
    Response response = this.webTarget.
        path(Paths._payment_create).
        request(MediaType.APPLICATION_FORM_URLENCODED).
        accept(MediaType.APPLICATION_XML).
        put(entity);
    if (response.getStatus() == Status.OK.getStatusCode()) {
      return response.readEntity(new GenericType<PaymentExecuteDTO>(){});
    }
    throw new UnexpectedHttpStatusCode(response.getStatus());
  }

}