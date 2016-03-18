package org.examples.conf;

import java.util.Map;

/**
 * TaskTracker 配置文件
 *
 * @author dusf
 */
public class TaskTrackerCfg {
	private String clusterName;
	private String nodeGroup;
	private Map<String, String> configs;

	public String getClusterName() {
		return clusterName;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	public Map<String, String> getConfigs() {
		return configs;
	}

	public void setConfigs(Map<String, String> configs) {
		this.configs = configs;
	}

	public String getNodeGroup() {
		return nodeGroup;
	}

	public void setNodeGroup(String nodeGroup) {
		this.nodeGroup = nodeGroup;
	}

}
