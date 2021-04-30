package com.superkit.consistent.hash;

/**
 * 节点
 */
public class VNode <T extends Node> implements Node {
    /**
     * 真实节点
     */
    private final T node;

    /**
     * hash环分布使用的随机数
     */
    private int index = 0;

    public VNode(T node) {
        this.node = node;
    }

    public VNode(T node, int index) {
        this.node = node;
        this.index = index;
    }

    @Override
    public String hashKey() {
        return node.hashKey() + "-" + index;
    }

    public boolean isSameOf(Node node) {
        return this.node.hashKey().equals(node.hashKey());
    }


    public VNode<T> increase() {
        return new VNode<>(this.node, ++(this.index));
    }

    public T getNode() {
        return this.node;
    }

}
