package sellStock;

public class _121_BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		_121_BestTimeToBuyAndSellStock obj = new _121_BestTimeToBuyAndSellStock();
		int[] arr = new int[]{3,5,6,4,16,2,1,6,9};
		int res = obj.maxProfit(arr);
		System.out.println(res);
	}
    public int maxProfit(int[] prices) {
        int pl = prices.length;
        if(pl<=1) return 0;
        int max = 0;
        int currentMin = prices[0];
        for(int i=0; i<pl; i++){
            if(prices[i]<currentMin){
                currentMin = prices[i];
            }else{
                max = Math.max(max, prices[i]-currentMin);
            }
        }
        return max;
    }
}