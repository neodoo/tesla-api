package es.neodoo.vehicle.tesla.api.params;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StartChargingResponse {
	
	private ResponseParamVehicleCommands response;

	public ResponseParamVehicleCommands getResponse() {
		return response;
	}

	public void setResponse(ResponseParamVehicleCommands response) {
		this.response = response;
	}

	public String toJson() throws JsonProcessingException {

		String jsonInString = null;

		ObjectMapper mapper = new ObjectMapper();

		//Object to JSON in String
		jsonInString = mapper.writeValueAsString(this);

		return jsonInString;

	}

	public static StartChargingResponse toObject(String jsonInString) throws JsonParseException, JsonMappingException, IOException {

		StartChargingResponse startChargingResponse;

		//JSON from String to Object
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(Feature.ALLOW_COMMENTS, true);
		startChargingResponse = mapper.readValue(jsonInString, StartChargingResponse.class);

		return startChargingResponse;

	}

	public StartChargingResponse(){}
	
	public StartChargingResponse(ResponseParamVehicleCommands responseParamVehicleCommands){
	
		response=responseParamVehicleCommands;
	
	}

}