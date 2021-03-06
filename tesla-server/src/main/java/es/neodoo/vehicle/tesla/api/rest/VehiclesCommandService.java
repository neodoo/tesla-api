package es.neodoo.vehicle.tesla.api.rest;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import es.neodoo.vehicle.tesla.api.exceptions.*;
import es.neodoo.vehicle.tesla.api.params.*;
import es.neodoo.vehicle.tesla.hardware.VehicleHardwareInvoker;

@Path("/api/1/vehicles")
@Produces("application/json")
@Consumes("application/json")
public class VehiclesCommandService {

	private final static Logger log = Logger.getLogger(VehiclesCommandService.class.getName());

	@POST
	@Path("/{vehicleId}/wake_up")
	public Response WakeUpCar(@PathParam("vehicleId") int vehicleId) throws TeslaInvokerException{

		String json=null;

		try {

			WakeUpCarResponse wakeUpResponse = null; 
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();	
			wakeUpResponse = vh.wakeUpCar(vehicleId);
			json = wakeUpResponse.toJson();

		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}

		return Response.status(200).entity(json).build();

	}

	@POST
	@Path("/{vehicleId}/command/set_valet_mode")
	public Response SetValetMode(@PathParam("vehicleId") int vehicleId, @QueryParam("onoff")Boolean on, @QueryParam("pin") int pin) throws TeslaInvokerException {

		String json=null;

		try {

			SetValetModeResponse setValetModeResponse = null;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();	
			setValetModeResponse = vh.setValetMode(vehicleId, on, pin);
			json = setValetModeResponse.toJson();

		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}

		return Response.status(200).entity(json).build();

	}

	@POST
	@Path("/{vehicleId}/command/reset_valet_pin")
	public Response ResetValetPin(@PathParam("vehicleId") int vehicleId) throws TeslaInvokerException {

		String json=null;

		try {

			ResetValetPinResponse resetValetPinResponse = null;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();
			resetValetPinResponse = vh.resetValetPin(vehicleId);			
			json = resetValetPinResponse.toJson();

		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}

		return Response.status(200).entity(json).build();

	}

	@POST
	@Path("/{vehicleId}/command/charge_port_door_open")
	public Response OpenChargePort(@PathParam("vehicleId") int vehicleId) throws TeslaInvokerException {

		String json=null;

		try {

			OpenChargePortResponse openChargePortResponse = null;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();
			openChargePortResponse = vh.openChargeDoor(vehicleId);
			json = openChargePortResponse.toJson();

		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}

		return Response.status(200).entity(json).build();

	}

	@POST
	@Path("/{vehicleId}/command/charge_standard")
	public Response setChargeLimitToStandard(@PathParam("vehicleId") int vehicleId) throws TeslaInvokerException {

		String json=null;

		try {

			SetChargeLimitToStandardResponse setChargeLimitToStandardResponse = null;;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();
			setChargeLimitToStandardResponse = vh.setChargeLimitToStandard(vehicleId);
			json = setChargeLimitToStandardResponse.toJson();

		}catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}

		return Response.status(200).entity(json).build();

	}

	@POST
	@Path("/{vehicleId}/command/charge_max_range")
	public Response setChargeLimitToMaxRange(@PathParam("vehicleId") int vehicleId) throws TeslaInvokerException {

		String json=null;

		try {

			SetChargeLimitToMaxRangeResponse setChargeLimitToMaxRangeResponse = null;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();
			setChargeLimitToMaxRangeResponse = vh.setChargeLimitToMaxRange(vehicleId);	
			json = setChargeLimitToMaxRangeResponse.toJson();

		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}

		return Response.status(200).entity(json).build();

	}

	@POST
	@Path("/{vehicleId}/command/set_charge_limit")
	public Response setChargeLimit(@PathParam("vehicleId") int vehicleId, @QueryParam("percent")int percent) throws TeslaInvokerException {

		String json=null;

		try {

			SetChargeLimitResponse setChargeLimitResponse = null;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();
			setChargeLimitResponse = vh.setChargeLimitT(vehicleId, percent);
			json = setChargeLimitResponse.toJson();

		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
			throw new TeslaInvokerException("Error invoking set charge limit service: " + e.getMessage());
		}

		return Response.status(200).entity(json).build();

	}

	@POST
	@Path("/{vehicleId}/command/charge_start")
	public Response startCharging(@PathParam("vehicleId") int vehicleId) throws TeslaInvokerException {

		String json=null;

		try {

			StartChargingResponse startChargingResponse = null;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();
			startChargingResponse = vh.startCharging(vehicleId);
			json = startChargingResponse.toJson();

		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}

		return Response.status(200).entity(json).build();

	}

	@POST
	@Path("/{vehicleId}/command/charge_stop")
	public Response stopCharging(@PathParam("vehicleId") int vehicleId) throws TeslaInvokerException {

		String json=null;

		try {

			StopChargingResponse stopChargingResponse = null;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();
			stopChargingResponse = vh.stopCharging(vehicleId);
			json = stopChargingResponse.toJson();

		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}

		return Response.status(200).entity(json).build();

	}


	@POST
	@Path("/{vehicleId}/command/flash_lights")
	public Response flashLights(@PathParam("vehicleId") int vehicleId) throws TeslaInvokerException {

		String json=null;

		try {

			FlashLightsResponse flashLightsResponse = null;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();
			flashLightsResponse = vh.flashLights(vehicleId);
			json = flashLightsResponse.toJson();

		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}

		return Response.status(200).entity(json).build();

	}


	@POST
	@Path("/{vehicleId}/command/honk_horn")
	public Response honkHorn(@PathParam("vehicleId") int vehicleId) throws TeslaInvokerException {

		String json=null;

		try {

			HonkHornResponse honkHornResponse = null;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();
			honkHornResponse= vh.honkHorn(vehicleId);
			json = honkHornResponse.toJson();

		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}

		return Response.status(200).entity(json).build();

	}

	@POST
	@Path("/{vehicleId}/command/door_unlock")
	public Response unlockDoors(@PathParam("vehicleId") int vehicleId) throws TeslaInvokerException {

		String json=null;

		try {

			UnlockDoorsResponse unlockDoorsResponse = null;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();
			unlockDoorsResponse = vh.unlockDoors(vehicleId);
			json = unlockDoorsResponse.toJson();

		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}

		return Response.status(200).entity(json).build();

	}

	@POST
	@Path("/vehicles/{vehicleId}/command/door_lock")
	public Response lockDoors(@PathParam("vehicleId") int vehicleId) throws TeslaInvokerException {

		String json=null;

		try {

			LockDoorsResponse lockDoorsResponse = null;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();
			lockDoorsResponse = vh.lockDoors(vehicleId);
			json = lockDoorsResponse.toJson();

		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}

		return Response.status(200).entity(json).build();

	}

	@POST
	@Path("/{vehicleId}/command/set_temps")
	public Response setTemperature(@PathParam("vehicleId") int vehicleId, @QueryParam("driver_temp")double driverTemp, @QueryParam("passenger_temp") double passengerTemp) throws TeslaInvokerException {

		String json=null;

		try {

			SetTemperatureResponse setTemperatureResponse = null;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();
			setTemperatureResponse = vh.setTemperature(vehicleId, driverTemp, passengerTemp);
			json = setTemperatureResponse.toJson();

		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}

		return Response.status(200).entity(json).build();

	}

	@POST
	@Path("/{vehicleId}/command/auto_conditioning_start")
	public Response startHvacSystem(@PathParam("vehicleId") int vehicleId) throws TeslaInvokerException {

		String json=null;

		try {

			StartHvacSystemResponse startHvacSystemResponse = null;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();
			startHvacSystemResponse = vh.startHvacSystem(vehicleId);
			json = startHvacSystemResponse.toJson();

		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}

		return Response.status(200).entity(json).build();

	}

	@POST
	@Path("/{vehicleId}/command/auto_conditioning_stop")
	public Response stopHvacSystem(@PathParam("vehicleId") int vehicleId) throws TeslaInvokerException {

		String json=null;

		try {

			StopHvacSystemResponse stopHvacSystemResponse = null;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();
			stopHvacSystemResponse = vh.stopHvacSystem(vehicleId);
			json = stopHvacSystemResponse.toJson();

		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}

		return Response.status(200).entity(json).build();

	}

	@POST
	@Path("/{vehicleId}/command/sun_roof_control")
	public Response MovePanoRoof(@PathParam("vehicleId") int vehicleId, @QueryParam("state")String state, @QueryParam("percent") int percent) throws TeslaInvokerException {

		String json=null;

		try {

			MovePanoRoofResponse movePanoRoofResponse = null;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();
			movePanoRoofResponse = vh.movePanoRoof(vehicleId, state, percent);
			json = movePanoRoofResponse.toJson();

		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}

		return Response.status(200).entity(json).build();

	}

	@POST
	@Path("/{vehicleId}/command/remote_start_drive")
	public Response remoteStart(@PathParam("vehicleId") int vehicleId, @QueryParam("password")String password) throws TeslaInvokerException {

		String json=null;

		try {

			RemoteStartResponse remoteStartResponse = null;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();
			remoteStartResponse = vh.remoteStart(vehicleId);			
			json = remoteStartResponse.toJson();
			
		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}
		
		return Response.status(200).entity(json).build();
	
	}

	@POST
	@Path("/{vehicleId}/command/trunk_open")
	public Response openTrunk(@PathParam("vehicleId") int vehicleId, @QueryParam("which")String which) throws TeslaInvokerException {
	
		String json=null;
		
		try {
		
			OpenTrunkResponse openTrunkResponse = null;
			VehicleHardwareInvoker vh = new VehicleHardwareInvoker();
			openTrunkResponse = vh.openTrunk(vehicleId, which);
			json = openTrunkResponse.toJson();
		
		} catch (IOException e) {
			log.log(Level.SEVERE, "Error invoking Tesla API : " + e.getMessage());
		}
		
		return Response.status(200).entity(json).build();
	
	}

}