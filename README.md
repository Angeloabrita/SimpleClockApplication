# Simple Analog Clock Application

This project is a simple analog clock application built using JavaFX and Maven. The clock displays the current time with hour, minute, and second hands, and it updates every second. The application also includes a title label at the top.

## This project is part of the University Of The People Assignment in CS 1103-01

## Features

- Analog clock with hour, minute, and second hands
- Updates every second
- Clear and easy-to-read clock face
- Title label with custom styling

## Prerequisites

To run this project, you will need:

- Java Development Kit (JDK) 8 or later
- Maven 3.6.0 or later

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine.

### Clone the Repository

```bash
git clone https://github.com/Angeloabrita/SimpleClockApplication.git
cd SimpleClockApplication
```

### Build the Project

Use Maven to build the project:

```bash
mvn clean install
```

### Run the Application

After building the project, you can run the application using the following Maven command:

```bash
mvn javafx:run
```

Alternatively, you can run the application from your IDE by executing the `App` class located in the `com.clock.simpleclockapplication` package.

## Project Structure

The project consists of two main classes:

1. `CLock.java`: This class extends the `Canvas` class and handles the drawing of the clock face and hands. It includes methods to draw the clock face and update the clock hands every second.

2. `App.java`: This class extends `Application` and serves as the entry point for the JavaFX application. It sets up the stage, scene, and a thread to update the clock every second.

## Customization

You can customize the appearance of the clock and the title label by modifying the styles and dimensions in the `CLock` and `App` classes.

- To change the size of the clock, adjust the width and height parameters in the `CLock` constructor.
- To modify the title label's style, update the `setStyle` method in the `App` class.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgements

- This project uses JavaFX for the graphical user interface.
- Special thanks to the JavaFX community for their tutorials and documentation.

## Author

- Angelo Abrita

