package jzl.com.crackcodeinterview.P;

import java.util.HashMap;

/**
 * jzl.com.crackcodeinterview.P
 * Created by kingj on 2020/6/29 0029.
 * 16. 25 　 LRU 缓存。 设计 和 构建 一个“ 最近 最少 使用” 缓存， 该 缓存 会 删除 最近 最少 使用 的 项目。 缓存 应该 从 键 映 射到 值（ 允许 插入 和 检索 特定 键 对应 的 值）， 并在 初始化 时 指定 最大 容量。 当 缓存 被
 * 填满 时， 它 应该 删除 最近 最少 使用 的 项目。
 */
public class P25 {

    private int maxCacheSize;
    private HashMap<Integer, LinkedListNode> map = new HashMap<>();
    private LinkedListNode listHead = null;
    public LinkedListNode listTail = null;

    public P25(int maxSize) {
        maxCacheSize = maxSize;
    }

    public String getValue(int key) {
        LinkedListNode item = map.get(key);
        if (item == null) {
            return null;
        }
        if (item != listHead) {
            removeFromLinkedList(item);
            insertAtFrontOfLinkedList(item);
        }
        return item.value;
    }

    private void removeFromLinkedList(LinkedListNode node) {
        if (node == null) {
            return;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node == listTail) {
            listTail = node.prev;
        }
        if (node == listHead) {
            listHead = node.next;
        }
    }

    private void insertAtFrontOfLinkedList(LinkedListNode node) {
        if (listHead == null) {
            listHead = node;
            listTail = node;
        } else {
            listHead.prev = node;
            node.next = listHead;
            listHead = node;
        }
    }

    public boolean removeKey(int key) {
        LinkedListNode node = map.get(key);
        removeFromLinkedList(node);
        map.remove(key);
        return true;
    }

    public void setKeyValue(int key, String value) {
        removeKey(key);
        if (map.size() >= maxCacheSize && listTail != null) {
            removeKey(listTail.key);
        }
        LinkedListNode node = new LinkedListNode(key, value);
        insertAtFrontOfLinkedList(node);
        map.put(key, node);
    }

    private static class LinkedListNode {
        private LinkedListNode next, prev;
        public int key;
        public String value;

        public LinkedListNode(int k, String v) {
            key = k;
            value = v;
        }
    }
}
