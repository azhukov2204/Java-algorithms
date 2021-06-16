package homework6;

public class Tree {
    private Node root; // Это наш корневой узел. Он должен существовать обязательно.

    // Этот метод реализует вставку нового элемента
    public void insert(PersonWithId person) {
        Node node = new Node();
        node.setPerson(person);
        // Если дерево нулевое, то мы к корневому элементу присвоим наш node
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent; // Переменная для определения нашего родителя
            while (true) {
                parent = current;
                if (person.getId() < current.getPerson().getId()) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parent.setLeftChild(node);
                        return;
                    }
                } else {
                    current = current.getRightChild();
                    if (current == null) {
                        parent.setRightChild(node);
                        return;
                    }
                }
            }
        }
    }

    // Этот метод будет искать определённый узел в дереве
    public Node find(int key) {
        Node current = root; // current - это переменная текущего нашего узла, на котором мы в настоящий момент находимся
        while (current.getPerson().getId() != key) {
            if (key < current.getPerson().getId()) {
                current = current.getLeftChild(); // Здесь мы переходим на левого потомка
            } else {
                current = current.getRightChild(); // Здесь мы переходим на правого потомка
            }
            if (current == null) // Если данное условие выполняется, то мы дошли до элемента с пустым листом, а этом значит, что нашего элемента в дереве нет
            {
                return null;
            }
        }
        return current;
    }

    // Реализация нашего симметричного обхода дерева
    private void inOrder(Node rootNode) {
        if (rootNode != null) {
            inOrder(rootNode.getLeftChild());
            rootNode.display();
            inOrder(rootNode.getRightChild());
        }
    }

    private void preOrder(Node rootNode) // Прямой обход дерева
    {
        if (rootNode != null) {
            rootNode.display();
            preOrder(rootNode.getLeftChild());
            preOrder(rootNode.getRightChild());
        }
    }

    private void postOrder(Node rootNode) // Обратный обход дерева
    {
        if (rootNode != null) {
            postOrder(rootNode.getLeftChild());
            postOrder(rootNode.getRightChild());
            rootNode.display();
        }
    }

    public void displayTree() {
        // Этот метод выводит всё дерево. Здесь будут реализованы 3 метода. Поскольку, чтобы вывести дерево нам нужно его обойти полностью. Все 3 метода будут иметь в консоли разный вывод.
        Node current = root;
        System.out.println("Симметричный");
        inOrder(root);
        System.out.println("Прямой");
        preOrder(root);
        System.out.println("Обратный");
        postOrder(current);
    }

    public Node min() {
        Node current, last = null; // current - это тот узел, в котором мы находимся на данный момент; last - это искомый минимум
        current = root;
        while (current != null) {
            last = current;
            current = current.getLeftChild();
        }
        return last;
    }

    public Node max() // current - это тот узел, в котором мы находимся на данный момент; last - это искомый максимум
    {
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.getRightChild();
        }
        return last;
    }


    public boolean delete(int id) // Удаление нашего элемента по его уникальному id
    {
        Node current = root; // Узел, на котором мы находимся сейчас
        Node parent = root; // Родительский узел

        boolean isLeftChild = true; // Нужна для определения какой потомок мы удаляем (левый - true или нет - false)

        while (current.getPerson().getId() != id) // Поиск нашего удаляемого узла
        {
            parent = current;
            if (id < current.getPerson().getId()) {
                isLeftChild = true;
                current = current.getLeftChild();
            } else {
                isLeftChild = false;
                current = current.getRightChild();
            }
            if (current == null) {
                return false;
            }
        }

        if (current.getLeftChild() == null && current.getRightChild() == null) { // Случай, когда нет потомков
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        } else if (current.getRightChild() == null) { // Есть только левый потомок
            if (current == root) {
                root = current.getLeftChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
        } else if (current.getLeftChild() == null) { // Есть только правый потомок
            if (current == root) {
                root = current.getRightChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }
            successor.setLeftChild(current.getLeftChild());
        }
        return true;
    }

    // Возвращает узел, являющийся преемником. Данный метод необходимо, чтобы искать наш узел в правом поддереве. С его помощью мы будем искать необходимый узел для замены и поиска преемника для нашего удаляемого узла.
    public Node getSuccessor(Node currentNode) {
        Node successorParent = currentNode; // Родитель нашего узла
        Node successor = currentNode;      // Текущий узел
        Node current = currentNode.getRightChild(); // Правый потомок нашего исходного узла

        // Далее идет поиск в правом поддереве
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if (successor != currentNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(currentNode.getRightChild());
        }

        return successor;
    }
}
