package Lab_01;

public class MyStack<T> {
    private MyNode<T> head = null;

    public MyStack() {
    }
    /** Достать первый элемент стэка без удаления. **/
    public T peek() {
        if (this.head == null) {
            throw new RuntimeException("СТЭК ПУСТ!");
        }

        return this.head.getElement();
    }
    /** Добавить элемент в стэк **/
    public void push(T data) {
        this.head = new MyNode<>(data, this.head);
    }
    /** Достать первый элемент стэка **/
    public void pop() {
        if (this.head == null) {
            throw new RuntimeException("СТЭК ПУСТ!");
        }

        this.head = this.head.getPrevious();
    }
}
/** Класс в котором содержится наш элемент.(Класс локальный - т.е доступен в рамках этого пакета.) **/
class MyNode<T> {
    private T el;
    private MyNode<T> previous;

    public MyNode(T el, MyNode<T> previous) {
        this.el = el;
        this.previous = previous;
    }

    public T getElement() {
        return el;
    }

    public MyNode<T> getPrevious() {
        return previous;
    }

}