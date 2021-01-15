package String;

public class ReplaceSpace {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer(" helloWorld");
        System.out.println(replaceSpace(sb));

    }
    //请实现一个函数，将一个字符串中的每个空格替换成“%20”。
    // 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
    public static String replaceSpace(StringBuffer str) {
      //问题：1。是否原地替换
        //   2。从前往后替换会导致空格后面的每个元素在每次替换中都要移动，从后往前则只需要移动一次
        int spaceNum = 0 ;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==' ')spaceNum++;
        }
        int oldLength =str.length();
        int newLength = str.length()+spaceNum*2;
        str.setLength(newLength);
        for (int i = oldLength-1; i >=0&&newLength>0; i--) {
            if (str.charAt(i)==' '){
                str.setCharAt(--newLength,'0');
                str.setCharAt(--newLength,'2');
                str.setCharAt(--newLength,'%');
            }else {
                str.setCharAt(--newLength,str.charAt(i));
            }
        }

        return str.toString();
    }
}
