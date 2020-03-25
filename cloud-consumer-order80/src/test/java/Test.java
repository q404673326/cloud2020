public class Test {

    public static void main(String[] args) {
        int n;
        n = fun(5);
        System.out.println(n+"个桃子");	//3906个桃子
    }
    private static int fun(int i){
        if(i == 0){
            return 1;
        }else{
            return fun(i-1)*5+1;
        }
    }
}
