package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

public class TCPserver extends Thread{
	
	String boton;
	private Main ref;
	
	public void run () {
		
			try {
				ServerSocket server = new ServerSocket(5000);
				System.out.println("Esperando cliente...");
				Socket socket = server.accept();
				System.out.println("Cliente esta conectado");

				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();

				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader breader = new BufferedReader(isr);

				while (true) {
					System.out.println("Esperando mensaje...");
					String mensajeRecibido = breader.readLine(); 
					System.out.println(mensajeRecibido);

					Gson gson = new Gson();

					boton = gson.fromJson(mensajeRecibido, String.class);
					ref.actions(boton);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
	
	}
	public void setMain(Main main) {
		this.ref =  main;
		
	}
	
}
