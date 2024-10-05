package org.example;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.userauth.keyprovider.KeyProvider;

public class Main {
    public static void main(String[] args) {
//        String hostname = "login.expanse.sdsc.edu";
//        String username = "gridchem";
        String hostname = "stampede3.tacc.utexas.edu";
        String username = "ccguser";
//        String hostname = "149.165.172.192";
//        String username = "exouser";
        String privateKeyPath = "/Users/lahiruj/Projects/airavata/gateways/stampede3-issue/id_original";
        String passphrase = "c45d3fde-7373-486f-a1ed-ea7f4fcf8d7b";

        SSHClient sshClient = new SSHClient();
        try {
            sshClient.addHostKeyVerifier((hostname1, port, key) -> true);
            sshClient.connect(hostname);
            KeyProvider keyProvider = sshClient.loadKeys(privateKeyPath, passphrase);
            sshClient.authPublickey(username, keyProvider);
            System.out.println("Authentication successful!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                sshClient.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}