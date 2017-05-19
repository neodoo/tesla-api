package es.neodoo.vehicle.tesla.api.rest;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import es.neodoo.vehicle.tesla.api.exceptions.OauthInvokerException;
import es.neodoo.vehicle.tesla.api.params.OauthRequest;

@Path("/oauth")
@Produces("application/json")
@Consumes("application/json")
public class AuthenticationService {

	private final static Logger log = Logger.getLogger(AuthenticationService.class.getName());

	@POST
	@Path("/token")
	public Response getAnAccesToken(OauthRequest oauthRequest) throws OauthInvokerException {
		// TODO autentificacion

		/*
		 * try{
		 * 
		 * }catch (OauthInvokerException e){ log.log(Level.SEVERE,
		 * "Error oauth : " + e.getMessage()); throw e; }
		 * 
		 */

		return null;
	}

}
