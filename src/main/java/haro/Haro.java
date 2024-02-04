package haro;

import haro.command.Command;
public class Haro {
    private String haroLogo = " ___  ___  ________  ________  ________\n"
            + "|\\  \\|\\  \\|\\   __  \\|\\   __  \\|\\   __  \\\n"
            + "\\ \\  \\\\\\  \\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\|\\  \\\n"
            + " \\ \\   __  \\ \\   __  \\ \\   _  _\\ \\  \\\\\\  \\\n"
            + "  \\ \\  \\ \\  \\ \\  \\ \\  \\ \\  \\\\  \\\\ \\  \\\\\\  \\\n"
            + "   \\ \\__\\ \\__\\ \\__\\ \\__\\ \\__\\\\ _\\\\ \\_______\\\n"
            + "    \\|__|\\|__|\\|__|\\|__|\\|__|\\|__|\\|_______|\n";
    private String horizontalLine = "______________________________________________";
    private String openingMsg = "Heya! I'm Haro!\n" + "What can I do for you today?";
    private String closingMSg = "Bye. Hope to see you some time soon!";
    private TaskList taskList;
    private Storage haroStorage;
    private Ui haroUi;

    public Haro(String dataPath, String directory) {
        this.taskList = new TaskList();
        this.haroUi = new Ui();
        this.haroStorage = new Storage(dataPath, directory);
        this.taskList = new TaskList(haroStorage.loadSave());
    }

    public void initialise() {
        haroUi.greet();
        boolean isExit = false;

        while(!isExit) {
            try{
                String fullCommand = haroUi.readCommand();
                Command c = Parser.parseCommand(fullCommand);
                c.execute(taskList, haroUi, haroStorage);
                isExit = c.isExit();
            } catch (Exception e) {
                haroUi.showError(e.getMessage());
            }
        }

        haroUi.bye();
    }
}

