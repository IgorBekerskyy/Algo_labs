package algo_lab_1;

import java.util.List;

public class BubbleSorting {

    protected static void bubbleSortingByVolumeOfFuel(List<Plane> planeList) {
        System.out.println("Bubble-sort");
        int sizeOfList = planeList.size();
        Plane tempPlane;
        
     boolean isSorted=false;
     while(!isSorted) {
     isSorted=true;
      for(int i = 0; i < (sizeOfList -1); i++){
    	  if(planeList.get(i).getVolumeOfFuelTanksInLiters() < planeList.get(i+1).getVolumeOfFuelTanksInLiters()) {
    		  tempPlane=planeList.get(i);
    		  planeList.set(i, planeList.get(i+1));
    		  planeList.set(i+1, tempPlane);
    		  isSorted=false;
    	  }
    	  
      }     
     } 
          
        for (Plane plane : planeList) {
            System.out.println(plane.toString());
        }
    }

}
