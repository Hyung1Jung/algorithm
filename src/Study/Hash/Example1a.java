package Study.Hash;

public class Example1a {
    static class HashTable {
        int[] a;

        public HashTable(int n) {
            a = new int[n + 1];
        }

        public void add(int value) {
            a[value] = value;
        }

        public void remove(int value) {
            a[value] = 0;
        }

        public boolean contains(int value) {
            return a[value] == value;
        }
    }

    public static void main(String[] args) {
        int maxValue = 200, maxCount = 10;
        HashTable hashTable = new HashTable(maxValue);
        int[] data = { 1, 13, 105, 7, 9, 11, 14, 115, 107, 197 };
        for (int i = 0; i < data.length; ++i)
            hashTable.add(data[i]);
        for (int i = 1; i <= maxValue; ++i)
            if (hashTable.contains(i))
                System.out.println(i);
    }
}
