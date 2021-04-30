package com.superkit.consistent.hash;

import java.util.*;

public class Router<T extends Node> {

    private final TreeMap<Integer, VNode<T>> ring = new TreeMap<>();
    private final Hash hash = new Fnv1Hash();

    public void addNode(T node, Integer replicas) {
        VNode<T> vNode = new VNode<>(node);
        int i = 0;
        while (i < replicas) {
            int hashValue = hash.hash(vNode.hashKey());
            if (!ring.containsKey(hashValue)) {
                ring.put(hashValue, vNode);
                i++;
            } else {
                vNode = vNode.increase();
            }
        }
    }

    public void removeNode(Node node) {
        Iterator<Map.Entry<Integer, VNode<T>>> it = ring.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, VNode<T>> entry = it.next();
            if (entry.getValue().isSameOf(node)) {
                ring.remove(it);
            }
        }
    }


    public void init(List<T> nodes, int replicas) {
        assert replicas > 0 && !nodes.isEmpty();
        nodes.forEach(i -> this.addNode(i, replicas));
    }


    public T route(String routeKey) {
        assert !ring.isEmpty();
        int hashValue = hash.hash(routeKey);
        SortedMap<Integer, VNode<T>> tailMap = ring.tailMap(hashValue);
        int ringKey = !tailMap.isEmpty() ? tailMap.firstKey() : ring.firstKey();
        return ring.get(ringKey).getNode();
    }


}
