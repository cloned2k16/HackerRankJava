package es.ledg.hackerrank;

    class                       Timer                               {
        public                  Timer   (String label)              {
            this.label = label;
        }
        private String          label;
        private long            st=-1
                ,               en=0;
        private long            ellapsed = -1;

        public  void            start   ()                          {
            st=System.currentTimeMillis();
        }

        public long             end     ()
                throws          Exception                           {
            if (-1==st) throw new Exception("timer not started yet!");
            en=System.currentTimeMillis();
            ellapsed=en-st;
            return ellapsed;
        }

        public long             getTime ()                          {
            return ellapsed;
        }

        public String           toString()                          {
            return String.format("T:%s::(%f) sec.",label,(float)ellapsed/1000);
        }
    }
