package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> swappedData = new HashMap<>();

        for (Map.Entry<String,String> entry : storage.toMap().entrySet() ) {
            swappedData.put(entry.getValue(), entry.getKey());
        }

        // Очищаем хранилище
        for (String key : storage.toMap().keySet()) {
            storage.unset(key);
        }

        // Записываем новые перевернутые значения
        for (Map.Entry<String, String> entry : swappedData.entrySet()) {
            storage.set(entry.getKey(), entry.getValue());
        }
    }
}
// END
