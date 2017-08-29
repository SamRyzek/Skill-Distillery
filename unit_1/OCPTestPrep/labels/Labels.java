package labels;

public class Labels {
	public static void main(String[] args) {
		System.out.println(heads());

//		blockLabels();
//		loopLabels();
	}
	
	static boolean heads() { return Math.random() < .5 ? true : false; }
	
	static void blockLabels() {
		// Which commented statements will compile?
		System.out.println("Before FOO block");
		// Any block or statement can be labeled.
		FOO: 
	    {
			System.out.println("Before BAR block");
			BAR: {
				System.out.println("Before BAZ block");
				BAZ: {
//		            if (heads()) continue; 
//		            if (heads()) continue BAR;
//		            if (heads()) break;
//					if (heads()) break BAZ;
//					if (heads()) break BAR;
//					if (heads()) break FOO;
					QUX: System.out.println("Statement labeled QUX");
//					if (heads()) break QUX;
				}
				System.out.println("After BAZ block");
//				if (heads()) break BAZ;
//				if (heads()) break BAR;
//				if (heads()) break FOO;
			}
			System.out.println("After BAR block");
//			if (heads()) break BAZ;
//			if (heads()) break BAR;
//			if (heads()) break FOO;
		}
	    System.out.println("After FOO block");
//		if (heads()) break BAZ;
//		if (heads()) break BAR;
//		if (heads()) break FOO;
//		if (heads()) break;   
	}
	
	static void loopLabels() {
		int i, j, k;
	    ILOOP:
	    	for (i=0; i<10; i++) {
	    		System.out.println("ILOOP begin, i="+i);
	    		JLOOP:
	    		for (j=0; j<10; j++) {
	    			System.out.println("  JLOOP begin, i="+i+", j="+j);
	    			KLOOP:
	    			for (k=0; k<10; k++) {
	    				System.out.println("    KLOOP begin, i="+i+", j="+j+", k="+k);
	    				if (heads()) {System.out.println("    break");break;} // unlabeled break in loop
	    				if (heads()) {System.out.println("    continue");continue;} // unlabeled continue in loop
	    				if (heads()) {System.out.println("    break KLOOP");break KLOOP;} // labeled break in loop
	    				if (heads()) {System.out.println("    continue KLOOP");continue KLOOP;} // labeled continue in loop
	    				if (heads()) {System.out.println("    break JLOOP");break JLOOP;} 
	    				if (heads()) {System.out.println("    continue JLOOP");continue JLOOP;} 
	    				if (heads()) {System.out.println("    break ILOOP");break ILOOP;}
	    				if (heads()) {System.out.println("    continue ILOOP");continue ILOOP;}
	    				System.out.println("    KLOOP end, i="+i+", j="+j+", k="+k);
	    			}
	    		    System.out.println("    After KLOOP, k="+k);
    				if (heads()) {System.out.println("  break");break;}
    				if (heads()) {System.out.println("  continue");continue;}
    				if (heads()) {System.out.println("  break JLOOP");break JLOOP;} 
    				if (heads()) {System.out.println("  continue JLOOP");continue JLOOP;} 
    				if (heads()) {System.out.println("  break ILOOP");break ILOOP;}
    				if (heads()) {System.out.println("  continue ILOOP");continue ILOOP;}
	    			System.out.println("  JLOOP end, i="+i+", j="+j);
	    		}
	    	    System.out.println("  After JLOOP, j="+j);
	    		if (heads()) {System.out.println("break");break;}
	    		if (heads()) {System.out.println("continue");continue;}
	    		if (heads()) {System.out.println("break ILOOP");break ILOOP;}
	    		if (heads()) {System.out.println("continue ILOOP");continue ILOOP;}
	    		System.out.println("ILOOP end, i="+i);
	    	}
	    System.out.println("After ILOOP, i="+i);
	}

}
