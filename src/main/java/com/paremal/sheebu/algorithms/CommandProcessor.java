package com.paremal.sheebu.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// ============================================================================
// OUTLINE: Command Pattern Implementation with Authentication Service
// ============================================================================
// 1. AuthService - Manages user registration, login, and session tracking
// 2. Command Interface - Defines command contract
// 3. RegisterCommand - Handles user registration
// 4. LoginCommand - Handles user login
// 5. LogoutCommand - Handles user logout
// 6. CommandProcessor - Main processor that orchestrates commands
// ============================================================================

// ============================================================================
// 1. AUTH SERVICE CLASS - Handles authentication logic
// ============================================================================
class AuthService {
    private final Map<String, String> userCredentials = new HashMap<>();
    private final Set<String> activeSessions = new HashSet<>();

    public String register(String username, String password) {
        if (userCredentials.containsKey(username)) {
            return "Error: User '" + username + "' already exists.";
        }
        userCredentials.put(username, password);
        return "Success: User '" + username + "' registered.";
    }

    public String login(String username, String password) {
        if (!userCredentials.containsKey(username)) {
            return "Error: User not found.";
        }
        if (!userCredentials.get(username).equals(password)) {
            return "Error: Invalid password.";
        }
        if (activeSessions.contains(username)) {
            return "Error: User is already logged in.";
        }
        activeSessions.add(username);
        return "Success: Logged in successfully.";
    }

    public String logout(String username) {
        if (!activeSessions.contains(username)) {
            return "Error: User is not currently logged in.";
        }
        activeSessions.remove(username);
        return "Success: Logged out successfully.";
    }
}


// ============================================================================
// 2. COMMAND INTERFACE - Defines the command contract
// ============================================================================
interface Command {
    String execute();
}


// ============================================================================
// 3. REGISTER COMMAND CLASS - Handles user registration
// ============================================================================
class RegisterCommand implements Command {
    private final AuthService authService;
    private final String username;
    private final String password;

    public RegisterCommand(AuthService authService, String username, String password) {
        this.authService = authService;
        this.username = username;
        this.password = password;
    }

    @Override
    public String execute() {
        return authService.register(username, password);
    }
}

// ============================================================================
// 4. LOGIN COMMAND CLASS - Handles user login
// ============================================================================
class LoginCommand implements Command {
    private final AuthService authService;
    private final String username;
    private final String password;

    public LoginCommand(AuthService authService, String username, String password) {
        this.authService = authService;
        this.username = username;
        this.password = password;
    }

    @Override
    public String execute() {
        return authService.login(username, password);
    }
}

// ============================================================================
// 5. LOGOUT COMMAND CLASS - Handles user logout
// ============================================================================
class LogoutCommand implements Command {
    private final AuthService authService;
    private final String username;

    public LogoutCommand(AuthService authService, String username) {
        this.authService = authService;
        this.username = username;
    }

    @Override
    public String execute() {
        return authService.logout(username);
    }
}


// ============================================================================
// 6. COMMAND PROCESSOR CLASS - Main orchestrator for command processing
// ============================================================================
public class CommandProcessor {
    private final AuthService authService;

    public CommandProcessor() {
        this.authService = new AuthService(); // In a real app, this would be dependency injected
    }

    public String process(String rawInput) {
        if (rawInput == null || rawInput.trim().isEmpty()) {
            return "Error: Empty command.";
        }

        String[] parts = rawInput.trim().split("\\s+");
        String action = parts[0].toUpperCase();

        try {
            return switch (action) {
                case "REGISTER" -> {
                    if (parts.length != 3) yield "Error: Usage REGISTER <username> <password>";
                    yield new RegisterCommand(authService, parts[1], parts[2]).execute();
                }
                case "LOGIN" -> {
                    if (parts.length != 3) yield "Error: Usage LOGIN <username> <password>";
                    yield new LoginCommand(authService, parts[1], parts[2]).execute();
                }
                case "LOGOUT" -> {
                    if (parts.length != 2) yield "Error: Usage LOGOUT <username>";
                    yield new LogoutCommand(authService, parts[1]).execute();
                }
                default -> "Error: Unknown command '" + action + "'.";
            };
        } catch (Exception e) {
            return "Error: An unexpected error occurred while processing the command.";
        }
    }

    
    public static void main(String[] args) {
        CommandProcessor processor = new CommandProcessor();

        System.out.println(processor.process("REGISTER alice secret123")); // Success
        System.out.println(processor.process("REGISTER alice newpass"));   // Error
        System.out.println(processor.process("LOGIN alice wrongpass"));    // Error
        System.out.println(processor.process("LOGIN alice secret123"));    // Success
        System.out.println(processor.process("LOGIN alice secret123"));    // Error (Already logged in)
        System.out.println(processor.process("LOGOUT alice"));             // Success
        System.out.println(processor.process("LOGOUT bob"));               // Error
      

    }
}
