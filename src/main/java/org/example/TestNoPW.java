package org.example;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.userauth.keyprovider.KeyProvider;

public class TestNoPW {
    public static void main(String[] args) {
        String hostname = "149.165.172.192";
        String username = "exouser";
        String privateKeyPath = "/Users/lahiruj/Projects/airavata/gateways/stampede3-issue/id_default_seagrid";

        SSHClient sshClient = new SSHClient();
        try {
            sshClient.addHostKeyVerifier((hostname1, port, key) -> true);
            sshClient.connect(hostname);
            KeyProvider keyProvider = sshClient.loadKeys(privateKeyPath);
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
