<img src="https://github.com/user-attachments/assets/03d794a6-4efd-4491-ada4-59dcd659103f" width="500"/>

# KCommander

## Hmph, it's not like I wanted to make this for you...

Welcome to **KCommander**, a Nukkit library that lets you register commands effortlessly. Not that I care if you use it or not. This is just a simple tool, okay? Don’t get the wrong idea!

## Features

- **Easy Command Registration**: I guess it makes your life easier by allowing you to register commands without much effort. But it's not like I care about your convenience.
- **Custom Command Contexts**: You can create your own command contexts if you really want to, though I'm sure you could do it on your own without my help.

## Installation

Oh, so you actually want to use this? Fine, here’s how you install it:

1. Add the library to your project.
2. Register your commands using `CommandService`. I’m sure you can figure it out on your own.

## Usage

I guess I should show you how to use it. Not that I think you’ll actually read this.

```java
@Override
public void onLoad() {
    final var service = CommandService.builder()
        .plugin(this)
        .command(Command.builder()
            .name("example")
            .permission("example.permission")
            .description("An example command")
            .context(new ExampleContext())
            .build())
        .build();

    service.register();
}

public class ExampleContext extends CommandContext {

    @Override
    public boolean onContext(final CommandInvoker invoker, final CommandArgumentPool argumentPool) {
        return true; // Ugh, I guess it works...
    }
}
```

## Contributing

What? You want to contribute? I mean, it's not like I need your help or anything. But if you insist, you can submit a pull request. I might look at it. Maybe.

## License

This project is licensed under the MIT License... Not that I care what you do with it.

---

Hmph, don’t think this makes us friends or anything!
