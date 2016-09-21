
public class Planet {
	public double xxPos; // its current x position
	public double yyPos; // its current y position
	public double xxVel; // its current velocity in x direction
	public double yyVel; // its current velocity in y direction
	public double mass; // its mass
	public String imgFileName; // its name of an image in the images directory
								// that

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass  = p.mass;
		imgFileName = p.imgFileName;
	}
}
