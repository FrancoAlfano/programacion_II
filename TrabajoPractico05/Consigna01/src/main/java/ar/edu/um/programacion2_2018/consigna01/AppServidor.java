/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.um.programacion2_2018.consigna01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServidor {
    public AppServidor() {}
   
    public static void main(String[] args) throws IOException {

    ServerSocket s_serv = null;
	
    System.out.println("Iniciando servidor\n");
        
    try {
        s_serv = new ServerSocket(1234);
        while(true) {
            Socket s_Cola = s_serv.accept();
            System.out.println("Nueva cola aceptada");
            Cajero tmp = new Cajero(s_Cola);
            tmp.start();
        }
    }catch (IOException e) {
    }finally {
        if(s_serv != null) {
            s_serv.close();
        }
    }
    }
}
