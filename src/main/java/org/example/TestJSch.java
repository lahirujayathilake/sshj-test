package org.example;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class TestJSch {
    public static void main(String[] args) {
        String hostname = "stampede3.tacc.utexas.edu";
        String username = "ccguser";
        String privateKeyPath = "/Users/lahiruj/Projects/airavata/gateways/stampede3-issue/server-alg-compatible-key/key2";

        JSch jsch = new JSch();
        try {
            jsch.addIdentity(privateKeyPath);

            Session session = jsch.getSession(username, hostname, 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            System.out.println("Authentication successful!");
            session.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
