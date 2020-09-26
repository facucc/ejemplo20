package Actores;
import java.util.Arrays;

import Gestion.Monitor;
import Red.PetriNets;
import Utilidades.RegistroMonitor;

public class Hilo0 implements Runnable {

	private Monitor monitor;
	int[] ConjTrans;
	int limit ;
	private PetriNets red;
	private RegistroMonitor reg;
	
	
	public Hilo0(Monitor monitor,PetriNets red,int CantTareas,int[] ConjTrans,RegistroMonitor reg) {
		this.monitor=monitor;
		this.ConjTrans=ConjTrans;
		this.red=red;
		limit=CantTareas/2;
		this.reg=reg;
	}

public void run() {
	 try {
		 monitor.enter(ConjTrans[0]);		
		 monitor.enter(ConjTrans[1]);	
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	 int task=0;
	 
	 while(task<limit) {
		 try {
			monitor.enter(ConjTrans[2]);
			task++;
			//System.out.println("Cantidad de tareas procesadas por:" + Thread.currentThread().getName() + " " + task);
			//System.out.println(Arrays.deepToString(red.getEstados().getMatriz()));
			
			/*
			reg.write1("Cantidad de tareas procesadas por:" + Thread.currentThread().getName() + " " + task);
			reg.write1(Arrays.deepToString(red.getEstados().getMatriz()));*/
			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	 }
	 System.out.println("Cantidad de tareas procesadas por:" + Thread.currentThread().getName() + " " + task);	 
	 try {
		monitor.enter(ConjTrans[3]);
	   } catch (InterruptedException e) {
		
		e.printStackTrace();
	}	 
}
}
