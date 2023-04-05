import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Task implements Comparable<Task> {
    private String textTask;
    private Priority priority;
    private Calendar finishTask;
    private DateFormat dateFormat = new SimpleDateFormat("d MMM yyyy");

    public Task(String textTask, Priority priority) {
        this.textTask = textTask;
        this.priority = priority;
        finishTask = Calendar.getInstance();

        switch (priority) {
            case URGENTLY:
                finishTask.add(Calendar.DAY_OF_YEAR, 3);
                break;
            case STANDART:
                finishTask.add(Calendar.DAY_OF_YEAR, 7);
                break;
            case LONG:
                finishTask.add(Calendar.DAY_OF_YEAR, 21);
                break;
        }
    }

    public Calendar getDateFinishTask() {
        return finishTask;
    }

    @Override
    public String toString() {
        return textTask + ".  Срок выполнения до: "
                + dateFormat.format(finishTask.getTime());
    }

    @Override
    public int compareTo(Task o) {
        return finishTask.compareTo(o.getDateFinishTask());
    }
}
