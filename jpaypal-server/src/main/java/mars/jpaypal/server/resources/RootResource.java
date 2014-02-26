package mars.jpaypal.server.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at '/' path)
 */
@Path("/")
public class RootResource {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String index() {
    return String.format("Welcome to jPaypal! %n see /application.wadl for more info");
  }

}