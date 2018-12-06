package com.igorwojda.datastructure.linkedlist

private object LinkedListSolution {
    private class LinkedList<E> : Iterable<Node<E>> {
        var head: Node<E>? = null
        val first: Node<E>?
            get() = head

        val size: Int
            get() {
                var count = 0
                var node = head

                while (node != null) {
                    count++
                    node = node.next
                }

                return count
            }

        var last: Node<E>? = null
            get() {
                var node = head

                while (node?.next != null) {
                    node = node.next
                }

                return node
            }

        fun insertFirst(data: E) {
            head = Node(data, head)
        }

        fun insertLast(data: E) {
            Node(data).also {
                if (head == null) {
                    head = it
                } else {
                    last?.next = it
                }
            }
        }

        fun insertAt(data: E, index: Int) {
            if (index == 0) {
                head = Node(data, head)
            } else {
                val prevNode = getAt(index - 1) ?: last
                val node = prevNode?.next
                prevNode?.next = Node(data, node)
            }
        }

        fun removeFirst() {
            head = head?.next
        }

        fun removeLast() {
            if (head?.next == null) {
                head = null
                return
            }

            var prevNode = head
            var node = head?.next

            while (node?.next != null) {
                prevNode = node
                node = node.next
            }

            prevNode?.next = null
        }

        fun getAt(index: Int): Node<E>? {
            if (head == null) {
                return null
            }

            var node = head
            var counter = 0

            while (node != null) {
                if (counter == index) {
                    return node
                }

                counter++
                node = node.next
            }

            return null
        }

        fun removeAt(index: Int) {
            if (index == 0) {
                head = head?.next
            } else {
                val prevNode = getAt(index - 1)
                val nextNode = prevNode?.next?.next
                prevNode?.next = nextNode
            }
        }

        fun clear() {
            head = null
        }

        override fun iterator() = object : Iterator<Node<E>> {
            var node = head
            override fun hasNext() = node != null

            override fun next(): Node<E> {
                val currentNode = node
                node = node?.next
                return currentNode!!
            }
        }
    }

    private data class Node<T>(
        val data: T,
        var next: Node<T>? = null
    )
}