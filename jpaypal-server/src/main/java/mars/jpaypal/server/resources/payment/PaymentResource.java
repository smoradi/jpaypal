package mars.jpaypal.server.resources.payment;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.paypal.core.rest.PayPalRESTException;

import mars.jpaypal.domain.constants.Paths;
import mars.jpaypal.domain.model.payment.dto.PaymentDTO;
import mars.jpaypal.domain.model.payment.dto.PaymentExecuteDTO;
import mars.jpaypal.domain.model.payment.formbean.PaymentExecuteFB;
import mars.jpaypal.domain.model.payment.formbean.PaymentFB;
import mars.jpaypal.server.service.payment.PaymentService;

public class PaymentResource {

  private final PaymentService paymentService = new PaymentService();

  @POST
  @Path(Paths._payment_create)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces(MediaType.APPLICATION_XML)
  public Response createPayment(@BeanParam PaymentFB paymentFB) {
    try {
      PaymentDTO paymentDTO = paymentService.createPayment(paymentFB);
      return Response.status(Status.CREATED).entity(new GenericEntity<PaymentDTO>(paymentDTO, PaymentDTO.class)).build();
    } catch (PayPalRESTException e) {
      e.printStackTrace();
      return Response.status(Status.BAD_REQUEST).build();
    }
  }

  @POST
  @Path(Paths._payment_execute)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces(MediaType.APPLICATION_XML)
  public Response executePayment(@BeanParam PaymentExecuteFB paymentExecuteFB) {
    try {
      PaymentExecuteDTO paymentExecuteDTO = paymentService.executePayment(paymentExecuteFB.getPaymentId(), paymentExecuteFB.getPayerId());
      return Response.status(Status.OK).entity(new GenericEntity<PaymentExecuteDTO>(paymentExecuteDTO, PaymentExecuteDTO.class)).build();
    } catch (PayPalRESTException e) {
      e.printStackTrace();
      return Response.status(Status.BAD_REQUEST).build();
    }
  }

}