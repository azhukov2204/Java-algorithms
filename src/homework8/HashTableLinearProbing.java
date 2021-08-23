package homework8;

public class HashTableLinearProbing {
    private final Item[] hashArr; // Это сама хеш-таблица
    private final int arrSize; // Размер нашего массива
    private final Item nonItem; // Обозначение: элемента не существует. Т.е. замена существующего элемента в массиве на данный элемент, что эквивалентно удалению элемента из массива

    public HashTableLinearProbing(int size) {
        arrSize = size;          // Задаём размер нашей хеш-таблицы
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

    public int hashFunc(int data) {
        return data % arrSize; // Масштабирует хеш по размеру нашего массива arrSize
    }

    public void insert(Item item) {
        int data = item.getData();
        int hashKey = hashFunc(data);
        int cnt = 0;
        while (hashArr[hashKey] != null && hashArr[hashKey].getData() != -1) {
            ++hashKey;
            hashKey %= arrSize;
            if ((++cnt) == arrSize) { //если просмотрели весь массив
                System.out.printf("Вставка элемента %d невозможна, массив слишком мал\n", item.getData());
                return;
            }
        }
        hashArr[hashKey] = item;
    }

    // Удаление элемента в хеш-таблице
    public Item delete(int data) {
        int hashKey = hashFunc(data);
        int cnt = 0;
        while (hashArr[hashKey] != null) { // Пока у нас не наступил конец хеш-таблицы, мы что-то выполняем
            if (hashArr[hashKey].getData() == data) {
                Item temp = hashArr[hashKey];
                hashArr[hashKey] = nonItem;
                return temp; // Возвращаем удалённый элемент
            }
            ++hashKey;
            hashKey %= arrSize;
            if ((++cnt) == arrSize) { //если просмотрели весь массив
                System.out.println("Элемент для удаления не найден");
                return null;
            }
        }
        return null;
    }

    // Поиск элемента в хеш-таблице
    public Item find(int data) {
        int hashKey = hashFunc(data); // Хешируем ключ
        int cnt = 0;
        while (hashArr[hashKey] != null) {
            if (hashArr[hashKey].getData() == data) {
                return hashArr[hashKey];
            }
            ++hashKey;
            hashKey %= arrSize;
            if ((++cnt) == arrSize) { //если просмотрели весь массив
                return null;
            }
        }
        return null;
    }
}
