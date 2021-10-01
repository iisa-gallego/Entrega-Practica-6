package main;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.google.gson.Gson;

import processing.core.PApplet;

public class Main extends PApplet {

	int xBolita = 50;
	int yBolita = 200;
	int r, g, b;

	String boton;

	private TCPserver conexion;
	private Bolita bolita;

	public static void main(String[] args) {
		PApplet.main("main.Main");
	}

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		conexion = new TCPserver();
		conexion.setMain(this);
		conexion.start();

		bolita = new Bolita(xBolita, yBolita, 50, 50, 255,0,0,this);

	}

	public void draw() {
		background(0, 0, 0);
		bolita.drawBolita();
	}

	public void actions (String llave) {
		bolita.actions(llave);
	}

}

