package mars.jpaypal.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import mars.jpaypal.client.impl.JPaypalClientImpl;
import mars.jpaypal.domain.model.payment.UnexpectedHttpStatusCode;
import mars.jpaypal.domain.model.payment.dto.PaymentDTO;
import mars.jpaypal.domain.model.payment.formbean.PaymentFB;
import mars.jpaypal.server.Main;

public class PaymentClientIntegrationTest {

  private static HttpServer httpServer;

  @BeforeClass
  public static void setup() {
    httpServer = Main.startServer();
  }

  @AfterClass
  public static void teardown() {
    httpServer.stop();
  }

  @Test
  public void createPayment() {
    JPaypalClient client = JPaypalClientImpl.newClient();
    PaymentFB paymentFB = new PaymentFB("1.00",
                                        "USD",
                                        "Test charge account for xyz",
                                        "http://localhost:8080/success",
                                        "http://localhost:8080/cancel");
    try {
      PaymentDTO createdPayment = client.createPayment(paymentFB);
      assertNotNull("created payment should not be null", createdPayment);
      assertNotNull("payment token should not be null", createdPayment.getToken());
    } catch (UnexpectedHttpStatusCode e) {
      assertEquals("404", e.getStatuscode()+"");
    }
  }

}