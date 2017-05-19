package es.neodoo.vehicle.tesla.cloud;

import java.util.ArrayList;
import java.util.List;

import es.neodoo.vehicle.tesla.api.params.ListVehiclesParamResponse;
import es.neodoo.vehicle.tesla.api.params.ListVehiclesResponse;

public class CloudServiceInvoker {

	public ListVehiclesResponse listVehicles() {

		List<ListVehiclesParamResponse> listVehiclesResponseParam = new ArrayList<ListVehiclesParamResponse>();
		String[] tabla = {"token 1","token2"};
		ListVehiclesParamResponse vehiclesResponseParam= new ListVehiclesParamResponse("amarillo","nombreAleatorio",123,"opciones de algo",123,321,"cadena para el vin",tabla,"online");
		listVehiclesResponseParam.add(vehiclesResponseParam);
		int count = 1;
		ListVehiclesResponse vehiclesResponse = new ListVehiclesResponse (listVehiclesResponseParam,count);
		
		return vehiclesResponse;
	
	}

}
