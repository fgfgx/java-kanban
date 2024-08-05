package service;

import model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;


public class InMemoryHistoryManager implements HistoryManager {
    private final Map<Integer, Node> requestHistory = new HashMap<>();
    private Node head;
    private Node tail;

    @Override
    public void add(Task task) {
        if (requestHistory.containsKey(task.getId())) {
            remove(task.getId());
        }
        linkLast(task);
    }
    private void linkLast(Task task) {
        Node newNode = new Node(null, task, tail);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
        requestHistory.put(task.getId(), newNode);
    }

    @Override
    public void remove(int id) {
        Node node = requestHistory.remove(id);
        if (node != null) {
            removeNode(node);
        }
    }

    @Override
    public List<Task> getHistory() {
        List<Task> history = new ArrayList<>();
        Node node = head;
        while (node != null) {
            history.add(node.getTask());
            node = node.getNext();
        }
        return history;
    }

    private Node newNode(Task task) {
        final Node node = new Node(tail, task, null);
        if (tail == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        return node;
    }

    private void removeNode(Node node) {
        if (node == null) {
            return;
        } else {
            Node prev = node.getPrev();
            Node next = node.getNext();

            if (node == head) {
                head = next;
            }

            if (node == tail) {
                tail = prev;
            }

            if (prev != null) {
                prev.setNext(node.getNext());
            }

            if (next != null) {
                next.setPrev(node.getPrev());
            }
        }
    }

    private static class Node {
        public Task task;
        public Node next;
        public Node prev;

        public Node(Node prev, Task task, Node next) {
            this.prev = prev;
            this.task = task;
            this.next = next;
        }

        public Task getTask() {
            return task;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(task, node.task);
        }

        @Override
        public int hashCode() {
            return Objects.hash(task);
        }
    }
}