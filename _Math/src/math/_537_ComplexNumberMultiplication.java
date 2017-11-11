package math;

public class _537_ComplexNumberMultiplication {

	public static void main(String[] args) {
		_537_ComplexNumberMultiplication obj = new _537_ComplexNumberMultiplication();
		String a = "3+7i";
		String b = "9+-4i";
		String res = obj.complexNumberMultiply(a, b);
		System.out.println(a);
		System.out.println(b);
		System.out.println(res);
	}

    public String complexNumberMultiply(String a, String b) {
        if(a==null && b==null) return null;
        if(a==null && b!=null) return b;
        if(a!=null && b==null) return a;
        
        String[] asplit = a.split("\\+");
        int a1=Integer.parseInt(asplit[0]);
        int a2=Integer.parseInt((asplit[1].split("i"))[0]);
        String[] bsplit = b.split("\\+");
        int b1=Integer.parseInt(bsplit[0]);
        int b2=Integer.parseInt((bsplit[1].split("i"))[0]);
        
        int re = a1*b1-a2*b2;
        int im = a1*b2+a2*b1;
        String result = re+"+"+im+"i";
        return result;
    }

}