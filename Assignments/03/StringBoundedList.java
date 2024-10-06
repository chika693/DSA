/**
 * A capacity-bounded list of String elements. Each list has a capacity, which is the maximum number of elements that the list can hold at one time. 
 * Each list also has a size, which is the number of elements currently held by the list. The elements of a list have indexes: the first element 
 * is at index 0, the second element is at index 1, and so on. Null elements are allowed.
 */
public interface StringBoundedList {
    /**
     * Returns the number maximum number of elements that this list can hold at the same time.
     * @return the capacity
     */
    int capacity();

    /**
     * Returns the number of elements currently held in this list.
     * @return the size, which is less than or equal to the capacity
     */
    int size();

    /**
     * Adds the specified element to the end of this list, if the list isn't already full. 
     * For example, if {@code list} is a StringBoundedList with capacity 10 that represents {@code [a, b, c]}, 
     * then saying {@code list.add("d")} makes {@code list} represent {@code [a, b, c, d]}.
     * @param s the String to add
     * @throws IllegalStateException if this list is already full
     */
    void add(String s);

    /**
     * Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any)
     *      subsequent elements to the right by one position.
     * For example, if list has a capacity of 10 and represents [a, b, c, d], then saying list.add(2, "x") should make list represent
     *      [a, b, x, c,d].
     * The method should throw an IllegalStateException if the array is already full.
     * Also, it should throw an IndexOutofBoundsException if the provided index is negative, or if it is greater than the size. Note
     * that it is possible to add an element at index size, as long as the list isn't full.
     * @param index the position of the desired element.
     * @param s the String to add
     * @throws IllegalStateException if this list is already full
     * @throws IndexOutOfBoundsException if the index is negative or if it is greater than the size.
     */
    void add(int index String s);

    /**
     * Removes the element at the specified position in this list. Shifts all subsequent elements to the left by one position to fill in
     *      the gap. Reteruns the element that was removed.
     * For example, if list represents [a, b, c, d], then saying list.remove(1) should make list represent [a, c, d].
     * The method should throw an IndexOutOfBoundsException if the provided index is negative, or if it is greater than or equal to the
     *      size.
     * @param index the position of the element to remove.
     * @return the element that was removed.
     * @throws IndexOutOfBoundsException if provided index is negative, or if it is greater than or equal to size.
     */
    String remove(int index);

    /**
     * Removes the first occurrence of the specified String from the list. Shifts all subsequent elements to the left by one position to
     *      fill in the gap.
     * Returns true if an element was removed, false otherwise.
     */
    boolean remove(String s); 

    /**
     * Returns the element at the specified index in this list.
     * @param index the position of the desired element.
     * @return the element (possibly null) at the specified position
     * @throws IndexOutOfBoundsException if index is negative, or greater than or equal to the size
     */
    String get(int index);

    /**
     * Replaces the old element at the specified index with the new element, and returns the old element.
     * @param index the index where an element should be replaced
     * @param element the new element
     * @return the old element
     * @throws IndexOutOfBoundsException if index is negative, or greater than or equal to the size
     */
    String set(int index, String element);

    /**
     * Return the index of the first occurrence of the specified String in this list, or -1 if it doesn't occur in this list.
     * @param s the String to search for (possibly null)
     * @return the index of the first occurrence of s, or -1 if not found
     */
    int indexOf(String s);

    /**
     * Return the index of the last occurrence of the specified String in this list, or -1 if it doesn't occur in this list.
     * @param s the String to search for (possibly null)
     * @return the index of the last occurrence of s, or -1 if not found
     */
    int lastIndexOf(String s);

    /**
     * Makes the list empty.
     */
    void clear();



    // Start of default methods.
    /**
     * Returns true if this list is empty, false otherwise.
     */
    default boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this list is full, that is, if the size is equal to the capacity.
     */
    default boolean isFull() {
        return size() == capacity();
    }

    /**
     * Returns the first element of this list. Throws an IndexOutOfBoundException if this list is empty.
     */
    default String getFirst() {
        return get(0);
    }

    /**
     * Returns the last element of this list. Throws an IndexOutOfBoundException if this list is empty.
     */
    default String getLast() {
        return get(size() - 1);
    }

    /**
     * Replaces the first element of this list with the specified element. Throws an IndexOutOfBoundsException if this list is empty.
     */
    default String setFirst(String element) {
        return set(0, element);
    }

    /**
     * Replaces the last element of this list with the specified element. Throws an IndexOutOfBoundsException if this list is empty
     */
    default String setLast(String element) {
        return set(size() - 1, element);
    }

    /**
     * Determines whether this list contains the specified String (possible null).
     * @param s the String we are searching for.
     * @return the index of the String, and -1 if otherwise.
     */
    default boolean contains(String s) {
        return indexOf(s) >= 0;
    }
}
