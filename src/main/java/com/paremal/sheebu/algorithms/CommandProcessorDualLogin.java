package com.paremal.sheebu.algorithms;

import java.util.HashMap;
import java.util.Map;

/*
 * Outline:
 * This file implements a Command Processor that supports dual login for each user using the Command design pattern.
 * 
 * Classes:
 * - CommandProcessorDualLogin: Main processor class that handles command execution.
 * - Session: Manages login sessions for a user, limiting to a maximum of 2 concurrent logins.
 * - AuthService: Provides authentication services including register, login, and logout.
 * - Command: Interface for executable commands.
 * - RegisterCommand: Command to register a new user.
 * - LoginCommand: Command to log in a user.
 * - LogoutCommand: Command to log out a user.
 */

// ============================================================================
// COMMAND PROCESSOR with dual login for each user
// ============================================================================

public class CommandProcessorDualLogin {

    private final AuthService1 authService;


    public CommandProcessorDualLogin(AuthService1 authService) {
        this.authService = authService;
    }

    public static void main(String[] args) {
        // Initialize the authentication service and command processor
        AuthService1 authService = new AuthService1();
        CommandProcessorDualLogin processor = new CommandProcessorDualLogin(authService);

        // Test the command processor with sample commands
        System.out.println(processor.processCommand("REGISTER alice password123"));
        System.out.println(processor.processCommand("LOGIN alice password123"));
        System.out.println(processor.processCommand("LOGIN alice password123"));
        //System.out.println(processor.processCommand("LOGIN alice password123"));

        System.out.println(processor.processCommand("LOGIN alice password123")); // Should fail - both logins used
        System.out.println(processor.processCommand("LOGOUT alice password123"));
        System.out.println(processor.processCommand("LOGOUT alice password123"));
       // System.out.println(processor.processCommand("LOGOUT alice password123"));
        System.out.println(processor.processCommand("LOGOUT alice password123")); // Should fail - not logged in
    }


    public String processCommand(String rawCommandInput) {
        // Validate the input command string
        if (rawCommandInput == null || rawCommandInput.trim().isEmpty()) {
            return "Error: empty command input";
        }
        // Parse the command into parts
        String[] commands = rawCommandInput.split("\\s+");
        String action = commands[0].toUpperCase();

        try {
            // Execute the corresponding command based on the action
            return switch (action) {
                case "LOGIN" -> {
                    if (commands.length != 3) yield "Error: wrong number of arguments";
                    yield new LoginCommand1(authService, commands[1], commands[2]).execute();
                }
                case "LOGOUT" -> {
                    if (commands.length != 3) yield "Error: wrong number of arguments";
                    yield new LogoutCommand1(authService, commands[1], commands[2]).execute();
                }
                case "REGISTER" -> {
                    if (commands.length != 3) yield "Error: wrong number of arguments";
                    yield new RegisterCommand1(authService, commands[1], commands[2]).execute();
                }
                default -> "Error: invalid command type";
            };

        } catch (Exception e) {
            return "Error: An unexpected occurred while trying to process the command";
        }
    }

}

// ============================================================================
// SESSION MANAGEMENT MULTIPLE LOGIN FOR EACH USER
// ============================================================================

class Session {

    // Fields to track the username and current session count
    private String username;
    private int sessionCount;
    private static final int MAX_SESSIONS = 2;

    // Constructor initializes the session with one active login
    public Session(String username) {
        this.username = username;
        this.sessionCount = 1;
    }

    // Increments the session count if below the maximum allowed
    public boolean countUP() {
        if (sessionCount < MAX_SESSIONS) {
            sessionCount++;
            return true;
        } else return false;
    }

    // Decrements the session count if above zero
    public boolean countDOWN() {
        if (sessionCount > 0) {
            sessionCount--;
            return true;
        } else return false;

    }

    // Getter for current session count
    public int getSessionCount() {
        return sessionCount;
    }

    // Getter for maximum allowed sessions
    public int getMaxSessions() { return MAX_SESSIONS; }

}

// ============================================================================
// AUTHENTICATION SERVICE which allow dual login for each user
// ============================================================================

class AuthService1 {

    // Map to store username-password pairs
    Map<String, String> loginCredentials = new HashMap<>();
    // Map to store active sessions for each user
    Map<String, Session> activeLoginSessions = new HashMap<>();

    // Registers a new user if the username is not already taken
    public String register(String username, String password) {
        // Check if user already exists
        if (loginCredentials.containsKey(username)) {
            return "Error: User '" + username + "' already exists!";
        }
        // Store the credentials
        loginCredentials.put(username, password);
        return "Success: User '" + username + "' successfully registered.";
    }

    // Logs in a user, allowing up to 2 concurrent sessions
    public String login(String username, String password) {
        // Verify user exists
        if (!loginCredentials.containsKey(username)) {
            return "Error: User '" + username + "' does not exist!";
        }
        // Verify password
        if (!loginCredentials.get(username).equals(password)) {
            return "Error: invalid password!";
        }
        // Check if session exists, increment if possible
        if (activeLoginSessions.containsKey(username)) {
            if (activeLoginSessions.get(username).countUP()) {
                return "Success: User '" + username + "' successfully logged in and login count: "
                        + activeLoginSessions.get(username).getSessionCount();
            }
            return "Error: User '" + username + "' already used all  allowed  logins (maximum is:" + activeLoginSessions.get(username).getMaxSessions() + ")";
        }
        // Create new session
        activeLoginSessions.put(username, new Session(username));
        return "Success: User '" + username + "' successfully logged in and login count:" + activeLoginSessions.get(username).getSessionCount();
    }

    // Logs out a user, decrementing the session count
    public String logout(String username) {
        // Check if user is logged in
        if (!activeLoginSessions.containsKey(username)) {
            return "Error: User '" + username + "' is not logged in.";
        } else {
            if (activeLoginSessions.get(username).countDOWN()) {
                return "Success: User '" + username + "' successfully logged out and remaining login count:"
                        + activeLoginSessions.get(username).getSessionCount();
            } else {
                return "Error: User '" + username + "' is not logged in.";
            }
        }


    }
}

// ============================================================================
// COMMAND INTERFACE & IMPLEMENTATIONS
// ============================================================================

// Interface for commands that can be executed, returning a result string
interface Command1 {

    String execute();
}

// Command to register a new user
class RegisterCommand1 implements Command1 {

    private final AuthService1 authService;
    private final String username;
    private final String password;

    // Constructor to initialize the command with auth service and user details
    RegisterCommand1(AuthService1 authService, String username, String password) {
        this.authService = authService;
        this.username = username;
        this.password = password;

    }

    // Execute the registration
    @Override
    public String execute() {
        return authService.register(username, password);
    }
}

// Command to log in a user
class LoginCommand1 implements Command1 {

    private final AuthService1 authService;
    private final String username;
    private final String password;

    // ========================================================================
    // Constructor to initialize the command with auth service and user details
    LoginCommand1(AuthService1 authService, String username, String password) {
        this.authService = authService;
        this.username = username;
        this.password = password;
    }

    // Execute the login
    @Override
    public String execute() {
        return authService.login(username, password);
    }
}

// Command to log out a user
class LogoutCommand1 implements Command1 {

    private final AuthService1 authService;
    private final String username;
    private final String password;

    // Constructor to initialize the command with auth service and user details
    LogoutCommand1(AuthService1 authService, String username, String password) {
        this.authService = authService;
        this.username = username;
        this.password = password;
    }

    // Execute the logout
    @Override
    public String execute() {
        return authService.logout(username);
    }
}
