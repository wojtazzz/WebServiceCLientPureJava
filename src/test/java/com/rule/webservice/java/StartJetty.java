package com.rule.webservice.java;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Document me please
 * User: wfijarczyk
 * Date: 13.01.14
 */
public class StartJetty {

      public static void main(String[] args) throws Exception {
          Server server = new Server(8081);
          WebAppContext context = new WebAppContext();
          context.setDescriptor("web/WEB-INF/web.xml");
          context.setResourceBase("web");
          context.setContextPath("/");
          context.setParentLoaderPriority(true);
          server.setHandler(context);
          server.start();
          server.join();
      }
}
