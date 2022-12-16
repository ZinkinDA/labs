package Lab_03;

public class Lab_03 {
    public static void main(String[] args) {

        Tree tree = new Tree(19,
                        new Tree(7,
                                new Tree(4,
                                        null,
                                        new Tree(5)),
                                new Tree(9,
                                        new Tree(15,
                                                null,
                                                new Tree(17,
                                                        null,
                                                        new Tree(19))),
                                        new Tree(13))),
                        new Tree(35,
                                new Tree(31,
                                        new Tree(28),
                                        new Tree(33,
                                                new Tree(31,
                                                        null,
                                                        new Tree(37)),
                                                new Tree(35))),
                                new Tree(40,
                                        new Tree(38),
                                        new Tree(52))));

        /* Вывод длинного пути по нечетный числпм */
        System.out.println(Math.max(tree.maxLeftPath(), tree.maxRightPath()));
    }
}

/* Класс нашего дерева */
class Tree {
    /* Значение внутри узла */
    int value;
    /* Левый и правый потомок */
    Tree left,right;

    public Tree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Tree(int value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int sum(){
        int summ = value;
        if(left != null){
            summ += left.sum();
        }

        if(right != null){
            summ += right.sum();
        }

        return summ;
    }
    /** Рекурсивная функция обхода дерева **/
    public int recurseTreeList(){
        int counter = 1;

        if(value % 2 == 0){
            return 0;
        }
        if((this.left != null && this.right != null) && (this.left.value % 2 != 0 && this.right.value % 2 != 0) ){
            int maxLeft = this.left.maxLeftPath();
            int maxRight = this.right.maxRightPath();
            if(maxLeft > maxRight){
                counter = maxLeft;
            } else {
                counter = maxRight;
            }
        }
        if(this.left != null){
            counter += this.left.recurseTreeList();
        }
        if(this.right != null){
            counter += this.right.recurseTreeList();;
        }
        return counter;
    }
    /** Максимальный путь по левой ветке от корня **/
    public int maxLeftPath(){
        int counter = 1;
        int max_left_counter = 0;

        if(value % 2 == 0){
            return 0;
        }
        if(this.left != null){
            counter = this.left.recurseTreeList();
            max_left_counter = counter;
        } else if (this.right != null) {
            counter = this.right.recurseTreeList();
        }
        return max_left_counter;
    }
    /** Максимальный путь по правой ветке от корня **/
    public int maxRightPath(){
        int counter = 1;
        int max_right_counter = 0;
        if(value % 2 == 0){
            return 0;
        }
        if(this.right != null){
            counter = this.right.recurseTreeList();
            max_right_counter = counter;
        } else if (this.left != null) {
            counter = this.left.recurseTreeList();
        }
        return max_right_counter;
    }


}

