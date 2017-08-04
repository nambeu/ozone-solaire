package com.paperjais.ozone.restController.utils;

import org.springframework.http.HttpHeaders;

public class HeaderUtilDouble {

	public static HttpHeaders createAlert(String message, String param) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("X-ozonesolaireApp-alert", message);
		headers.add("X-ozonesolaireApp-params", param);
		return headers;
	}

	public static HttpHeaders createEntityCreationAlert(String entityName,
			String param) {
		return createAlert("ozonesolaireApp." + entityName + ".created", param);
	}

	public static HttpHeaders createEntityUpdateAlert(String entityName,
			String param) {
		return createAlert("ozonesolaireApp." + entityName + ".updated", param);
	}

	public static HttpHeaders createEntityDeletionAlert(String entityName,
			String param) {
		return createAlert("ozonesolaireApp." + entityName + ".deleted", param);
	}

}
