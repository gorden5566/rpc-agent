package com.gorden5566.rpc.agent.server;

import java.net.InetSocketAddress;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import com.gorden5566.rpc.agent.server.servlet.InvokerServlet;

/**
 * @author gorden5566
 * @date 2020/08/18
 */
public class JettyAgentServer extends AbstractAgentServer {

    private Server server;

    public JettyAgentServer(String host, int port) {
        super(host, port);
    }

    @Override
    public void start() throws Exception {
        InetSocketAddress address = new InetSocketAddress(host, port);
        server = new Server(address);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(InvokerServlet.class, INVOKER_PATH);

        server.start();
        System.out.println("server started, agent path: [" + formatAddress(address, INVOKER_PATH) + "]");

        server.join();
    }

    @Override
    public void stop() throws Exception {
        server.stop();
    }
}
