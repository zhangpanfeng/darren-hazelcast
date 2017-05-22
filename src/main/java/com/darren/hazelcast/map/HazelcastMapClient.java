package com.darren.hazelcast.map;

import java.util.Set;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.Member;

public class HazelcastMapClient {

    public static void main(String[] args) {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress("127.0.0.1:5701");
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        IMap<Integer, String> map = client.getMap("customers");
        System.out.println("Map Size:" + map.size());
        System.out.println(map.get(1));
        
        Set<Member> members = client.getCluster().getMembers();
        for(Member member: members){
            System.out.println("Address = " + member.getAddress());
            System.out.println("Address = " + member.getVersion());
        }
        
        System.out.println(clientConfig.getInstanceName());
        client.shutdown();
    }
}
