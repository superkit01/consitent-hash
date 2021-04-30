# 一致性哈希算法的实现


Router: ring-->Hash环（采用TreeMap实现）
```
Hash环管理 节点的增加、删除及路由算法

```

VNode: 分布于Hash环上的节点封装，内部包含了真实节点的指向
```
public class VNode <T extends Node> implements Node {
    /**
     * 真实节点
     */
    private final T node;

    /**
     * hash环分布使用的随机数
     */
    private int index = 0;
```


Node: 真实节点
```
参考Test下ServerNode实现
```

Hash：节点分布于hash环采用的分布算法

```
其他算法： https://www.cnblogs.com/wanghetao/p/4658471.html
```

Test：测试