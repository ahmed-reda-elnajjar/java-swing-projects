# Java Swing Projects

Desktop GUI applications in Java Swing (NetBeans / Ant projects).

## StudentRegistrationApp
Multi-screen registration wizard (Start → Form → Confirm → Thank you) built on clean OOP:
- `FormActions` interface as the controller contract
- abstract `BasePanel` with one subclass per screen
- `JFrame` + `CardLayout`-style panel switching and event listeners

Run: open in NetBeans, or compile `src/*.java` with `javac` and run `StudentRegistrationApp`.

## DrawingApp
Drawing tool with shape primitives (circle, rectangle) through a `Shape` base class, a custom `DrawingPanel`, color selection and freehand strokes.

Run the packaged build: `java -jar DrawingApp/dist/DrawingApp.jar`
