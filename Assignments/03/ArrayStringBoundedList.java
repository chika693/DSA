import java.util.Objects;


public class ArrayStringBoundedList implements StringBoundedList {
    private String[] arr;
    private int size = 0;

    public ArrayStringBoundedList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        } else {
            arr = new String[capacity];
        }
    }

    @Override 
    public String toString() {
        String str = "";
        str += "[";
        for (int i = 0; i < size(); i++) {
            if (i == size() -1) {
                str += arr[i];
            } else {
                str += arr[i] + ", ";
            }
        }
        str += "]";

        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ArrayStringBoundedList) {
            ArrayStringBoundedList other = (ArrayStringBoundedList) o;
            for (int i = 0; i < size(); i++) {
                if (this.arr[i] != other.arr[i]) {
                    return false;
                }
            } 
            return this.size() == other.size();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(arr, size);
    }

    @Override
    public int capacity() {
        return this.arr.length;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void add(String s) {
        if (!isFull()) {
            arr[size] = s;
            ++size;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public void add(int index, String s) {
        if (index < 0 || index > size() || index >= capacity()) {
            throw new IndexOutOfBoundsException();
        } else if (isFull()) {
            throw new IllegalStateException();
        } else {
            ++size;
            String outerTemp = arr[index];
            arr[index] = s;
            for (int i = index + 1; i < size(); i++) {
                String innerTemp = arr[i];
                arr[i] = outerTemp;
                outerTemp = innerTemp;
            }
        }
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            String removed = arr[index];
            for (int i = index; i < size() - 1; i++) {
                arr[i] = arr[i + 1];
            }
            size--;
            return removed;
        }
    }

    @Override 
    public boolean remove(String s) {
        if (!contains(s)) {
            return false;
         } else {
            int removalIndex = indexOf(s);
            for (int i = removalIndex; i < size() - 1; i++) {
                arr[i] = arr[i + 1];
            }
            size--;
            return true;
        }
    }

    /**
     * Returns the element at the specified index in this list.
     * @param index the position of the desired element.
     * @return the element (possibly null) at the specified position
     * @throws IndexOutOfBoundsException if index is negative, or greater than or equal to the size
     */
    @Override
    public String get(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            return arr[index];
        }
    }

    /**
     * Replaces the old element at the specified index with the new element, and returns the old element.
     * @param index the index where an element should be replaced
     * @param element the new element
     * @return the old element
     * @throws IndexOutOfBoundsException if index is negative, or greater than or equal to the size
     */
    @Override
    public String set(int index, String element) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            String oldElement = arr[index];
            arr[index] = element;
            return oldElement;
        }
    }

    /**
     * Return the index of the first occurrence of the specified String in this list, or -1 if it doesn't occur in this list.
     * @param s the String to search for (possibly null)
     * @return the index of the first occurrence of s, or -1 if not found
     */
    @Override
    public int indexOf(String s) {
        for (int i = 0; i < size(); i++) {
            if (Objects.equals(arr[i], s)) {
                return i;
            } else {
                continue;
            }
        }
        return -1;
    }

    /**
     * Return the index of the last occurrence of the specified String in this list, or -1 if it doesn't occur in this list.
     * @param s the String to search for (possibly null)
     * @return the index of the last occurrence of s, or -1 if not found
     */
    @Override
    public int lastIndexOf(String s) {
        for (int i = size() - 1; i >= 0; i--) {
            if (Objects.equals(arr[i], s)) {
                return i;
            } else {
                continue;
            }
        }
        return -1;
    }

    /**
     * Makes the list empty.
     */
    @Override
    public void clear() {
        size = 0;
    }
}
