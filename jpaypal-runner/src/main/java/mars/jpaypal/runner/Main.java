package mars.jpaypal.runner;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public final class Main {

  public static void main(String[] args) throws Exception {

    final Server server = createServer();
    server.start();
    server.join();
  }

  public static Server createServer() {

    String webPort = System.getenv("PORT");     // Heroku deploy friendly
    if (webPort == null || webPort.isEmpty()) {
      webPort = "9988";
    }

    Server server = new Server(Integer.valueOf(webPort));
    final WebAppContext root = new WebAppContext();

    root.setContextPath("/");
    root.setParentLoaderPriority(true); // ref: http://wiki.eclipse.org/Jetty/Reference/Jetty_Classloading

    final String webappDirLocation = "src/main/webapp";
    root.setResourceBase(webappDirLocation);
    root.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");

    server.setHandler(root);
    return server;
  }

}