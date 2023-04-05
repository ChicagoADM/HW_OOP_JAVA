import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Diary implements Iterable<Task> {
    List<Task> taskList;

    public Diary() {
        taskList = new ArrayList<Task>();
    }

    public Task getTask(int i) {
        return taskList.get(i);
    }

    public int getSize() {
        return taskList.size();
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void deletTask(int i) {
        taskList.remove(getTask(i));
    }

    public void printDiary() {
        Iterator<Task> iterator = taskList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void writeDiary(File file) {
        try (FileWriter writer = new FileWriter(file, false)) {
            for (Task task : taskList) {
                writer.write(task.toString());
                writer.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortByFinishDate() {
        Collections.sort(taskList);
    }

    @Override
    public Iterator<Task> iterator() {
        return taskList.iterator();
    }

}
