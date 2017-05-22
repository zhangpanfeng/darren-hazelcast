package com.darren.hazelcast.map;

import java.util.Map;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelcastMapServer {

    public static void main(String[] args) {
        // cfg
        Config cfg = new Config();
        cfg.setInstanceName("test instance");
        HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);
        Map<Integer, String> mapCustomers = instance.getMap("customers");
        mapCustomers.put(1, "Joe");
        mapCustomers.put(2, "Ali");
        mapCustomers.put(3, "Avi");

        System.out.println("Customer with key 1: " + mapCustomers.get(1));
        System.out.println("Map Size:" + mapCustomers.size());
    }
}
