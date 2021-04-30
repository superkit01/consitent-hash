package superkit.consistent.hash;

import com.superkit.consistent.hash.Node;
import com.superkit.consistent.hash.Router;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<ServerNode> serverList = new ArrayList<>();
        serverList.add(new ServerNode("192.168.0.1", 1000));
        serverList.add(new ServerNode("192.168.0.2", 1000));
        serverList.add(new ServerNode("192.168.0.3", 1000));
        serverList.add(new ServerNode("192.168.0.4", 1000));
        serverList.add(new ServerNode("192.168.0.5", 1000));
        serverList.add(new ServerNode("192.168.0.6", 1000));

        Router<ServerNode> route = new Router<>();

        route.init(serverList, 10);


        for (int i = 0; i < 10; i++) {
            Node node = route.route(String.valueOf(i));
            System.out.println(i + " 路由服务器:" + node.hashKey());
        }

    }
}
