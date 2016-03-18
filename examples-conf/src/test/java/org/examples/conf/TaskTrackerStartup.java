package org.examples.conf;

import org.junit.Test;

/**
 * @author dusf
 */
public class TaskTrackerStartup {
	String cfgPath = "D:\\git\\examples\\examples-conf\\resource";
	
    @Test
    public void start(){
    	try {
            TaskTrackerCfg cfg = new TaskTrackerCfgLoader().load(cfgPath);
            System.out.println(cfg.getClusterName());
            System.out.println(cfg.getNodeGroup());
        } catch (CfgException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
