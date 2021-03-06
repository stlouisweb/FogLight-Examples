package com.ociweb.iot.project.tankLevelMonitor;


import static com.ociweb.iot.grove.GroveTwig.Button;
import static com.ociweb.iot.grove.GroveTwig.UltrasonicRanger;
import static com.ociweb.iot.maker.Port.A0;
import static com.ociweb.iot.maker.Port.D2;

import com.ociweb.iot.maker.FogRuntime;
import com.ociweb.iot.maker.Hardware;
import com.ociweb.iot.maker.FogApp;

public class IoTApp implements FogApp
{

    public static void main( String[] args ) {
        FogRuntime.run(new IoTApp());
    }
    
    
    @Override
    public void declareConnections(Hardware c) {
        ////////////////////////////
        //Connection specifications
        ///////////////////////////
        
        // // specify each of the connections on the harware, eg which component is plugged into which connection.        
              
        c.connect(Button, D2);
        c.connect(UltrasonicRanger, A0);
        
        
    }


    @Override
    public void declareBehavior(FogRuntime runtime) {
        //////////////////////////////
        //Specify the desired behavior
        //////////////////////////////
        
    	 runtime.registerListener(new IoTBehavior(runtime));
    }
        
  
}
