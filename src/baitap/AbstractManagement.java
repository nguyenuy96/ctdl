package baitap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class AbstractManagement<T extends ModelInterface> {

    public T add(T t) {
        try (FileWriter fstream = new FileWriter(getFileName(), true);
             BufferedWriter bufferedWriter = new BufferedWriter(fstream)
        ) {
            t.setId(UUID.randomUUID().toString());
            String updatedObject = generateObjectAsString(t);
            bufferedWriter.write("\n" + updatedObject);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return t;
    }

    public T update(T t) throws IOException {
        File file = new File(getFileName());
        File tempFile = new File(getTempFileName());

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            if(currentLine.contains(t.getId())) {
                writer.write(generateObjectAsString(t) + "\n");
            } else {
                writer.write(currentLine + "\n");
            }
        }

        writer.close();
        reader.close();
        file.delete();
        tempFile.renameTo(file);
        return t;
    }

    public void delete(String id) throws IOException {
        File file = new File(getFileName());
        File tempFile = new File(getTempFileName());

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            if(currentLine.contains(id)) continue;
            writer.write(currentLine + "\n");
        }
        writer.close();
        reader.close();
        file.delete();
        tempFile.renameTo(file);
    }

    public T findById(String id) {
        T t = null;
        try(BufferedReader reader = new BufferedReader(new FileReader(getFileName()))) {
            //skip read the first line
            reader.readLine();
            String str;

            while ((str = reader.readLine()) != null) {
                if (str.contains(id)) {
                    String[] strings = str.split(",");
                    t = getObjectFromFile(strings);
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
        return t;
    }

    public List<T> findAll() {
        List<T> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(getFileName()))) {
            //skip read the first line
            reader.readLine();
            String str;

            while ((str = reader.readLine()) != null) {
                String[] strings = str.split(",");
                list.add(getObjectFromFile(strings));
            }
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
        return list;
    }

    public abstract String getFileName();
    public abstract String getTempFileName();
    public abstract T getObjectFromFile(String[] strings);
    protected abstract String generateObjectAsString(T t);
}
