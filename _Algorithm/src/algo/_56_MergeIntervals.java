package algo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _56_MergeIntervals {

    class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	      
	      @Override
	      public String toString(){
	    	  return "[" + start + " - " + end + "]";
	      }
	      public int compareTo(Interval iv){
	    	  return this.start - iv.start;
	      }
	}


	 
	public static void main(String[] args) {
		_56_MergeIntervals MI = new _56_MergeIntervals();
		MI.run();
	}
	
	public void run(){
		List<Interval> mIntervals = new ArrayList<Interval>();

		mIntervals.add(new Interval(8,10));
		mIntervals.add(new Interval(1,3));
		mIntervals.add(new Interval(2,6));
		mIntervals.add(new Interval(15,18));
		for(Interval interval: mIntervals){
			System.out.println(interval);
		}
		
		System.out.println("");
		
		List<Interval> mResults = merge(mIntervals);
		for(Interval interval: mResults){
			System.out.println(interval);
		}
	}
	public List<Interval> merge(List<Interval> intervals) {
		if(intervals.size()<=1) return intervals;
	    Comparator<Interval> comparator = new Comparator<Interval>() {
	        @Override
	        public int compare(Interval left, Interval right) {
	            return left.start- right.start; 
	        }
	    };
		Collections.sort(intervals, comparator);
		List<Interval> result = new ArrayList<Interval>();
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		
		for(Interval interval: intervals){
			if(interval.start <= end){
				end = end>interval.end ? end : interval.end;
			}else{
				result.add(new Interval(start,end));
				start = interval.start;
				end = interval.end;
			}
		}
		result.add(new Interval(start,end));
		return result;
	}

}


