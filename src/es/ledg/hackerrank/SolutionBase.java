package es.ledg.hackerrank;

public class                            SolutionBase                {
    public static
    int                                 maxArrayStringValuesToShow  =   11;

    public static
    void                                _out                        (String fmt, Object ...args){
        int len=args.length;
        for (int i=0; i<len; i++){
            Object oo=args[i];
            if (oo instanceof String[]){
                String expldd="[";
                String [] sa=(String[])oo;
                int max=maxArrayStringValuesToShow;
                int al=sa.length;
                if (al==0) expldd="[]";
                else{
                    int si=0;
                    for (si=0; max>0 && si<al;si++){
                        expldd+=sa[si]+", ";
                    }
                    if (si<al) expldd+=" ...]";
                    else expldd=expldd.substring(0, expldd.length()-2)+"]";
                }
                args[i]=expldd;
            }
        }
        String msg = String.format(fmt, args);
        System.out.println(msg);
    }

}
