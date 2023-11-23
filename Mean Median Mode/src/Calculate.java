import java.util.ArrayList;

public class Calculate {
	
	public double getMean(double [] a, double counter) {
		double sum = 0;
		for (int i = 0; i < counter; i++) {
			sum += a[i];
		}
		return sum/counter;
	}
	
	public double getMedian(double [] a, int c) {
		int index;
		insertionSort(a, c);
		if (c % 2 == 1) {
			index = c/2;
			return a[index];
		}
		else {
			index = c/2;
			return (a[index - 1] + a[index]) / 2;
		}
	}
	
	public ArrayList<Double> getMode(double [] a, int c) {
	      double maxCount = 0;
	      ArrayList<Double> modes = new ArrayList<Double>();
	      for (int i = 0; i < c; ++i) {
	    	  double count = 0;
	    	  for (int j = 0; j < c; ++j) {
	    		  if (a[j] == a[i])
	    			  count++;
	    	  }
	    	  if (count > maxCount) {
	    		  maxCount = count;
	    		  modes.add(a[i]);
	    	  }
	      }
	      return modes;
	}
	
	public void insertionSort(double [] array, int counter) {
		int size = counter;

		for (int step = 1; step < size; step++) {
			double key = array[step];
			int j = step - 1;
			while (j >= 0 && key < array[j]) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}
	}
}
