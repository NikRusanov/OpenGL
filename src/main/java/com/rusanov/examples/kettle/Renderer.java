package com.rusanov.examples.kettle;

import com.jogamp.opengl.*;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

public class Renderer implements GLEventListener {
final private GLU glu = new GLU();
    public Renderer() {}

    @Override
    public void init(GLAutoDrawable drawable) {




    }

    @Override
    public void dispose(GLAutoDrawable drawable) {

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_FOG_MODE);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        GLUT glut = new GLUT();
        GLUT glut2 = new GLUT();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glPushMatrix();
        gl.glTranslatef(40f,0f,0f);
        glut.glutSolidTeapot(4);
        gl.glPopMatrix();
        gl.glPushMatrix();

        gl.glTranslatef(0f, 0f, -5f);
        glut2.glutWireSphere(3,100,50);

        //glut2.glutSolidTetrahedron();


    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int weight, int height) {
        GL2 gl = drawable.getGL().getGL2();


        gl.glClearColor(0f, 0f, 0f, 0f);
        gl.glClearDepth(1f);
        gl.glDepthFunc(GL2.GL_LESS);
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glShadeModel(GL2.GL_LUMINANCE32F);
        gl.glMatrixMode(GL2. GL_PROJECTION );
        gl.glLoadIdentity();
        // camera perspective
        glu.gluPerspective(45f, 1.5f, 0.1f, 100f);
        //gl.glFrustumf(0,0,100,100,2,100);
        glu.gluLookAt(-50,-50,-30,50,50,50,100,100, 100);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glEnable(GL2.GL_LIGHTING);
        gl.glEnable(GL2.GL_LIGHT0);
//        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, new float[]{1f, 1f, 1f, 1f}, 0);
//        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, new float[]{0f, 0f, 1f, 0f}, 0);
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {

    }
}
