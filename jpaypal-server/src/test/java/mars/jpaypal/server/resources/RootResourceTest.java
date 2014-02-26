package mars.jpaypal.server.resources;

import org.junit.Test;

public class RootResourceTest extends ResourceTestCase {

  @Test
  public void testWelcomeIndex() {
    String responseMsg = target.request().get(String.class);
    assertTrue("Should contain <Welcome to jPaypal!>", responseMsg.contains("Welcome to jPaypal!"));
  }

}