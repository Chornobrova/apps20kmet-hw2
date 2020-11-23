package ua.edu.ucu.collections.immutable;

public class ImmutableArrayList implements ImmutableList {
    private final Object[] data;
    private final int size;

    public ImmutableArrayList(Object[] objs) {
        data = objs.clone();
        size = objs.length;
    }

    public ImmutableArrayList() {
        data = new Object[0];
        size = 0;
    }

    public ImmutableArrayList add(Object e) {
        return add(size, e);
    }

    public ImmutableArrayList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }
    public ImmutableArrayList addAll(Object[] c) {
        return addAll(size, c);
    }

    public ImmutableArrayList addAll(int index, Object[] c)
            throws IndexOutOfBoundsException {

        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Object[] array = new Object[c.length + size];
        System.arraycopy(data, 0, array, 0, index);
        System.arraycopy(c, 0, array, index, c.length);

        System.arraycopy(
                data,
                index,
                array,
                index + c.length,
                size - index);

        return new ImmutableArrayList(array);

    }

    public Object get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    public ImmutableArrayList remove(int index) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] array = new Object[size - 1];
        System.arraycopy(data, 0, array, 0, index);

        System.arraycopy(
                data,
                index + 1,
                array, index,
                size - 1 - index);
        return new ImmutableArrayList(array);

    }

    public ImmutableArrayList set(int index, Object e) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Object[] array = data.clone();
        array[index] = e;
        return new ImmutableArrayList(array);
    }

    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object[] toArray() {
        return data.clone();
    }

    @Override
    public String toString() {
        StringBuilder arrayString = new StringBuilder();
        arrayString.append("[");

        for (Object obj: data) {
            arrayString.append(obj);
            arrayString.append(", ");
        }
        if (size >= 1) {
            arrayString.delete(
                    arrayString.length() - 2,
                    arrayString.length());
        }
        arrayString.append("]");
        return arrayString.toString();
    }

}
