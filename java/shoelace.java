/*
	 * Return area of polygon formed by points given. Area is negative if points were given in counterclockwise order, positive if given in clockwise order
	 * Points must be given in either clockwise or counterclockwise order.
	 */
	private static double shoelace(double[] x, double[] y) {
		double c = 0.0;
		int n = x.length;
		int j = n-1;
		for(int i = 0; i < n; i++) {
			c += (x[j] + x[i]) * (y[j] - y[i]);
			j = i;
		}
		
		return c/2.0;
	}