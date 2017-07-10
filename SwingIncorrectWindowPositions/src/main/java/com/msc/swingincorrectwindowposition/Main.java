package com.msc.swingincorrectwindowposition;

import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This project exists in order to test what {@link Window#getX()} returns when the window is
 * closing.
 * <p>
 * On Windows 10, {@link Window#getX()} seems to return the correct coordinate minus <code>7</code>,
 * on Ubuntu the coordinates seem to be correct.
 * </p>
 * <p>
 * {@link Window#getY()} on the other hand,returns the correct value on Windows 10 and Ubuntu.
 * </p>
 *
 * @author Marcel
 * @since 10.07.2017
 */
public class Main extends Application
{
	public static void main(final String[] args)
	{
		testFX();

		testSwing();
	}

	private static void testFX()
	{
		launch();
	}

	private static void testSwing()
	{
		final JFrame frame = new JFrame();

		// Set a convenient size
		frame.setSize(200, 200);

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent e)
			{
				// Print X coordinates
				System.out.println("Swing - X in Closing: " + frame.getX());
				System.out.println("Swing - X 2 in Closing: " + frame.getLocationOnScreen().getX());
			}
		});

		frame.setVisible(true);
	}

	@Override
	public void start(final Stage primaryStage) throws Exception
	{
		primaryStage.setHeight(200);
		primaryStage.setWidth(200);

		primaryStage.setOnCloseRequest(closing ->
		{
			System.out.println("FX - X in Closing: " + primaryStage.getX());
		});

		primaryStage.show();
	}
}
