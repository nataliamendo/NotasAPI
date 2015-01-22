package edu.upc.eetac.ea.notas;

import java.util.ResourceBundle;

import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class NotesApplication extends ResourceConfig {
	public NotesApplication() {
		super();

		register(DeclarativeLinkingFeature.class);
		//ResourceBundle bundle = ResourceBundle.getBundle("application");

	}
}
