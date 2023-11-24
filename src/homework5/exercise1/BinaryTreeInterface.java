package homework5.exercise1;

public interface BinaryTreeInterface<T> {
    T root();

    int size(); // number of node in tree

    boolean isEmpty();

    int numChildren(T p); // nmber of children of element p;

    T parent(T p); // Return parent of p

    T left(T p); // Return left child of p

    T right(T p); // return right child of p

    T sibling(T p); // return sibling of p
    void setData(Object data);

    boolean addDataToFile();
}