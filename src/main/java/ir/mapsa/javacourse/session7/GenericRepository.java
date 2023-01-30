package ir.mapsa.javacourse.session7;


import java.util.Objects;

public class GenericRepository<T> {
    private Object[] elements;
    private int emptyIndex = 0;

    public GenericRepository() {
        this.elements = new BaseClass[100];
    }


    public GenericRepository(GenericRepository<T> repo) {
        this.elements = repo.elements;
    }

    public GenericRepository(int size) {
        this.elements = new BaseClass[size];
    }

    public void add(T[] elements) {

    }

    private synchronized void extendArray() {

    }

    public synchronized void add(T element) {

        if (emptyIndex >= elements.length) {
            extendArray();
        }
        elements[emptyIndex++] = element;

    }

    public T get(int index) throws InvalidIndexException, ArrayIndexOutOfBoundsException, Exception {
        if (isIndexInvalid(index)) {
            throw new InvalidIndexException("invalid index " + index);
        }
        return (T) elements[index];
    }

//    public T getById(Long id) {
//        for (int i = 0; i < this.elements.length; i++) {
//            if (elements[i] != null && elements[i].getId().equals(id)) {
//                return (T)elements[i];
//            }
//        }
//        return null;
//    }

    private boolean isIndexInvalid(int index) {
        return index < 0 || index >= elements.length;
    }

    public int findFirst(T element) {
        if (element == null) {
            return -1;
        }
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null && elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public void remove(int index) {
        if (isIndexInvalid(index)) {
            return;
        }
        elements[index] = null;
        shiftArray();
    }

    private void shiftArray() {
        Object[] objects = new Object[this.elements.length];
        int objectsIndex = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                objects[objectsIndex++] = elements[i];
            }
        }
        this.elements = objects;
    }

    public void remove(T element) {
        int i = findFirst(element);
        if (i == -1) {
            return;
        }
        remove(i);
    }

    public void removeAll(T element) {
        // same as remove(T element)
    }

    public void clear() {

    }

    public void update(int index, T element) {
        if (isIndexInvalid(index)) {
            return;
        }
        elements[index] = element;
    }

//    public GenericRepository<T> subElements(int from, int to) {
//        if (from < 0 || from > to || to >= elements.length) {
//            return null;
//        }
//        Object[] subElements = new Object[to - from + 1];
//        int index = 0;
//        for (int i = from; i <= to; i++) {
//            subElements[index++] = elements[i];
//        }
//
//        return (T[]) subElements;
//    }

    public void printAll() {
        for (int i = 0; i < elements.length; i++) {
            System.out.println(elements[i]);
        }
    }

    //public static <E extends BaseClass> void copyGenericRepository(GenericRepository<E> a,GenericRepository<E> b){
//
//}
//    public static <E extends BaseClass> E getItemAt(GenericRepository<E> a,int index){
//
//    }
//    public static <E extends BaseClass> E findItem(GenericRepository<E> a,E item){
//
//    }
//
//    public static  void remove(List<? extends BaseClass> a, int index){
//
//    }
    public static void main(String[] args) throws Exception {
        GenericRepository<String> g = new GenericRepository<>();
        try {
            g.get(-1);
        } catch (Exception  e) {
            throw new RuntimeException(e);
        }
    }
}


class StudentRepository extends GenericRepository<Student> {
//    public static void main(String[] args) {
//        StudentRepository studentRepository = new StudentRepository();
//        GenericRepository<Teacher> teacherGenericRepository = new GenericRepository<>();
//        Student itemAt = GenericRepository.getItemAt(studentRepository, 9);
//        Teacher itemAt1 = GenericRepository.getItemAt(teacherGenericRepository, 9);
//        GenericRepository.findItem(studentRepository, new Student());
//        ArrayList<String> strings = new ArrayList<>();
//        LinkedList<String> strings1 = new LinkedList<>();
//        HashMap<String, Student> hashMap = new HashMap<>();
//        Student value = new Student();
//        value.setName("Ali");
//        value.setId(1L);
//        hashMap.put("ali", value);
//        Student ali = hashMap.get("ali");
//
//    }
}

class Student extends BaseClass {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return Objects.hash(this.name, this.getId());
    }
}

class Teacher extends BaseClass {

}


abstract class BaseAbstractClass {
    public abstract int getVersion();

    public void payment() {
        String url = "https://m.asanpardakht.com/inquiry/v" + getVersion() + "/";
    }
}

@FunctionalInterface
interface BaseInterface {
    int getVersion();

    default void payment() {
        String url = "https://m.asanpardakht.com/inquiry/v" + getVersion() + "/";
    }
}

class ShahrdariPayment extends BaseAbstractClass {
    @Override
    public int getVersion() {

        return 2;
    }

    public static void main(String[] args) {
        ShahrdariPayment sh = new ShahrdariPayment();
        sh.payment();
    }
}


abstract class Shape {
    public abstract int area();

    public abstract int surface();
}

class Circle extends Shape {
    @Override
    public int area() {
        return 0;
    }

    @Override
    public int surface() {
        return 0;
    }
}

interface GeneralShape {
    int area();

    int surface();
}


class Triangle implements GeneralShape {
    @Override
    public int area() {
        return 0;
    }

    @Override
    public int surface() {
        return 0;
    }
}