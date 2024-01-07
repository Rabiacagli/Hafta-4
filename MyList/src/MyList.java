import java.util.Arrays;
import java.util.Objects;

public class MyList<T> {
    // Dizi ve eleman sayısını tutacak değişkenler
    private Object[] array;
    private int size;

    // Varsayılan kapasite değeri
    private static final int DEFAULT_CAPACITY = 10;

    // Boş constructor: Dizi başlangıç boyutu 10 olarak ayarlanır
    public MyList() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // Parametre ile kapasite belirleyen constructor
    public MyList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Kapasite sıfırdan büyük olmalıdır");
        }
        this.array = new Object[capacity];
        this.size = 0;
    }

    // Dizideki eleman sayısını döndüren metot
    public int size() {
        return size;
    }

    // Dizinin kapasite değerini döndüren metot
    public int getCapacity() {
        return array.length;
    }

    // Eleman ekleme metodu
    public void add(T data) {
        if (size == array.length) {
            // Eğer dizi dolu ise kapasitesini 2 katına çıkaran metot çağrılır
            increaseCapacity();
        }
        array[size++] = data;
    }

    // Dizinin kapasitesini 2 katına çıkaran özel metot
    private void increaseCapacity() {
        int newCapacity = array.length * 2;
        array = Arrays.copyOf(array, newCapacity);
    }

    // Verilen indexteki elemanı döndüren metot
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return (T) array[index];
    }

    // Verilen indexteki elemanı silen metot
    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
    }

    // Verilen indexteki elemanı yeni bir değer ile değiştiren metot
    public void set(int index, T data) {
        if (index < 0 || index >= size) {
            return;
        }
        array[index] = data;
    }

    // Diziyi string olarak temsil eden metot
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(array[i]);
            if (i < size - 1) {
                result.append(",");
            }
        }
        result.append("]");
        return result.toString();
    }

    // Verilen elemanın ilk bulunduğu indeksi döndüren metot
    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(data, array[i])) {
                return i;
            }
        }
        return -1;
    }

    // Verilen elemanın son bulunduğu indeksi döndüren metot
    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(data, array[i])) {
                return i;
            }
        }
        return -1;
    }

    // Liste boş mu değil mi kontrol eden metot
    public boolean isEmpty() {
        return size == 0;
    }

    // Diziyi Object[] olarak döndüren metot
    public T[] toArray() {
        return Arrays.copyOf(array, size, (Class<? extends T[]>) array.getClass());
    }

    // Listeden belirli bir aralıktaki elemanları içeren alt bir liste döndüren metot
    public MyList<T> sublist(int start, int finish) {
        if (start < 0 || finish >= size || start > finish) {
            throw new IndexOutOfBoundsException("Geçersiz indeks aralığı");
        }
        MyList<T> subList = new MyList<>(finish - start + 1);
        System.arraycopy(array, start, subList.array, 0, finish - start + 1);
        subList.size = finish - start + 1;
        return subList;
    }

    // Verilen elemanın listede olup olmadığını kontrol eden metot
    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    // Diziyi temizleyen (boşaltan) metot
    public void clear() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}