# Task 2: Dependencies

UML diagram: `task2-uml.png`

## Necessary dependencies
- `Volvo240`, `Saab95` → `Car` → `Moveable`, and `Car` → `Direction`: the model's inheritance design.
- One GUI class → the cars (to send gas, brake, turn commands).
- `CarView` → `DrawPanel` (the window contains the panel) and `CarView` → a controller (buttons need someone to call).
- `CarApplication` → the classes it creates; `CarTest` → the classes it tests; Swing superclasses.

## Dependencies that shouldn't exist
- `CarController` ↔ `CarView`: a cycle. Each holds a reference to the other.
- `CarController` → `DrawPanel`: reaches through the view (`frame.drawPanel.moveit(...)`).
- `CarController` → `Saab95`: `instanceof Saab95` for the turbo buttons.
- Hidden coupling: `DrawPanel`'s image order must match the order `CarApplication` adds cars; the image size 200×150 is duplicated in `DrawPanel` and `CarController`.

## Dependencies stronger than necessary
- GUI depends on concrete classes (`Car`, `Saab95`, `CarView`) instead of small interfaces (DIP).
- `CarView` depends on all of `CarController` but only uses the button commands (ISP).
- `CarController` holds all of `CarView` but only needs to redraw the panel.
- Package-private fields (`cars`, `frame`, `carC`, `drawPanel`) are set or read directly from other classes.
- `Volvo240`/`Saab95` read `Car`'s `protected` field `enginePower` instead of using `getEnginePower()`.

## Other principle violations
- Law of Demeter: `frame.drawPanel.*` calls in `TimerListener`.
- Encapsulation: open fields in `CarController` and `CarView`, `protected` fields in `Car`.
- OCP: adding a new car model means editing `DrawPanel`, `CarApplication` and possibly `CarController`.
- SRP: `TimerListener` handles movement, wall collisions and redrawing.

## Summary
- Cohesion: high in the model, low in the GUI (`CarController` mixes timer, physics and input).
- Coupling: the model doesn't depend on the GUI; the GUI is tightly coupled (cycle, reach-through, hidden assumptions).
- DIP: broken in the GUI; our `Moveable` interface goes unused there.
