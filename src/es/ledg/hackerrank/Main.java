package es.ledg.hackerrank;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.lang.reflect.Method;

//------------------------------------- --------------------------- --------------------------------
    public class                        Main
    extends                             BaseObject                  {


        static
        public  void                    main                        ( String args[] )               {
            Main me = new Main();
            me._main(args);
        }


        public void                     _main                       (String args[]){

            try{
                doTest ("SherlockPairs", new int [] { 0 , 3} );
            }
            catch (Exception e){
                _log("Exception %s",e.getMessage());
            }
        }

        void                            doTest                      (String className, int [] tests)
                throws                  Exception                                                   {

            if (tests==null) throw new Exception ("Invalid argument! tests can't be null!");

            String packageName      = "es.ledg.hackerrank";
            String fullPackageName  = packageName+"."+className;
            String fullClassName    = fullPackageName+".Solution";

            Class<?> [] paramsType      =  { String[].class };
            try {

                                classe   = Class.forName(fullClassName);
                Method          testMthd = classe.getMethod("main", paramsType);
                int nt=tests.length;
                for (int tn=0; tn<nt; tn++){
                    String tN=String.format("%02d", tests[tn]);
                    String          basePath=  "bin/"+fullPackageName.replace('.', '/')+"/";
                    String          fileOut =   String.format(basePath+"output%s.txt"   , tN);
                    String          fileRes =   String.format(basePath+"res%s.txt"      , tN);
                    String          fileIn  =   String.format(basePath+"input%s.txt"    , tN);
                    System.setOut   (new PrintStream(new FileOutputStream(new File(fileRes))));
                    System.setIn    (new FileInputStream(new File(fileIn)));
                    testMthd.invoke(null,new Object [] { new String[] {}});
                    System.setOut   (new PrintStream(new FileOutputStream(FileDescriptor.out)));
                    System.setIn    (new BufferedInputStream(new FileInputStream(FileDescriptor.in)));

                    BufferedReader fOut=new BufferedReader(new FileReader(fileOut));
                    BufferedReader fRes=new BufferedReader(new FileReader(fileRes));
                    String line;
                    int ln=0;
                    boolean errorAny=false;
                    while (null!= (line = fOut.readLine())){
                      String rLine=fRes.readLine();
                      if (!line.equals(rLine)){
                          _log("Error at line: %d res: '%s' != out: '%s'",ln,rLine,line);
                          errorAny=true;
                      }
                      ln++;
                    }
                    fOut.close();
                    fRes.close();
                    if (errorAny)   _log("[%s] Error!"  ,tN);
                    else            _log("[%s] Done."   ,tN);
                }
            }
            catch       ( ClassNotFoundException    e)      { _log(e); }
            catch       ( NoSuchMethodException     e)      { _log(e); }
            catch       ( SecurityException         e)      { _log(e); }
            catch       (Throwable t)                       { _log(t); }


        }
    }
//------------------------------------- --------------------------- --------------------------------
