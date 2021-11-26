package me.webhop.apollo.api.resource;


import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloResourceTest {
    private Logger logger = LoggerFactory.getLogger(HelloResourceTest.class);
    private String name;
    @Before
    public void setup() throws Exception {
        name = "Nite Coder";
    }
    @Test
    public void verifyLogback(){
        logger.info("Hi there coming to you from {}",name);
        Assert.assertTrue(true);
    }
}
