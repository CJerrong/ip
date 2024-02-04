package haro;

import haro.exception.InvalidArgsException;
import haro.task.Task;

import java.util.ArrayList;

/**
 * The TaskList class manages a list of tasks, providing methods for adding, marking, unMarking and deleting tasks.
 * It also provides methods for getting Task data, and total number of tasks in the list.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        tasks = new ArrayList<Task>();
    }

    /**
     * Constructs a TaskList from an existing ArrayList of Task objects.
     * @param tasks ArrayList containing Task objects to initialise the TaskList
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
    private String horizontalLine = "______________________________________________\n";

    /**
     * Converts tasks in the TaskList to a formatted string.
     *
     * @return Formatted string representation of tasks
     */
    public String tasksToString() {
        String taskString = "";

        if (tasks.isEmpty()) {
            return taskString;
        }

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            int index = i + 1;
            taskString += index + ". " + task.printTask() + "\n";
        }

        return taskString;
    }

    /**
     * Adds a task to the TaskList.
     *
     * @param task Task to be added
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Marks a task at the specified index.
     *
     * @param index Index of the task to be marked
     * @return The marked Task object
     * @throws InvalidArgsException If the index given is out of bounds
     */
    public Task markTask(int index) throws InvalidArgsException {
        if (index >= tasks.size()) {
            throw new InvalidArgsException("Sorry that item does not exist in your list!\n");
        }

        else if (index < 0) {
            throw new InvalidArgsException("Please input a positive task number!\n");
        }

        Task currTask = tasks.get(index);
        currTask.markTask();
        return currTask;
    }

    /**
     * UnMarks a task at the specified index.
     *
     * @param index Index of the task to be unmarked
     * @return The unmarked Task object
     * @throws InvalidArgsException If the index given is out of bounds
     */
    public Task unmarkTask(int index) throws InvalidArgsException {
        if (index >= tasks.size()) {
            throw new InvalidArgsException("Sorry that item does not exist in your list!\n");
        }

        else if (index < 0) {
            throw new InvalidArgsException("Please input a positive task number!\n");
        }

        Task currTask = tasks.get(index);
        currTask.unmarkTask();
        return currTask;
    }

    /**
     * Deletes a task at the specified index.
     *
     * @param index Index of the task to be deleted
     * @return The deleted Task Object
     * @throws InvalidArgsException If the index given is out of bounds
     */
    public Task deleteTask(int index) throws InvalidArgsException {
        if (index >= tasks.size()) {
            throw new InvalidArgsException("Sorry that item does not exist in your list!\n");
        }

        else if (index < 0) {
            throw new InvalidArgsException("Please input a positive task number!\n");
        }

        Task currTask = tasks.get(index);
        tasks.remove(index);
        return currTask;
    }

    /**
     * Retrieves the ArrayList of Task objects.
     *
     * @return ArrayList of Task objects
     */
    public ArrayList<Task> getArrayList() {
        return tasks;
    }

    /**
     * Retrieves the total number of tasks in the TaskList.
     *
     * @return Number of tasks in the TaskList
     */
    public int getSize() {
        return tasks.size();
    }
}
