package superkit.consistent.hash;

import com.superkit.consistent.hash.Node;

public class ServerNode implements Node {


    private final String ip;
    private final Integer port;

    public ServerNode(String ip, Integer port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public String hashKey() {
        return this.ip + ":" + this.port;
    }

}
