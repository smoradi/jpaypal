package mars.jpaypal.server.resources;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;

import mars.jpaypal.domain.build.BuildProps;
import mars.jpaypal.server.Main;

public abstract class ResourceTestCase extends Assert {

  private static HttpServer server;
  protected static WebTarget target;

  @BeforeClass
  public static void setUp() {
    // start the server
    server = Main.startServer();

    // _create the client
    Client client = ClientBuilder.newClient();
    target = client.target(BuildProps.serviceBaseUri);
  }

  @AfterClass
  public static void tearDown() {
    server.stop();
  }

}