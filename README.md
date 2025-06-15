# 🧠 Task Tracker CLI — Java Edition

A lightweight, blazing-fast **Command Line Interface (CLI)** to manage your daily tasks directly from the terminal. Powered by **pure Java**, no external frameworks — just you, your terminal, and a JSON file.

---

## 🚀 Features

- ✅ Add, update, and delete tasks
- ⏳ Mark tasks as `todo`, `in-progress`, or `done`
- 📋 List tasks by status or view all
- 💾 Data stored locally in a JSON file (`tasks.json`)
- ⚙️ Built using **only standard Java and org.json**
- 🧩 No frameworks, no bloat, just raw power

---

## 🛠 Project Structure

TaskTracker/
│
├── lib/
│ └── json.jar # JSON parsing library
│
├── Task.java # Task object model
├── TaskManager.java # Business logic
├── TaskStorage.java # JSON read/write handler
├── Main.java # Entry point
├── task-cli.bat # Windows CLI wrapper
├── tasks.json # (auto-generated) Task database
└── README.md

## 🧪 How to Use

### 📦 Compile

```bash
javac -cp ".;lib/json.jar" *.java

java -cp ".;lib/json.jar" Main add "Finish Java CLI project"
java -cp ".;lib/json.jar" Main list
java -cp ".;lib/json.jar" Main mark-done 1

.\task-cli.bat add "Write unit tests"
.\task-cli.bat list in-progress

```

🧩 CLI Commands
Command	                |      Description
------------------------|--------------------------------
add "desc"	            |      Add a new task
update ID "desc"	    |      Update task description
delete ID	            |      Delete a task
mark-in-progress ID	    |      Mark a task as in-progress
mark-done ID	        |      Mark a task as done
list	                |      List all tasks
list todo	            |      List only tasks with status "todo"
list done	            |      List only tasks marked "done"
list in-progress	    |      List tasks in progress

## JSON data Formate

{
  "id": 1,
  "description": "Example Task",
  "status": "todo",
  "createdAt": "2025-06-14 18:00:00",
  "updatedAt": "2025-06-14 18:00:00"
}


# Creator : Krish Maheshwari

## Contributors : 