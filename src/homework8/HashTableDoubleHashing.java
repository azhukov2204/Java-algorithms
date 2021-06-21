package homework8;

public class HashTableDoubleHashing {
    private final Item[] hashArr; // Это сама хеш-таблица
    private final int arrSize; // Размер нашего массива
    private final Item nonItem; // Обозначение: элемента не существует. Т.е. замена существующего элемента в массиве на данный элемент, что эквивалентно удалению элемента из массива

    public HashTableDoubleHashing(int size) {
        this.arrSize = size;          // Задаём размер нашей хеш-таблицы
        hashArr = new Item[arrSize];  // Создаём саму хеш-таблицу нужного размера
        nonItem = new Item(-1);       // Создаём элемент, которого нет, чтобы его вставлять в хеш-таблицу на место удаляемого элемента
    }

    public void display() {
        for (int i = 0; i < arrSize; i++) {
            if (hashArr[i] != null) {
                System.out.println(hashArr[i].getData());
            } else {
                System.out.println("***");
            }
        }
    }

    public int hashFunc(int data) { // Первая хеш-функция
        return data % arrSize; // Масштабирует хеш по размеру нашего массива arrSize
    }

    public int hashFuncDouble(int key) { // Вторая хеш-функция
        int step = arrSize - key % arrSize;
        if ((arrSize - step) % 2 == 0) { //без этой логики открытая адресация нормально работать не будет, т.к. обход каждый раз будет проходить по одним и тем же ячейкам
            step++;
        }
        return step;
    }

    public void insert(Item item) {
        int data = item.getData();
        int hashKey = hashFunc(data);
        int stepSize = hashFuncDouble(data); // Переменная stepSize выячисляется с помощью двойной хеш-функции.
        int cnt = 0;
        while (hashArr[hashKey] != null && hashArr[hashKey].getData() != -1) {
            hashKey += stepSize; // Изменение смещения по нашей хеш-таблице. Это смещение отличное от линейного пробирования
            hashKey %= arrSize;
            if ((++cnt) == arrSize) { //если просмотрели весь массив
                System.out.printf("Вставка элемента %d невозможна, массив слишком мал\n", item.getData());
                return;
            }
        }
        hashArr[hashKey] = item;
    }

    public Item delete(int data) {
        int hashKey = hashFunc(data);
        int stepSize = hashFuncDouble(data); // Вычисляем смещение с помощью второй хеш-функции
        int cnt = 0;
        while (hashArr[hashKey] != null) {
            if (hashArr[hashKey].getData() == data) {
                Item temp = hashArr[hashKey];
                hashArr[hashKey] = nonItem;
                return temp; // Возвращаем удалённый элемент
            }
            hashKey += stepSize;
            hashKey %= arrSize;
            if ((++cnt) == arrSize) {
                System.out.println("Элемент для удаления не найден");
                return null;
            }
        }
        return null;
    }

    public Item find(int data) {
        int hashKey = hashFunc(data);
        int stepSize = hashFuncDouble(data); // Переменная stepSize вычисляется с помощью второй хеш-функции
        int cnt = 0;
        while (hashArr[hashKey] != null) {
            if (hashArr[hashKey].getData() == data) {
                return hashArr[hashKey];
            }
            hashKey += stepSize;
            hashKey %= arrSize;
            if ((++cnt) == arrSize) {
                return null;
            }
        }
        return null;
    }
}
