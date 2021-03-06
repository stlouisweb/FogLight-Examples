package com.ociweb.iot.track1;

import org.junit.Test;

import com.ociweb.iot.hardware.impl.test.TestHardware;
import com.ociweb.iot.hardware.impl.test.TestI2CBacking;
import com.ociweb.iot.maker.FogRuntime;
import com.ociweb.pronghorn.stage.scheduling.NonThreadScheduler;

/**
 * Unit test for simple App.
 */
public class AppTest { 

	
	@Test
	public void testApp() {
	    	FogRuntime runtime = FogRuntime.test(new IoTApp());
	    	    	

	    	TestHardware hardware = (TestHardware)runtime.getHardware();
	    
	    	TestI2CBacking backing = (TestI2CBacking)hardware.i2cBacking;
	    	
	    	NonThreadScheduler scheduler = (NonThreadScheduler)runtime.getScheduler();    	
	    	scheduler.startup();
	    	
	    	hardware.clearI2CWriteCount();
	    	
	    	hardware.write(IoTApp.ANGLE_SENSOR_PORT, 512);
	    	hardware.write(IoTApp.LIGHT_SENSOR_PORT, 300);
	    	
	    	
	    	
	    	
	 
//	    	scheduler.run();
//	    	
//	    	int i = hardware.getI2CWriteCount();
//	    	while (i>0) {
//	    		
//	    		hardware.outputLastI2CWrite(System.out,i--);
//	    		
//	    	}
	    	
	    	
	    	//need ring of commands so it can be checked.
	    	//assertEquals(Grove_LCD_RGB.RGB_ADDRESS, backing.lastWriteAddress);
	    	
	    	
	    	//TODO: must ask I2C LCD for its brightness.
	    	
	    	
	    	//test application here
	    	
    }
	 
}
