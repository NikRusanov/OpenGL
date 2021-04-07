package com.rusanov.examples.kettle;

import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.FPSAnimator;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class GLFrame extends Frame {
    private GLCanvas canvas;
    private FPSAnimator anim;

    public GLFrame() {
        GLCanvas canvas = new GLCanvas();
        canvas.setIgnoreRepaint(false);
        canvas.setSize(1924, 1080);

        setTitle("Sample OpenGL Java application");
        setResizable(false);
        setLayout(new BorderLayout());
        add(canvas, BorderLayout.CENTER);
        setSize(getPreferredSize());

        canvas.addGLEventListener(new Renderer());

        anim = new FPSAnimator(1000);
        anim.add(canvas);


        anim.start();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                anim.stop();
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        GLFrame frame = new GLFrame();
        frame.setVisible(true);
    }
}
