package edu.gatech_heatedplate;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import edu.gatech.heatedplate.Tpdohp.ObjectPlate;
import edu.gatech.heatedplate.Tpdohp.TpdohpCommand;
import edu.gatech.heatedplate.tpdahp.TpdahpCommand;
import edu.gatech.heatedplate.tpdahp.TpdahpPlate;
import edu.gatech.heatedplate.tpfahp.TpfahpCommand;
import edu.gatech.heatedplate.tpfahp.TpfahpPlate;
import edu.gatech.heatedplate.twfahp.TwfahpCommand;
import edu.gatech.heatedplate.twfahp.TwfahpPlate;

public class precisionTest {

	@Test
	public void test() {
		long time ;
		Random rand = new Random(42);
		Runtime runtime = Runtime.getRuntime();
		long mem;
		long premem;
		long postmem;
		int[] size = {10,20, 50 ,100 };
		double[] precision = {0.1, 0.01, 0.001};//, 0.0001}; //, 0.00001 , 0.000001, 0.0000001 };
		double[][] sides = {{
			rand.nextDouble() * 100, rand.nextDouble() * 100, rand.nextDouble() * 100, rand.nextDouble() * 100
		},
		{	rand.nextDouble() * 100, rand.nextDouble() * 100, rand.nextDouble() * 100, rand.nextDouble() * 100
		},
		{	rand.nextDouble() * 100, rand.nextDouble() * 100, rand.nextDouble() * 100, rand.nextDouble() * 100
		}
		};
		
		if( true ){
		for ( int i = 0 ; i < size.length ; i += 1) {
			for ( int j = 0  ; j < precision.length ; j+= 1){  
                for ( int h = 0 ; h < sides.length; h += 1){
                	runtime.gc();
                	premem = runtime.totalMemory()-runtime.freeMemory();
                	time = System.currentTimeMillis();
                	double pre = precision[j];
                	int d = size[i];
                	double[] s = sides[h];
                	ObjectPlate heatedPlate = new ObjectPlate( d, d, s[0], s[1] , s[2] , s[3] );
//                	heatedPlate.intializePlate();
                	TpdohpCommand tpdohp = new TpdohpCommand(heatedPlate);
        //		      heatedPlate.print();
                         
                	do{
                               
                		heatedPlate = (ObjectPlate) tpdohp.execute(heatedPlate);
        //		        if (heatedPlate.getIteration() % 1000 == 0 ){
                		runtime.gc();
                		postmem = runtime.totalMemory()-runtime.freeMemory();
        //		        }
                	} while (tpdohp.getMaxDelta() > pre );//&& tpdohp.getMaxDelta() > 0.01);
                             // }  while (tpfahp.getPercision() < 0.01f);
                System.out.println("tpdohp\t"+
                             d+"\t"+
                             pre+"\t"+
                             heatedPlate.getIteration()+"\t"+
                             (System.currentTimeMillis()-time)+"\t"+
                             premem+"\t" + postmem+"\t" +
                             s[0]+"\t"+s[1]+"\t"+s[2]+"\t"+s[3]);
       
        //		      System.out.println("Number of Iterations=" + tpdohp.getIteration());
        //		      heatedPlate.print();
               
                }
			}
		}
	}
	 if(true){	
		for ( int i = 0 ; i < size.length ; i += 1) {
			for ( int j = 0  ; j < precision.length ; j+= 1){  
                for ( int h = 0 ; h < sides.length; h += 1){
                	time = System.currentTimeMillis();
                	runtime.gc();
                	premem = runtime.totalMemory()-runtime.freeMemory();
                	double pre = precision[j];
                	int d = size[i];
                	double[] s = sides[h];
                	
          		  TpdahpPlate heatedPlate = new TpdahpPlate( d, s[0], s[1] , s[2] , s[3]);
        	      TpdahpCommand tpdahp = new TpdahpCommand(heatedPlate);
        	      
        	 
        	      do{
                       
        	        heatedPlate = (TpdahpPlate) tpdahp.execute(heatedPlate);
        	        runtime.gc();
            		postmem = runtime.totalMemory()-runtime.freeMemory();
        	      } while ( tpdahp.getMaxDelta() > pre);
                	 
                System.out.println("tpdahp\t"+
                             d+"\t"+
                             pre+"\t"+
                             heatedPlate.numIterations+"\t"+
                             (System.currentTimeMillis()-time)+"\t"+
                             premem+"\t" + postmem+"\t" +
                             s[0]+"\t"+s[1]+"\t"+s[2]+"\t"+s[3]);
       
        //		      System.out.println("Number of Iterations=" + tpdohp.getIteration());
        //		      heatedPlate.print();
               
                }
			}
		}
	 }
	 if(true){	
		for ( int i = 0 ; i < size.length ; i += 1) {
			for ( int j = 0  ; j < precision.length ; j+= 1){  
                for ( int h = 0 ; h < sides.length; h += 1){
                	time = System.currentTimeMillis();
                	runtime.gc();
                	premem = runtime.totalMemory()-runtime.freeMemory();
                	double pre = precision[j];
                	int d = size[i];
                	double[] s = sides[h];
                	
          		  TpfahpPlate heatedPlate = new TpfahpPlate( d, (float)s[0], (float)s[1] , (float)s[2] , (float)s[3]);
        	      TpfahpCommand tpdahp = new TpfahpCommand(heatedPlate);
        	      
        	 
        	      do{
                       
        	        heatedPlate = (TpfahpPlate) tpdahp.execute(heatedPlate);
        	        runtime.gc();
            		postmem = runtime.totalMemory()-runtime.freeMemory();
        	      } while ( tpdahp.getMaxDelta() > pre);
                	 
                System.out.println("tpfahp\t"+
                             d+"\t"+
                             pre+"\t"+
                             heatedPlate.numIterations+"\t"+
                             (System.currentTimeMillis()-time)+"\t"+
                             premem+"\t" + postmem+"\t" +
                             s[0]+"\t"+s[1]+"\t"+s[2]+"\t"+s[3]);
       
        //		      System.out.println("Number of Iterations=" + tpdohp.getIteration());
        //		      heatedPlate.print();
               
                }
			}
		}
	 }
		
	 if(true){	
		for ( int i = 0 ; i < size.length ; i += 1) {
			for ( int j = 0  ; j < precision.length ; j+= 1){  
                for ( int h = 0 ; h < sides.length; h += 1){
                	time = System.currentTimeMillis();
                	runtime.gc();
                	premem = runtime.totalMemory()-runtime.freeMemory();
                	double pre = precision[j];
                	int d = size[i];
                	double[] s = sides[h];
                	
          		  TwfahpPlate heatedPlate = new TwfahpPlate( d, new Float(s[0]),
          				  new Float(s[1]) , new Float(s[2]) , new Float(s[3]));
        	      TwfahpCommand tpdahp = new TwfahpCommand(heatedPlate);
        	      
        	 
        	      do{
                       
        	        heatedPlate = (TwfahpPlate) tpdahp.execute(heatedPlate);
        	        runtime.gc();
            		postmem = runtime.totalMemory()-runtime.freeMemory();
        	      } while ( tpdahp.getMaxDelta() > pre);
                	 
                System.out.println("twfahp\t"+
                             d+"\t"+
                             pre+"\t"+
                             heatedPlate.numIterations+"\t"+
                             (System.currentTimeMillis()-time)+"\t"+
                             premem+"\t" + postmem+"\t" +
                             s[0]+"\t"+s[1]+"\t"+s[2]+"\t"+s[3]);
       
        //		      System.out.println("Number of Iterations=" + tpdohp.getIteration());
        //		      heatedPlate.print();
               
                }
			}
		}
	 }
		
		
		assertTrue("",true );
	}

}
