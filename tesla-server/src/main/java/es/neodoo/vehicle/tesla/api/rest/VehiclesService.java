package es.neodoo.vehicle.tesla.api.rest;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.neodoo.vehicle.tesla.api.exceptions.*;
import es.neodoo.vehicle.tesla.api.params.*;
import es.neodoo.vehicle.tesla.cloud.CloudServiceInvoker;
import es.neodoo.vehicle.tesla.hardware.VehicleHardwareInvoker;

@Path("/api/1")
@Produces(MediaType.APPLICATION_JSON)
public class VehiclesService {

	private final static Logger log = Logger.getLogger(VehiclesService.class.getName());

	@GET
	@Path("/vehicles")
	public Response listVehicles() throws TeslaInvokerException {

		String json=null;

		try {
			
			ListVehiclesResponse vehiclesResponse = null;
			CloudServiceInvoker csi = new CloudServiceInvoker();
			vehiclesResponse = csi.listVehicles();
			json = vehiclesResponse.toJson();

		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}
		
		return Response.status(200).entity(json).build();
	
	}

	@GET
	@Path("/vehicles/{vehicleId}/mobile_enabled")
	public Response mobileAcces(@PathParam("vehicleId") int vehicleId) throws TeslaInvokerException  {

		String json=null;

		try {
			
			MobileAccesResponse mobileAccesResponse = null;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();
			mobileAccesResponse = vh.mobileAcces(vehicleId);
			json = mobileAccesResponse.toJson();

		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}
		
		return Response.status(200).entity(json).build();
	
	}

	@GET
	@Path("/vehicles/{vehicleId}/data_request/charge_state")
	public Response chargeState(@PathParam("vehicleId") int vehicleId) throws TeslaInvokerException {

		String json=null;

		try {
			
			ChargeStateResponse chargeStateResponse = null;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();
			chargeStateResponse = vh.chargeState(vehicleId);
			json = chargeStateResponse.toJson();

		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}
		
		return Response.status(200).entity(json).build();
	
	}

	@GET
	@Path("/vehicles/{vehicleId}/data_request/climate_state")
	public Response climateSettings(@PathParam("vehicleId") int vehicleId) throws TeslaInvokerException {

		String json=null;

		try {
			
			ClimateSettingsResponse climateSettingsResponse = null;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();
			climateSettingsResponse = vh.climateState(vehicleId);
			json = climateSettingsResponse.toJson();

		}catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}
		
		return Response.status(200).entity(json).build();
	
	}

	@GET
	@Path("/vehicles/{vehicleId}/data_request/drive_state")
	public Response drivingAndPosition(@PathParam("vehicleId") int vehicleId) throws TeslaInvokerException {

		String json=null;

		try {
			
			DrivingAndPositionResponse drivingAndPositionResponse = null;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();
			drivingAndPositionResponse = vh.drivingAndPositionState(vehicleId);
			json = drivingAndPositionResponse.toJson();

		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}
		
		return Response.status(200).entity(json).build();
	
	}

	@GET
	@Path("/vehicles/{vehicleId}/data_request/gui_settings")
	public Response guiSettings(@PathParam("vehicleId") int vehicleId) throws TeslaInvokerException {
		
		String json=null;
		
		try {
			
			GuiSettingsResponse guiSettingsResponse = null;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();
			guiSettingsResponse = vh.guiSetting(vehicleId);
			json = guiSettingsResponse.toJson();

		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}
		
		return Response.status(200).entity(json).build();
	
	}

	@GET
	@Path("/vehicles/{vehicleId}/data_request/vehicle_state")
	public Response vehicleState(@PathParam("vehicleId") int vehicleId) throws TeslaInvokerException {

		String json=null;

		try {
			
			VehicleStateResponse vehicleStateResponse = null;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();
			vehicleStateResponse = vh.vehicleState(vehicleId);
			json = vehicleStateResponse.toJson();

		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}
		
		return Response.status(200).entity(json).build();
	
	}

}
