package Array;

import java.awt.*;
import java.util.ArrayList;

public  class CommonUtil {
    public  static  void  checkList(ArrayList list){
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+",");
        }
        System.out.println();
    }

}
