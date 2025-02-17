package com.udacity.pricing;

import com.udacity.pricing.api.PricingController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(PricingController.class)
public class PricingServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetPrice() throws Exception {
		mockMvc.perform(get("/services/price").param("vehicleId", "1"))
				.andExpect(status().isOk());
	}

	@Test
	public void testGetPriceWithInvalidId() throws Exception {
		mockMvc.perform(get("/services/price").param("vehicleId", "500"))
				.andExpect(status().isNotFound());
	}
}
