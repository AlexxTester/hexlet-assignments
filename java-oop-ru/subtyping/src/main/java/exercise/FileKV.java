package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage{
    private final String filePath;

    public FileKV(String filePath, Map<String, String> initialData) {
        this.filePath = filePath;
        Utils.writeFile(filePath, Utils.serialize(initialData)); // Записываем начальные данные в файл
    }

    // Читает текущее состояние хранилища из файла
    private Map<String, String> readData() {
        String fileContent = Utils.readFile(filePath);
        return Utils.deserialize(fileContent);
    }

    // Сохраняет обновленные данные в файл
    private void writeData(Map<String, String> data) {
        Utils.writeFile(filePath, Utils.serialize(data));
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> data = readData();
        data.put(key, value);
        writeData(data);
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> data = readData();
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public void unset(String key) {
        Map<String, String> data = readData();
        data.remove(key);
        writeData(data);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(readData()); // Возвращаем копию данных
    }
}
// END
