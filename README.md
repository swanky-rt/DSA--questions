# DSA — Questions, Brainstorming & Solutions in Java

> A growing collection of Data Structures & Algorithms problems solved in Java — each tackled with both **brute-force** and **optimized/efficient** approaches to build deep intuition for problem solving.

---

## Table of Contents

- [Overview](#overview)
- [Repository Structure](#repository-structure)
- [Topics Covered](#topics-covered)
- [Approach Philosophy](#approach-philosophy)
- [File Reference](#file-reference)
- [How to Run](#how-to-run)
- [Sample Code](#sample-code)

---

## Overview

This repository is a personal DSA workspace — a place to brainstorm, experiment, and sharpen algorithmic thinking. Problems span classic data structure implementations, coding interview questions, company-specific problems, and general algorithmic challenges.

Every problem is approached in two ways where applicable:

| Approach | Goal |
|----------|------|
| **Brute Force** | Understand the problem — correctness first, no constraints on time/space |
| **Optimized / Efficient** | Improve time/space complexity using better data structures or algorithms |

**Language:** Java  
**Style:** Single-file implementations, each focused on one concept or problem set

---

## Repository Structure

```
DSA--questions/
│
├── src/
│   │
│   ├── Book/                          # OOP-based Book management (Controller/Pojo/Service pattern)
│   │   ├── BookController.java
│   │   ├── BookPojo.java
│   │   └── BookService.java
│   │
│   └── Sortings/                      # Sorting algorithm implementations
│
├── ArrayQues.java                     # Array problems & solutions
├── Card.java                          # Card object (used in deck/game problems)
├── Deck.java                          # Deck of cards — shuffling & operations
├── FizzBuzz.java                      # FizzBuzz — classic interview warmup
├── Graph.java                         # Graph representation & traversal
├── HashMapImpl.java                   # HashMap problems & custom implementation
├── LL.java                            # Linked List problems
├── LList.java                         # Linked List — custom implementation (add/remove/traverse)
├── LRU.java                           # LRU Cache implementation
├── LinkedListImpl.java                # Extended Linked List operations
├── LutronsSpecificQuestions.java      # Company-specific interview questions (Lutrons)
├── MW.java                            # Moving Window / Sliding Window problems
├── MW1.java                           # Sliding Window — variant problems
├── Main.java                          # Entry point / scratch pad
├── MainDeck.java                      # Deck driver / testing
├── Matrix.java                        # Matrix traversal & manipulation problems
├── MiscellaneousQues.java             # Mixed bag of interview questions
├── PracticeQues.java                  # General practice problems
├── Rank.java                          # Ranking / sorting-based problems
├── Searching.java                     # Searching algorithms (binary search, linear search)
├── StringQues.java                    # String manipulation & pattern problems
├── Suit.java                          # Suit enum (used with Card/Deck)
├── Test.java                          # Test cases & experimental code
├── TextEditor.java                    # Text editor simulation (stack-based undo/redo)
├── TreeQues.java                      # Binary tree & BST problems
├── practice_dell.java                 # Company-specific practice (Dell)
├── setWithHashMap.java                # Set implementation using HashMap
├── solveInterestingQuestions.java     # Curated challenging problems
├── test_practice_dell.java            # Test cases for Dell practice problems
└── README.md
```

---

## Topics Covered

### Arrays
- Traversal, rotation, subarray problems
- Two-pointer technique
- Prefix sums
- Brute force O(n²) vs optimized O(n) solutions

### Linked Lists
- Custom singly linked list (add, remove, traverse)
- Fast & slow pointer (Floyd's cycle detection)
- Reversal, merge, intersection problems
- LRU Cache using doubly linked list + HashMap

### Strings
- Pattern matching
- Anagram, palindrome checks
- Sliding window on strings
- StringBuilder manipulation

### Sliding Window / Moving Window
- Fixed and variable window problems
- Maximum subarray, longest substring variants
- Two dedicated files (`MW.java`, `MW1.java`) for window technique problems

### Searching
- Linear search
- Binary search and variants
- Search in rotated/sorted arrays

### Trees
- Binary tree traversal (inorder, preorder, postorder)
- Binary Search Tree (BST) operations
- Height, diameter, path sum problems

### Graph
- Graph representation (adjacency list/matrix)
- BFS and DFS traversal
- Connected components

### HashMap & HashSet
- Custom HashMap implementation
- Frequency counting problems
- Set operations using HashMap

### Sorting
- Classic sorting algorithms in `Sortings/`
- Ranking problems (`Rank.java`)

### Matrix
- 2D array traversal patterns
- Spiral, diagonal, rotation problems

### Miscellaneous / Interview Prep
- FizzBuzz
- Text editor stack simulation
- Company-specific question sets (Lutrons, Dell)
- LRU Cache
- Card & Deck OOP design

---

## Approach Philosophy

Every non-trivial problem in this repo is solved in two passes:

```
Problem
  ├── Brute Force Solution
  │     ├── Time:  Usually O(n²) or O(n³)
  │     ├── Space: O(1) or O(n)
  │     └── Goal:  Get the correct answer first
  │
  └── Optimized Solution
        ├── Time:  O(n) or O(n log n)
        ├── Space: O(n) with better data structures
        └── Goal:  Reduce time/space complexity
```

Comments inside each file explain the reasoning, trade-offs, and complexity analysis for both approaches.

---

## File Reference

| File | Topic | Key Concepts |
|------|-------|--------------|
| `ArrayQues.java` | Arrays | Two pointer, prefix sum, subarrays |
| `LList.java` | Linked List | Add, remove, traverse from scratch |
| `LL.java` | Linked List | Interview problems |
| `LinkedListImpl.java` | Linked List | Extended operations |
| `LRU.java` | Cache | Doubly linked list + HashMap |
| `MW.java` / `MW1.java` | Sliding Window | Fixed & variable window problems |
| `StringQues.java` | Strings | Palindrome, anagram, patterns |
| `Searching.java` | Searching | Binary search, variants |
| `TreeQues.java` | Trees | BST, traversals, height |
| `Graph.java` | Graphs | BFS, DFS, adjacency list |
| `Matrix.java` | 2D Arrays | Spiral, rotation, traversal |
| `HashMapImpl.java` | HashMap | Custom impl, frequency problems |
| `setWithHashMap.java` | HashSet | Set ops using HashMap |
| `TextEditor.java` | Stack | Undo/redo simulation |
| `LutronsSpecificQuestions.java` | Interview | Lutrons company questions |
| `practice_dell.java` | Interview | Dell company questions |
| `solveInterestingQuestions.java` | Mixed | Curated challenging problems |
| `MiscellaneousQues.java` | Mixed | General interview questions |
| `FizzBuzz.java` | Classic | FizzBuzz with variations |
| `Rank.java` | Sorting | Rank-based problems |
| `Card.java` / `Deck.java` / `Suit.java` | OOP Design | Deck of cards design problem |
| `Book/` | OOP Design | MVC-style Book management |

---

## How to Run

**Requirements:** Java 8+

**Compile and run any file:**
```bash
# Compile
javac LList.java

# Run
java LList
```

**For files with dependencies (e.g., Card + Deck + Suit):**
```bash
javac Suit.java Card.java Deck.java MainDeck.java
java MainDeck
```

**Using an IDE:** Simply import the project into IntelliJ IDEA or Eclipse and run any `main()` method directly.

---

## Sample Code

### Linked List — From Scratch (`LList.java`)

```java
public class LList {
    Node head;

    static class Node {
        private int data;
        private Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // Add node to end — O(n)
    public LList addNode(LList node, int data) {
        Node newNode = new Node(data);
        if (node.head == null) {
            node.head = newNode;
        } else {
            Node last = head;
            while (last.next != null) last = last.next;
            last.next = newNode;
        }
        return node;
    }

    // Remove node by value — O(n)
    public LList removeNode(LList node, int data) { ... }

    // Traverse and print — O(n)
    public void traverseLinkedList(LList node) { ... }
}
```

---

## Author

**swanky-rt** — [github.com/swanky-rt](https://github.com/swanky-rt)

> *"Solving every problem the hard way first, then the smart way."*
