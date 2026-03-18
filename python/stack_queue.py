from collections import deque


class Stack:
    def __init__(self):
        self._data = []

    def push(self, value):
        self._data.append(value)

    def pop(self):
        if self.is_empty():
            raise IndexError("stack is empty")
        return self._data.pop()

    def peek(self):
        if self.is_empty():
            raise IndexError("stack is empty")
        return self._data[-1]

    def size(self):
        return len(self._data)

    def is_empty(self):
        return len(self._data) == 0


class Queue:
    def __init__(self):
        self._data = deque()

    def offer(self, value):
        self._data.append(value)

    def poll(self):
        if self.is_empty():
            raise IndexError("queue is empty")
        return self._data.popleft()

    def peek(self):
        if self.is_empty():
            raise IndexError("queue is empty")
        return self._data[0]

    def size(self):
        return len(self._data)

    def is_empty(self):
        return len(self._data) == 0
