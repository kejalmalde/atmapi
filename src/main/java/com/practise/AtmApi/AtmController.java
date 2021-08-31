package com.practise.AtmApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practise.AtmApi.resource.Atm;

@RestController
public class AtmController {

	@Autowired
	Atm atm;

	RestTemplate resttemplate = new RestTemplate();
	List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
	MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	List<MediaType> mediaTypes = new ArrayList<MediaType>();

	@GetMapping("/atms")
	public List<Atm> getAtm() throws JsonMappingException, JsonProcessingException {

		mediaTypes.add(MediaType.TEXT_PLAIN);
		converter.setSupportedMediaTypes(mediaTypes);
		messageConverters.add(converter);
		messageConverters.add(new StringHttpMessageConverter());
		resttemplate.setMessageConverters(messageConverters);

		String forObject = resttemplate.getForObject("https://www.ing.nl/api/locator/atms/", String.class);

		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		List<Atm> atms = om.readValue(forObject.substring(forObject.indexOf("[")), new TypeReference<List<Atm>>() {});
		return atms;

	}

	@GetMapping("/atms/{city}")
	public List<Atm> getAtmforCity(@PathVariable("city") String city)
			throws JsonMappingException, JsonProcessingException {

		mediaTypes.add(MediaType.TEXT_PLAIN);
		converter.setSupportedMediaTypes(mediaTypes);
		messageConverters.add(converter);
		messageConverters.add(new StringHttpMessageConverter());
		resttemplate.setMessageConverters(messageConverters);

		String forObject = resttemplate.getForObject("https://www.ing.nl/api/locator/atms/", String.class);

		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		List<Atm> atms = om.readValue(forObject.substring(forObject.indexOf("[")), new TypeReference<List<Atm>>() {});

		Map<String, List<Atm>> mapAtm = new HashMap<>();
		for (Atm a : atms) {
			List<Atm> list;
			if (mapAtm.containsKey(a.getAddress().getCity())) {
				list = mapAtm.get(a.getAddress().getCity());
			} else {
				list= new ArrayList<>();
				
			}
			list.add(a);
			mapAtm.put(a.getAddress().getCity(), list);
		}

		return mapAtm.get(city);

	}

}
