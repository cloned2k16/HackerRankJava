package es.ledg.hackerrank.SherlockPairs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import es.ledg.hackerrank.SolutionBase;

//------------------------------------- --------------------------- --------------------------------
    public class                        Solution
    extends                             SolutionBase                                                {


        private static long             getPairs                    (int[] a)                       {
            long sum = 0;
            int  len = a.length;
            for ( int i = 1 ; i < len  ; i++ ) {
                long c = 1;
                int p=a[i-1],p1;
                while ( i < len && (p1=a [ i ]) == p ) {
                    c++;
                    p=p1;
                    i++;
                }
                sum +=  (c * ( c-1 ));
            }
            return sum;
        }

        public
        static
        void                            main                        (String[] args)                 {
            try {
                BufferedReader inB = new BufferedReader(new InputStreamReader(System.in));
                int T = Integer.parseInt(inB.readLine());

                for (int tn=0; tn<T; tn++){
                     int N = Integer.parseInt(inB.readLine());
                        int[] A = new int[N];
                        int n = 0;
                        for (String as: inB.readLine().split(" ")){
                            A[n++] = Integer.parseInt(as);
                        }
                        if (n!=N) throw new Exception ("Invalid input!");
                        Arrays.sort(A);

                        long res=getPairs(A);
                        System.out.println(res);
                }
            }
            catch(Exception e){
                _out("Exception: %s",e.getMessage());
            }
        }



    }
//------------------------------------- --------------------------- --------------------------------
