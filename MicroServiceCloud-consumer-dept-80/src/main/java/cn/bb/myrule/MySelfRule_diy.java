package cn.bb.myrule;

import java.util.List;


import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import com.netflix.servo.jsr166e.ThreadLocalRandom;

public class MySelfRule_diy extends AbstractLoadBalancerRule {

	private Integer total = 0; //总共被调用次数
	private Integer currentIndex = 0; //当前机器服务号
	
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

            if(total < 5){
            	
            	server = upList.get(currentIndex);
            	total++;
            }else{
            	currentIndex++;
            	total = 0;
            	if(currentIndex >= allList.size()){
            		currentIndex = 0;
            	}
            	
            }
            

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	public void initWithNiwsConfig1(IClientConfig clientConfig) {
		// TODO Auto-generated method stub
		
	}

	public Server choose1(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initWithNiwsConfig(IClientConfig arg0) {
		// TODO Auto-generated method stub
		
	}
}