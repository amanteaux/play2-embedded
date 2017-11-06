package org.devteam.play2embedded;

import static play.mvc.Results.ok;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.routing.RoutingDsl;
import play.server.Server;

public class WebApplication {

	private static final Logger logger = LoggerFactory.getLogger(WebApplication.class);

	public static void main(String[] args) {
		Server server = Server.forRouter(components ->
			RoutingDsl
				.fromComponents(components)
				.GET("/hello/:to")
				.routeTo(to -> ok("Hello " + to))
				.build()
		);

		logger.info("Application is available at http://localhost:{}", server.httpPort());
	}

}
