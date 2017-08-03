/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pt;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.pt.exceptions.ServerAlreadyUsePort;
import com.pt.implementation.server.Server;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ProtocolException;
import java.util.Scanner;

/**
 *
 * @author Tiago Alexandre Melo Almeida
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ServerAlreadyUsePort {

        switch (args[0]) {
            case "-s"://-s (portnumber)
                launchInServerMode(Integer.parseInt(args[1]));
                break;
            case "-c"://-c (host) (portnumber)
                launchInClientMode(args[1],Integer.parseInt(args[2]));
                break;
            default:
                System.out.println("Invalid argument: " + args[0]);
                break;

        }
    }

    private static void launchInServerMode(int portNumber) throws ServerAlreadyUsePort {
        System.out.println("Starting Server on port " + portNumber);
        Server server = new Server(50, 1);
        
        //start listing client connections
        server.startListningConnections(portNumber, (in, out) -> {
            //logic to handle each connection
            //messages are in json format
            JsonObject jObject = new JsonParser().parse(new InputStreamReader(in)).getAsJsonObject();
            String command = jObject.get("command").getAsString();
            
            switch (command){
                case "enter":
                    //TODO client-server-library precisa de ter algo para aceder a todos os clientes conetados.. standby
                    break;
                case "leave":
                    break;
                case "message":
                    break;
                default:
                    throw new ProtocolException("Command invalid " + command);
            }
        });
    }

    private static void launchInClientMode(String host, int portNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
