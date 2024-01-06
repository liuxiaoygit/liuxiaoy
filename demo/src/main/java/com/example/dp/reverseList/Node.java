package com.example.dp.reverseList;

import lombok.Data;

public
@Data class Node {
    int val;
    Node next = null;

    public Node(int val) {
        this.val = val;
    }


}