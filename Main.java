public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        if(args.length == 0){
            printHelp();
            return;
        }

        String command  = args[0];

        try {
            switch (command){
                case "add" -> {
                    if(args.length < 2){
                        System.out.println("Usage: task-cli add \"description\"");
                    }
                    else{
                        manager.addTask(args[1]);
                    }
                }

                case "update" -> {
                    if(args.length < 3){
                        System.out.println("Usage: task-cli update <id> \"new description\"");
                    }
                    else{
                        int id = Integer.parseInt(args[1]);
                        manager.updateTask(id, args[2]);
                    }
                }

                case "delete" -> {
                    if(args.length < 2){
                        System.out.println("Usage: task-cli delete <id>");
                    }
                    else{
                        int id = Integer.parseInt(args[1]);
                        manager.deleteTask(id);
                    }
                }

                case "mark-in-progress" -> {
                    if(args.length < 2){
                        System.out.println("Usage: task-cli mark-in-progress <id> ");

                    }
                    int id = Integer.parseInt(args[1]);
                    manager.markInProgress(id);
                }

                case "mark-done" -> {
                    if(args.length < 2){
                        System.out.println("Usage: task-cli mark-done <id>");
                    }
                    else{
                        int id = Integer.parseInt(args[1]);
                        manager.markDone(id);
                    }
                }

                case "list" -> {
                    if (args.length == 1) {
                        manager.listAllTasks();
                    } else {
                        String status = args[1].toLowerCase();
                        if (status.equals("done") || status.equals("todo") || status.equals("in-progress")) {
                            manager.listByStatus(status);
                        } else {
                            System.out.println("Invalid status. Use: done, todo, in-progress");
                        }
                    }
                }

                default -> {
                    System.out.println("Unknown command: " + command);
                    printHelp();
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        }
        catch (Exception e){
            System.out.println("An error occurred: "+ e.getMessage());
        }
    }

    private static void printHelp() {
        System.out.println("Task Tracker CLI Usage:");
        System.out.println("  add \"description\"");
        System.out.println("  update <id> \"new description\"");
        System.out.println("  delete <id>");
        System.out.println("  mark-in-progress <id>");
        System.out.println("  mark-done <id>");
        System.out.println("  list");
        System.out.println("  list <todo|done|in-progress>");
    }
}
