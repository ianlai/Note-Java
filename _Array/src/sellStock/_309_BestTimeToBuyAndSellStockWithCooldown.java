package sellStock;

import java.util.Arrays;

public class _309_BestTimeToBuyAndSellStockWithCooldown {

	public static void main(String[] args) {
		_309_BestTimeToBuyAndSellStockWithCooldown obj = new _309_BestTimeToBuyAndSellStockWithCooldown();
		int[] prices = new int[]{4,2,1,5,6,2,4,8}; //1-5=>4, 2-8=>6  ===>10
		System.out.println(Arrays.toString(prices));
		System.out.println(obj.maxProfit(prices));
	}
	
	/* DP-Tabulation (slow)*/
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] table = new int[len][len];
        return dp(0, len-1, prices, table);
    }
    private int dp(int l, int r, int[] p, int[][] t){
    	System.out.println(l + "-"+ r);
    	if(l<0 || r<0) return 0;
    	if(l>=r) return 0;
    	
    	if(t[l][r]!=0){
    		// do nothing
    	}else{
    		int includeR = 0;
    		for(int i=l; i<r; i++){
    			if(i<=2){
    				if(p[i]<p[r])
    					includeR = Math.max(includeR, p[r]-p[i]);
    			}else{
    				if(p[i]<p[r])
    					includeR = Math.max(includeR, p[r]-p[i]+dp(l,i-2,p,t));
    			}
    		}
    		int excludeR = dp(l,r-1, p, t);
    		t[l][r] = Math.max(includeR, excludeR);
    	}
    	return t[l][r];
    }
}

