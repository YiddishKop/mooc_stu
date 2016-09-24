/**
 * 这里用的 In 是UCBerkeley cs61b 提供的包
 * 这里用的 Std系列 是 princeton cos 126 提供的包
 *             Std可以通过 http://introcs.cs.princeton.edu/java/home/ 安装
 * @author yiddi
 *
 */
public class STDIN {
	public static void main(String[] args) {

//		String T = args[0];
//		String dt = args[1];
//		String filename = args[2];
//		double radius = readRadius(filename);
//		Planet[] plts = readPlanets(filename);
		
//		--------------------------------------------
		/*
		 * 1) 初识 StdDraw
		 */
//		StdDraw.line(0.0, 0.0, 1.0, 0.0);
//		StdDraw.line(1, 0, 0.5, 1); // 所有的参数都是百分比，而不是具体数值
//		StdDraw.point(0.5, 0.5);
//		--------------------------------------------
		/*
		 * 2) 了解画布
		 */
//		StdDraw.setCanvasSize(500, 500); // 规定了画布的大小
//		/*
//		 * 这个规定了画布的坐标范围
//		 * 1. 0,10 --- 画布大小虽然是500*500 但是x轴被分成10份
//		 * 2. 0,10 --- 表示最 left-lower 的x坐标数字是 0 
//		 *                 最 right-upper 的x坐标数字是 10
//		 */
//		StdDraw.setXscale(0, 10);   
//		/*
//		 * 意义同上
//		 */
//		StdDraw.setYscale(0, 10);
//		StdDraw.setPenRadius(0.01);      // 画笔粗细，这个也是百分比
//		/*
//		 * 一旦规定了scale 大小，那么这个单位就按照scale的每一份为单位
//		 */
//		StdDraw.line(1, 1, 2, 2);        
///		----------------------------------------------
//		/*
//		 *  3） 把美国画下来
//		 */
//		In in = new In("E:/txtFileForTesting/USA.txt");
//		double x0 = in.readDouble();
//		System.out.println("x0 :" + x0);
//		double y0 = in.readDouble();
//		System.out.println("y0 :" + y0);
//		double x1 = in.readDouble();
//		System.out.println("x1 :" + x1);
//		double y1 = in.readDouble();
//		System.out.println("y1 :" + y1);
//		StdDraw.setXscale(x0, x1);
//		StdDraw.setYscale(y0, y1);
//		StdDraw.setPenRadius(0.001);
//		try {
//
//			while(true) {
//				if (in.isEmpty()) {
//					break;
//				}else {
//					double x = in.readDouble();
//					double y = in.readDouble();
//					StdDraw.point(x, y);
//				}
//			}
//			StdDraw.show();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("Drawing DONE!");
//	}
//	---------------------------------------------------
//		/*
//		 * 4) 把函数画下来
//		 */
//		int n = Integer.parseInt(args[0]);
//		double[] x = new double[n + 1]; // 因为要画n条线段，所以需要n+1个点
//		double[] y = new double[n + 1]; // 这里用两个数组分别存放点的所有纵坐标和横坐标
//		for (int i = 0; i <= n; i++) {
//			x[i] = Math.PI * i / n;
//			y[i] = Math.sin(4 * x[i]) + Math.sin(20 * x[i]);
//		}                               // 画点
//		StdDraw.setXscale(0, 2*Math.PI);// 对于设置单位大小有个一般性的技巧：就是不管画布多大，我按照布满的原则即可
//		StdDraw.setYscale(-4.0, 4.0);
//		for (int i = 0; i < n; i++) {
//			StdDraw.line(x[i], y[i], x[i+1], y[i+1]);
//		}                               // 连线
//		/*
//		 * 5) 利用 StdDraw.clear() 做动画 
//		 */
//		// 设置边界
//		StdDraw.setXscale(-1.0, 1.0);
//		StdDraw.setYscale(-1.0, 1.0);
//		// 给出球的信息：半径，速度，初始位置
//		double radius = 0.05;
//		double px = 0.5, py = 0.5;
//		double vx = 0.001, vy = 0.003;
//		// 碰撞检测并刷新
//		while (true) {
//			// 碰撞则变向
//			if(Math.abs(px + vx) > 1 - radius) {
//				vx = -vx;
//				StdAudio.play("E:/txtFileForTesting/ric2.wav");
//				}
//			if(Math.abs(py + vy) > 1 - radius) {
//				vy = -vy;
//				StdAudio.play("E:/txtFileForTesting/ric2.wav");
//				}
//			// 更新球位置
//			px = px + vx;
//			py = py + vy;
//			// 刷新&画球
//			StdDraw.clear(StdDraw.GRAY);
////			StdDraw.setPenColor(StdDraw.BLUE);
////			StdDraw.filledCircle(px, py, radius);
//			StdDraw.picture(px, py, "E:/txtFileForTesting/jugelizi.jpg");
//			StdDraw.show();
//		}
//		/*
//		 * 6) Interaction ： 点击换位置；点击换颜色
//		 */
//		while (true) {
//			if (StdDraw.mousePressed()) {
//				StdDraw.setPenColor(StdDraw.BLUE);
//			}else
//				StdDraw.setPenColor(StdDraw.ORANGE);
//			StdDraw.clear();
//			double x = StdDraw.mouseX();
//			double y = StdDraw.mouseY();
//			StdDraw.filledCircle(x, y, 0.05);
//		}
//		/* TODO
//		 * 7) Interaction: 球跟鼠标，物理模拟
//		 */
//        double rx = 0.0, ry = 0.0;   // position
//        double vx = 0.0, vy = 0.0;   // velocity
//        double mass = 1.0;           // mass
//        double dt   = 0.5;           // time quantum
//        double drag = 0.1;           // mess around with this a bit
//        double attractionStrength = 0.01;
//        
//        // do the animation
////        StdDraw.enableDoubleBuffering();
//        while (true) {
//
//            // compute the attractive force to the mouse, accounting for drag
//            double dx = StdDraw.mouseX() - rx;
//            double dy = StdDraw.mouseY() - ry;
//            double fx = (dx * attractionStrength) - (drag * vx);
//            double fy = (dy * attractionStrength) - (drag * vy);
//    
//            // Euler step: update velocity, then position
//            vx += fx * dt / mass;
//            vy += fy * dt / mass;
//            rx += vx * dt;
//            ry += vy * dt;
//            
//            // draw particle
//            StdDraw.clear();
//            StdDraw.setPenColor(StdDraw.BLUE);
//            StdDraw.filledCircle(rx, ry, 0.02);
//            StdDraw.show();
////            StdDraw.pause(10);
//        }
//		/*TODO
//		 * 8) Interaction：20个球跟鼠标，物理模拟
//		 */
//        int n = 20;
//        double[] rx = new double[n];
//        double[] ry = new double[n];
//        double[] vx = new double[n];
//        double[] vy = new double[n];
//        double dt = 0.5;
//        double mass = 1.0;
//        double drag = 0.05;     // try changing this to 0.1 or 0.01 or even 0...
//        double attractionStrength = 0.01;
//        
//        // initialize the drawing area
//        StdDraw.setPenColor(StdDraw.BLUE);
////        StdDraw.enableDoubleBuffering();
//
//        // do the animation
//        while (true) {
//            // if the mouse is pressed add some random velocity to all the particles
//            if (StdDraw.mousePressed()) {
//                for (int i = 0; i < n; i++) {
//                    vx[i] = 0.2 * Math.random() - 0.1;
//                    vy[i] = 0.2 * Math.random() - 0.1;
//                }
//            }
//            
//            // clear all the forces
//            double[] fx = new double[n];
//            double[] fy = new double[n];
//            
//            // add attraction forces for attraction to the mouse
//            for (int i = 0; i < n; i++) {
//                double dx = StdDraw.mouseX() - rx[i];
//                double dy = StdDraw.mouseY() - ry[i];
//                fx[i] += attractionStrength * dx;
//                fy[i] += attractionStrength * dy;
//            }
//            
//            // add drag forces to all particles
//            // drag is proportional to velocity in the opposite direction
//            for (int i = 0; i < n; i++) {
//                fx[i] += -drag * vx[i];
//                fy[i] += -drag * vy[i];
//            }
//            
//            // update positions
//            // euler step
//            for (int i = 0; i < n; i++) {
//                vx[i] += fx[i] * dt / mass;
//                vy[i] += fy[i] * dt / mass;
//                rx[i] += vx[i] * dt;
//                ry[i] += vy[i] * dt;
//            }
//            
//            
//            StdDraw.clear();
//            
//            // draw a filled circle for each particle
//            for (int i = 0; i < n; i++) {
//                StdDraw.filledCircle(rx[i], ry[i], 0.01);
//            }
//            
//            StdDraw.show();
////            StdDraw.pause(10);
//        }、
//		/* TODO
//		 * 9) Interaction: 模拟Spring 
//		 */
//        // mess around with this, try 7, 8, 9, 10, 11, 12, 15
//        // probably have to turn down the spring force to keep it stable after that...
//        int n = Integer.parseInt(args[0]);
//
//        double[] rx = new double[n];
//        double[] ry = new double[n];
//        double[] vy = new double[n];
//        double[] vx = new double[n];
//        double particleMass = 1.0;
//        double drag = 0.1;
//        double springStrength = 0.1;
//        double springLength = 30;
//        double gravity = 1.0;
//        double timeStep = 0.5;
//        
//        // set up the drawing area
//        StdDraw.setXscale(0, 100);
//        StdDraw.setYscale(0, 100);
//        StdDraw.setPenColor(StdDraw.BLUE);
//        StdDraw.setPenRadius(0.0025);
////        StdDraw.enableDoubleBuffering();
//        
//        // initialize the particle positions randomly
//        for (int i = 0; i < n; i++) {
//            rx[i] = 100 * Math.random();
//            ry[i] = 100 * Math.random();
//        }
//        
//        
//        // do the animation
//        while (true) {
//
//            // clear all the forces
//            double[] fx = new double[n];
//            double[] fy = new double[n];
//            
//            // spring forces act between every pairing of particles
//            // spring force is proportional to the difference between the rest length of the spring
//            // and the distance between the 2 particles it's acting on
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//
//                    if (i == j) continue;
//
//                    // calculate distance between particles i and j
//                    double dx = rx[j] - rx[i];
//                    double dy = ry[j] - ry[i];
//                    double length = Math.sqrt(dx*dx + dy*dy);
//                    
//                    // figure out the force
//                    double force = springStrength * (length - springLength);
//                    double springForceX = force * dx / length;
//                    double springForceY = force * dy / length;
//                    
//                    // update the force
//                    fx[i] += springForceX;
//                    fy[i] += springForceY;
//                }
//            }
//            
//            // add drag force
//            // drag is proportional to velocity but in the opposite direction
//            for (int i = 0; i < n; i++) {
//                fx[i] += -drag * vx[i];
//                fy[i] += -drag * vy[i];
//            }
//            
//            // add gravity forces
//            // just add some force pointing down to all of them
//            for (int i = 0; i < n; i++) {
//                fy[i] += -gravity;
//            }
//            
//            // fix particle 1 at the mouse position
//            rx[0] = StdDraw.mouseX();
//            ry[0] = StdDraw.mouseY();
//            vx[0] = 0.0;
//            vy[0] = 0.0;
//            fx[0] = 0.0;
//            fy[0] = 0.0;
//            
//            // update positions using approximation
//            for (int i = 0; i < n; i++) {
//                vx[i] += fx[i] * timeStep/particleMass;
//                vy[i] += fy[i] * timeStep/particleMass;
//                rx[i] += vx[i] * timeStep;
//                ry[i] += vy[i] * timeStep;
//            }
//            
//            
//            // clear
//            StdDraw.clear();
//            
//            // draw everything
//            for (int i = 0; i < n; i++) {
//                // draw a circle for each node
//                StdDraw.filledCircle(rx[i], ry[i], 1.0);
//                
//                // draw the connections between every 2 nodes
//                for (int j = 0; j < i; j++) {
//                    StdDraw.line(rx[i], ry[i], rx[j], ry[j]);
//                }
//            }
//            
//            // show and wait
//            StdDraw.show();
////            StdDraw.pause(10);
//        }
//		/*TODO
//		 * 10) StdAudio： 初识发音
//		 */
//		int SAMPLE_RATE = 44100;
//		double hz = 440.0;
//		double duration = 10.0;
//		int n = (int) (SAMPLE_RATE * duration);
//		double[] a = new double[n+1];
//		for (int i = 0; i <= n; i++) {
//		   a[i] = Math.sin(2 * Math.PI * i * hz / SAMPLE_RATE); 
//		}
//		StdAudio.play(a); 
//		/*
//		 * 11) StdAudio: 顺序播放 斗来米法骚拉稀
//		 */
//        // repeat as long as there are more integers to read in
//		In in = new In("E:/txtFileForTesting/ascale.txt");
//        while (!in.isEmpty()) {
//
//            // read in the pitch, where 0 = Concert A (A4)
//            int pitch = in.readInt();
//
//            // read in duration in seconds
//            double duration = in.readDouble();
//
//            // build sine wave with desired frequency
//            double hz = 440 * Math.pow(2, pitch / 12.0);
//            int n = (int) (StdAudio.SAMPLE_RATE * duration);
//            double[] a = new double[n+1];
//            for (int i = 0; i <= n; i++) {
//                a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
//            }
//
//            // play it using standard audio
//            StdAudio.play(a);
//            Std
//        }
	
	}
}
