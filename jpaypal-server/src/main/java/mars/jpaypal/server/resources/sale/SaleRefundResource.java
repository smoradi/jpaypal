package mars.jpaypal.server.resources.sale;

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
import mars.jpaypal.domain.model.sale.refund.dto.RefundDTO;
import mars.jpaypal.domain.model.sale.refund.formbean.RefundFB;
import mars.jpaypal.server.service.sale.SaleService;

@Path(Paths._sale_refund)
public class SaleRefundResource {

  private final SaleService saleService = new SaleService();

  @POST
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces(MediaType.APPLICATION_XML)
  public Response refundSale(@BeanParam RefundFB refundFB) {
    try {
      RefundDTO refundDTO = saleService.refundSale(refundFB);
      return Response.status(Status.CREATED).entity(new GenericEntity<RefundDTO>(refundDTO, RefundDTO.class)).build();
    } catch (PayPalRESTException e) {
      e.printStackTrace();
      return Response.status(Status.BAD_REQUEST).build();
    }
  }

}