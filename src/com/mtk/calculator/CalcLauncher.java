package com.mtk.calculator;
import java.awt.EventQueue;


/**
 * The main launcher for java calculator. Creates the {@code Calculator} object.
 * @author <a href="http://www.mdtareque.in" target="_blank">mtk</a>
 * @version 1.0 Nov 25, 2012
 * @see Calculator
 */
public class CalcLauncher {
	/**
	 * @param args
	 * Currently no arguments required to be passed to this program.
	 */
	public static void main(String[] args) {

		// Use the event dispatch thread for Swing components
		EventQueue.invokeLater(new Runnable() {
			/* (non-Javadoc)
			 * @see java.lang.Runnable#run()
			 */
			@Override
			public void run() {
				new Calculator();
			}
		});
	}
}
