package es.ledg.hackerrank;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

//------------------------------------- --------------------------- --------------------------------
	public class 						BaseObject 					{
		protected Class<?> 				classe		=	null;
		private static PrintStream 		out			=	System.out;

		public void 					_log						(Object  ...args) 				{
			 String fmt = "[";
			 for(int i=0; i<args.length; i++) fmt+=((i==0)?"":",")+"%s";
			 _log(fmt+"]",args);
		}
		
		protected void					_log						(String fmt, Object ... args)	{
			for (int n=0; n<args.length; n++) {
				Object o=args[n];
				if (o instanceof int[]) 	args[n] = Arrays.toString((int[])o);
				if (o instanceof Exception) {
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					PrintStream 			ps = new PrintStream(baos);
					((Throwable)o).printStackTrace(ps);
					args[n] = baos.toString();
				}
			}
		 	String msg = String.format(fmt, args);
		 	out.println(msg);
	 	}
	}
//------------------------------------- --------------------------- --------------------------------
