package java6;

/**
 * @author 冯振卓
 * @ 2022/1/10 17:42
 */
public class NineNine {
    public static void main(String[] args){
        for(int i=1;i<=9;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+"*"+i+"="+i*j+'\t');
            }
            System.out.println();
        }
    }
}
