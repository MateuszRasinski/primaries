package com.github.mateuszrasinski.primaries;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PolandPresidentialPrimaries2015Application.class)
@WebAppConfiguration
public class PolandPresidentialPrimariesApp2015ApplicationTests {

	@Test
	public void contextLoads() {
	}

}
