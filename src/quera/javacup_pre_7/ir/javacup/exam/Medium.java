package quera.javacup_pre_7.ir.javacup.exam;

public enum Medium {
  VACUUM(1),
  WATER(1.33),
  GLASS(1.5),
  DIAMOND(2.4);


  private final double n;
  private Medium(double n) { this.n = n; }
  public double n() { return this.n; }

  public double criticalAngle(Medium other) {
    if(this.n <= other.n) throw new NoCriticalAngleException();
    double st1 = (other.n/this.n);
    double rads = Math.asin(st1);
    return rads * (180/Math.PI);
  }

  public double criticalAngle() {
	 return criticalAngle(Medium.VACUUM);
  }
}


