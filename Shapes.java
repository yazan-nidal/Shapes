import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Graphics;

// i use it for JButton Event
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// i use it for JCheckBox Event
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;


// use it for draw shapes
import java.awt.Polygon;
//import java.awt.Arc;



// element i want add to panel then add to frame
// class abstract and an abstract methods "addElement " to force a user to redefine methods "addElement"
abstract class Element
 {
	    // green panel Element
		protected JButton button_rect;
		protected JButton button_oval;
		protected JButton button_arc;
		protected JButton button_poly;

		//red panel Element
		protected JCheckBox checkBox;
		protected JComboBox comboBox;
		protected JButton button_remove;

		protected abstract void addElement(JPanel panel,JPanel panel1);//JPanel panel :green panel , JPanel panel1 :red panel

 }

 // extends from Element to use protected component and  methods , if method is abstract method  must be redefine
 public class Shapes extends Element implements ActionListener,ItemListener
 {
	    // variables and components

	    private JFrame frame_; // object frame

	    final int frame_width;
	 	final int frame_height;

	 	final int panel_width;
	 	final int panel_height;

	 	// static for use it in any class without object definition because is static it definition for one times
	 	static int draw;
	 	static int fill;
	 	static Color color_I;

	    private  JPanel paneLI;// JPanel : default JPanel before draw
	 	private JPanel paneLII; // green JPanel :  shapes buttons
	 	private JPanel paneL0;// JPanel : fill , remove , color
	 	private JPanel paneLIII;// draw in this JPanel : JPanel draw


	 	// methods

	 public Shapes()// class default constructor without parameterized
	  {
		  frame_width=700; frame_height=515;
		  panel_width=frame_width-100; panel_height=frame_height-180;

		  draw=1;
		  fill=1;

		  paneLIII=null;

		  color_I=Color.BLACK;

	 	  frame_=createWindow("Shapes",frame_width,frame_height);
	 	  paneLI=createPanel(45,10,panel_width,panel_height,Color.LIGHT_GRAY);
	 	  paneLII=createPanel(45,347,panel_width,62,Color.GREEN);
	 	  paneL0=createPanel(45,412,panel_width,60,Color.RED);

	 	  frame_.add(paneLI);// add panel to frame
	 	  frame_.add(paneLII);
	 	  frame_.add(paneL0);
	 	  addElement(paneLII,paneL0);// add element to panel


		  paneLI.setLayout(null);
	 	  paneLII.setLayout(null);

	 	  //frame_.pack(); // delete space to best form
	 	  frame_.setVisible(true);// to be the window visible

	 }

	 public Shapes(int x,int y,String title)// class constructor with parameterized
	  {
		  frame_width=x; frame_height=y;
		  panel_width=x-100; panel_height=y-180;

		  draw=1;
		  fill=1;

		  paneLIII=null;

		  color_I=Color.BLACK;

	 	  frame_=createWindow(title,frame_width,frame_height);
	 	  paneLI=createPanel(45,10,panel_width,panel_height,Color.LIGHT_GRAY);
	 	  paneLII=createPanel(45,347,panel_width,62,Color.GREEN);
	 	  paneL0=createPanel(45,412,panel_width,60,Color.RED);

	 	  frame_.add(paneLI);// add panel to frame
	 	  frame_.add(paneLII);
	 	  frame_.add(paneL0);
	 	  addElement(paneLII,paneL0);// add element to panel


		  paneLI.setLayout(null);
	 	  paneLII.setLayout(null);

	 	  //frame_.pack(); // delete space to best form
	 	  frame_.setVisible(true);// to be the window visible

	 }



	    private JFrame createWindow(String title,int w,int h)  //  create window :  create Frame
		{
		       JFrame frame = new JFrame(title); //  frame constructor with title ...
		       frame.setSize(w,h); // set size of window
		       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default close window button
		       frame.setLayout(null); // no layout because i use my special layout in use function setBounds(x,y,width, height)

		       //frame.setResizable(false); // for stop resizable windo
		       //frame_.setVisible(true);

		       //JFrame Center in screen
		       Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		       frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

		        return frame;
		}


	   private JPanel createPanel(int x,int y,int w,int h,Color c) // create new panel
		{
			 JPanel panel=new JPanel(null); // panel constructor with no layout
			 //panel.setBorder(BorderFactory.createTitledBorder(" ------- ")); // for create border to panel
			 panel.setBackground(c);// Background of panel
			 panel.setBounds(x,y,w,h); // special layout to panel

			 return panel;
        }


    protected void addElement(JPanel panel,JPanel panel1)
 	 {
		 //JPanel panel :green panel
		button_rect = new JButton ("Show Rectangle"); // button constructor with title
		button_rect.setBounds(25, 13,127,36); // button layout
		button_rect.addActionListener(this); // add action to button after Listen to event
		panel.add(button_rect); // add button to panel

		button_oval = new JButton ("Show Oval"); // button constructor with title
		button_oval.setBounds(166, 13,127,36); // button layout
		button_oval.addActionListener(this); // add action to button after Listen to event
		panel.add(button_oval); // add button to panel

		button_arc = new JButton ("Show Arc"); // button constructor with title
		button_arc.setBounds(308, 13,127,36); // button layout
		button_arc.addActionListener(this); // add action to button after Listen to event
		panel.add(button_arc); // add button to panel

		button_poly = new JButton ("Show Polygon"); // button constructor with title
		button_poly.setBounds(450,13,127,36); // button layout
		button_poly.addActionListener(this);  // add action to button after Listen to event
		panel.add(button_poly); // add button to panel

		//JPanel panel1 :green red

		checkBox = new JCheckBox("Fill shapes", true);
		checkBox.setBounds(90, 13, 127, 36);
		checkBox.setBackground(Color.red);
		checkBox.setFont(new Font("Arial", Font.BOLD, 16));
		checkBox.setForeground(Color.green);
		checkBox.addItemListener(this);
		panel1.add(checkBox);

		String[] items = { "BLACK", "RED", "GREN", "BLUE" };
	    comboBox = new JComboBox<String>( items );
	    comboBox.setBounds(247, 13, 100, 36);
	    comboBox.setForeground(Color.green);
	    comboBox.setBackground(Color.red);
	    comboBox.addActionListener(this);
	    panel1.add(comboBox);


	    button_remove=new JButton ("Remove Shape");
		button_remove.setBounds(404, 13,127,36); // button layout
		button_remove.addActionListener(this); // add action to button after Listen to event
		panel1.add(button_remove); // add button to panel



   	}

   	void clear()
   	{
		if(paneLIII != null){frame_.remove(paneLIII); paneLIII=null;}
		else
		if(paneLI != null){frame_.remove(paneLI); paneLI=null;}

	}


       // Item listener for checkBox
       public void itemStateChanged(ItemEvent e)
       {
            if(checkBox.isSelected()){fill=1;}
            else{fill=0;}
	   }


     // action listener for button and comboBox
	 public void actionPerformed(ActionEvent e) // must be public to work
	 {
		 try
		 {
		 // action listener for comboBox
		 //select color of shape want draw by it color

		 if (e.getSource() ==  comboBox)
        {
         if (comboBox.getSelectedIndex()==0)
         {
			color_I=Color.BLACK;
         }
          if (comboBox.getSelectedIndex()==1)
         {
			color_I=Color.RED;
         }
          if (comboBox.getSelectedIndex()==2)
         {
			color_I=Color.GREEN;
         }
          if (comboBox.getSelectedIndex()==3)
         {
			color_I=Color.BLUE;
         }

         }
         else
         {
			 if (e.getSource() == button_remove){ clear(); draw=5; }
		      else

		 // action listener for button
		 //select shape want draw by "Draw->paintComponent"
		 if(e.getSource() == button_poly){ draw=4;} //if select draw Polygon
		 else {
		 if(e.getSource() == button_arc){ draw=3;} //if select draw Arc
		 else{
		 if(e.getSource() == button_oval){ draw=2;} //if select draw Oval
		 else
		 if(e.getSource() == button_rect){ draw=1;} //if select draw Rectangle
		 } }

           clear();

          // draw shape  by "Draw->paintComponent"
		 paneLIII=new Draw();
		 frame_.add(paneLIII);
		 paneLIII.setBackground(Color.LIGHT_GRAY);// Background of panel
		 paneLIII.setBounds(45,10,panel_width,panel_height);

		 if(draw == -999)
		 JOptionPane.showMessageDialog(frame_ ,"sorry unexpected error in draw ");

	 	}

		}

		catch(Exception ee) {JOptionPane.showMessageDialog(frame_ ,"sorry unexpected error"); }
	 	// display message in frame if occurred an error in clear operation

	 }






//main
 public static void main(String[] args)
 {
	Shapes m=new Shapes(700,515,"Shapes");
 }


 }

 class Draw extends JPanel
 {
	 public void paintComponent(Graphics g)
	  {
	  	super.paintComponent(g);
 		try
 		{ g.setColor(Shapes.color_I);
			if(Shapes.draw == 1)//draw Rectangle
			{
				//function used
				//drawRect(int x, int y, int width, int length); // draw Rectangle
				//fillRect(int x, int y, int width, int length); // fill Rectangle

				//in center and horizontal symmetric about Y
				// (((super.getSize().width/2)-((getWidth()/2-5)/2)), ((super.getSize().height/2 )-((getHeight()/2-5)/2)), getWidth()/2-5 , getHeight()/2-5 )

				if(Shapes.fill == 1)
				g.fillRect(((super.getSize().width/2)-((getWidth()/2-5)/2)), ((super.getSize().height/2 )-((getHeight()/2-5)/2)), getWidth()/2-5 , getHeight()/2-5 );
                else
				g.drawRect(((super.getSize().width/2)-((getWidth()/2-5)/2)), ((super.getSize().height/2 )-((getHeight()/2-5)/2)), getWidth()/2-5 , getHeight()/2-5 );

			}
			else
			{
				if(Shapes.draw == 2)// draw Oval
				{
					//function used
					// drawOval(int x, int y, int width, int length); //draw Oval
					//fillOval(int x, int y, int width, int length);  //fill Oval

					//in center and vertical symmetric about X
					// ( ((super.getSize().width/2)-((getHeight()/2-5)/2)), ((super.getSize().height/2 )-((getWidth()/2-5)/2)), getHeight()/2-5 , getWidth()/2-5 )

                      if(Shapes.fill == 1)
					 g.fillOval( ((super.getSize().width/2)-((getHeight()/2-5)/2)), ((super.getSize().height/2 )-((getWidth()/2-5)/2)), getHeight()/2-5 , getWidth()/2-5 );
					 else
					 g.drawOval( ((super.getSize().width/2)-((getHeight()/2-5)/2)), ((super.getSize().height/2 )-((getWidth()/2-5)/2)), getHeight()/2-5 , getWidth()/2-5 );
				}
				else
				{
					if(Shapes.draw == 3)// draw Arc Note : i draw 4 Arc
					{
							int xCenter = getWidth()/2;
							int yCenter = getHeight()/2;
							int radius =(int)(Math.min(getWidth(), getHeight())*0.4);

							 int x = xCenter - radius;
 							 int y = yCenter - radius;

                             //drawArc(int x, int y, int width, int length,int startAngle, int arcAngle); //draw Arc
                             //fillArc(int x, int y, int width, int length,int startAngle, int arcAngle); // fill Arc

							 if(Shapes.fill == 1)
							 {
							 g.fillArc(x, y, 2*radius, 2*radius, 0, 30);
							 g.fillArc(x, y, 2*radius, 2*radius, 90, 30);
							 g.fillArc(x, y, 2*radius, 2*radius, 180, 30);
 							 g.fillArc(x, y, 2*radius, 2*radius, 270, 30);
						     }
						     else
						     {
								g.drawArc(x, y, 2*radius, 2*radius, 0, 30);
								g.drawArc(x, y, 2*radius, 2*radius, 90, 30);
								g.drawArc(x, y, 2*radius, 2*radius, 180, 30);
 							    g.drawArc(x, y, 2*radius, 2*radius, 270, 30);
							 }
					}
					else
					{
						if(Shapes.draw == 4)// draw Polygon
						{
							 int xCenter = getWidth()/2;
							 int yCenter = getHeight()/2;
							 int radius =(int)(Math.min(getWidth(), getHeight())*0.4);

							 // Create a Polygon object
 							 Polygon polygon = new Polygon();

 							 // Add points to the polygon
							 polygon.addPoint(xCenter + radius, yCenter);
							 polygon.addPoint((int)(xCenter + radius*Math.cos(2*Math.PI/6)),
							 (int)(yCenter - radius*Math.sin(2*Math.PI/6)));
							 polygon.addPoint((int)(xCenter + radius*Math.cos(2*2*Math.PI/6)),
							 (int)(yCenter - radius*Math.sin(2*2*Math.PI/6)));
							 polygon.addPoint((int)(xCenter + radius*Math.cos(3*2*Math.PI/6)),
							 (int)(yCenter - radius*Math.sin(3*2*Math.PI/6)));
							 polygon.addPoint((int)(xCenter + radius*Math.cos(4*2*Math.PI/6)),
							 (int)(yCenter - radius*Math.sin(4*2*Math.PI/6)));
							 polygon.addPoint((int)(xCenter + radius*Math.cos(5*2*Math.PI/6)),
 							 (int)(yCenter - radius*Math.sin(5*2*Math.PI/6)));

                              if(Shapes.fill == 1)
                              g.fillPolygon(polygon);// Fill the polygon
 							  else
							  g.drawPolygon(polygon);// Draw the polygon
						}
						else{
							// for clear();
						}
					}
				}
			}
		}
		catch ( Exception e )
		{
			Shapes.draw =-999;

		}
		finally
		{
			// not thing to do
		}

	 }

 }