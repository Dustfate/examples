package org.examples.conf;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author dusf
 */
public class TaskTrackerCfgLoader {
    public TaskTrackerCfg load(String confPath) throws CfgException {
        String cfgPath = confPath + "/config.cfg";

        Properties conf = new Properties();
        File file = new File(cfgPath);
        InputStream is = null;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new CfgException("can not find " + cfgPath);
        }
        try {
            conf.load(is);
        } catch (IOException e) {
            throw new CfgException("Read " + cfgPath + " error.", e);
        }

        TaskTrackerCfg cfg = new TaskTrackerCfg();
        try {
        	String clusterName = conf.getProperty("clusterName");
            cfg.setClusterName(clusterName);

            String nodeGroup = conf.getProperty("nodeGroup");
            cfg.setNodeGroup(nodeGroup);

            Map<String, String> configs = new HashMap<String, String>();
            for (Map.Entry<Object, Object> entry : conf.entrySet()) {
                String key = entry.getKey().toString();
                if (key.startsWith("configs.")) {
                    String value = entry.getValue() == null ? null : entry.getValue().toString();
                    configs.put(key.replace("configs.", ""), value);
                }
            }

            cfg.setConfigs(configs);
        } catch (Exception e) {
            throw new CfgException(e);
        }

        return cfg;
    }

}
