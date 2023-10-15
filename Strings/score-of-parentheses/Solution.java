class Solution {
    public int scoreOfParentheses(String s) {
        //recursive

        int value = scoreOfParenthesesUtil(s,0,s.length()-1);
        return value;



    }

    private int scoreOfParenthesesUtil (String s,int start, int end) {

        if(start+1==end && s.charAt(start)=='(' && s.charAt(end)==')'){
            return 1;
        }

        int bal=0;
        int v=0;

        for(int i=start;i<=end;i++) {
            if(s.charAt(i)=='(') {
                bal++;
            }
            else if(s.charAt(i)==')') {
                bal--;
                if(bal==0) {
                    if(i!=end) {
                        v=scoreOfParenthesesUtil(s,start,i)+scoreOfParenthesesUtil(s,i+1,end);
                        i=end+1;
                    }
                    else {
                        v=2*scoreOfParenthesesUtil(s,start+1,end-1);
                        i=end+1;
                    }
                }
            }

        }

        return v;


    }


}