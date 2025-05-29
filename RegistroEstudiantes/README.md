
# Student Registration System (RegistroEstudiantes)

This is a Java-based desktop application designed to manage student registration information. The system allows users to add, view, and store student data in a structured format. It is ideal for small institutions or educational settings where a lightweight, offline solution is preferred.

## 📌 Features

- Register new students with essential information.
- Display the list of registered students.
- Persist data using a text file (`estudiantes.txt`).
- Graphical User Interface (GUI) using Swing.
- Organized architecture using the MVC (Model-View-Controller) pattern.

## 📁 Project Structure

```
RegistroEstudiantes/
│
├── build.xml                  # Apache Ant build script
├── manifest.mf                # Manifest for JAR packaging
├── estudiantes.txt            # Student data file
├── src/                       # Source code directory (if present)
│   ├── app/                   # Application entry point
│   ├── controladores/         # Controllers
│   ├── datos/                 # Data handling
│   └── vistas/                # GUI components
├── build/classes/             # Compiled .class files
└── build/classes/imagenes/   # Resource icons (PNG)
```

> ⚠️ If you're using NetBeans, you can directly open the project. Otherwise, you can compile and run it using `javac` and `java` commands.

## 🚀 How to Run

### Prerequisites

- Java JDK 8 or higher
- NetBeans (optional, but recommended for managing this project)
- Apache Ant (optional for build automation)

### Steps

1. **Clone or Download** this repository.
2. Open the project in NetBeans (recommended) or compile manually:
   ```bash
   javac -d build/classes src/**/*.java
   java -cp build/classes app.App
   ```
3. Make sure `estudiantes.txt` is present in the correct directory for data persistence.

## 🛠 Technologies Used

- Java SE
- Swing for GUI
- File I/O for data persistence
- MVC architecture
- Apache Ant (build automation)

## 👤 Author

- **Alexander Freckleton**

---

Feel free to customize this README based on your specific implementation or features you plan to add.
